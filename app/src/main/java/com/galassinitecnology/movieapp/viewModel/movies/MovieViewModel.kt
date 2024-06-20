package com.galassinitecnology.movieapp.viewModel.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galassinitecnology.movieapp.api.model.event.Event
import com.galassinitecnology.movieapp.api.model.request.MovieRequest
import com.galassinitecnology.movieapp.api.model.response.categories.CategoriesResponse
import com.galassinitecnology.movieapp.api.model.response.movies.Movie
import com.galassinitecnology.movieapp.api.model.type.DataState
import com.galassinitecnology.movieapp.api.model.type.MovieType
import com.galassinitecnology.movieapp.dao.MovieDao
import com.galassinitecnology.movieapp.repository.movie.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel(
    private val repository: MovieRepository,
    private val movieDao: MovieDao
):  ViewModel() {

    val error: LiveData<String>
        get() = _error

    private val _error = MutableLiveData<String>()

    val appState: LiveData<DataState>
        get() = _appState

    private val _appState = MutableLiveData<DataState>()

    val moviesPlaying: LiveData<List<Movie>?>
        get() = _moviesPlaying

    private val _moviesPlaying = MutableLiveData<List<Movie>?>()

    val moviesPopular: LiveData<List<Movie>?>
        get() = _moviesPopular

    private val _moviesPopular = MutableLiveData<List<Movie>?>()

    val moviesTop: LiveData<List<Movie>?>
        get() = _moviesTop

    private val _moviesTop = MutableLiveData<List<Movie>?>()


    val moviesDetail: LiveData<Movie>
        get() = _moviesDetail

    private val _moviesDetail = MutableLiveData<Movie>()

    val categories: LiveData<CategoriesResponse>
        get() = _categories

    private val _categories = MutableLiveData<CategoriesResponse>()

    val navigationToDetailsLiveData
        get() = _navigationToDetailsLiveData

    private val _navigationToDetailsLiveData = MutableLiveData<Event<Unit>>()

    init {
        _appState.postValue(DataState.Loading)
    }

    fun getCategories(language: String = "en"){

        viewModelScope.launch {
            val result = repository.getCategories(language)

            result.fold(
                onSuccess = {
                    _categories.value = it
//                    _appState.value = DataState.Success
                },
                onFailure = {
                    it.message?.let { e ->
                        Log.e("Error", e)
                        _error.value = e
                    }
                    _appState.value = DataState.Error
                }
            )
        }
    }

    fun getMoviesPlaying(post: MovieRequest){
        _appState.postValue(DataState.Loading)

        viewModelScope.launch {

            val result = repository.getMoviesPlaying(post)
            Log.e("TAG", "getMoviesPlaying: $result" )
            result.fold(
                onSuccess = {
                    it?.let { response -> persistMovieData(response.results)  }
                    _moviesPlaying.value = it?.results
                    _appState.value = DataState.Success
                },
                onFailure = {
                    errorHandle(it.message.toString(), MovieType.PLAYING)
                }
            )
        }
    }

    fun getMoviesPopular(post: MovieRequest){
        _appState.postValue(DataState.Loading)

        viewModelScope.launch {
            val result = repository.getMoviesPopular(post)
            Log.e("TAG", "getMoviesPopular: $result")
            result.fold(
                onSuccess = {
//                    it?.let { response -> persistMovieData(response.results)  }
                    _moviesPopular.value = it?.results
                    _appState.value = DataState.Success
                },
                onFailure = {
                    errorHandle(it.message.toString(), MovieType.POPULAR)
                }
            )
        }
    }

    fun getMoviesTop(post: MovieRequest){
        _appState.postValue(DataState.Loading)

        viewModelScope.launch {
            val result = repository.getMoviesTop(post)
            Log.e("TAG", "getMoviesTop: $result" )
            result.fold(
                onSuccess = {
//                    it?.let { response -> persistMovieData(response.results)  }
                    _moviesTop.value = it?.results
                    _appState.value = DataState.Success
                },
                onFailure = {
                    errorHandle(it.message.toString(), MovieType.TOP)
                }
            )
        }
    }

    fun onMovieSelected(position: Int, movieType: MovieType){
        _moviesDetail.postValue(
            when(movieType){
                MovieType.PLAYING -> _moviesPlaying.value?.get(position)
                MovieType.POPULAR -> _moviesPopular.value?.get(position)
                MovieType.TOP -> _moviesTop.value?.get(position)
            }
        )
        _navigationToDetailsLiveData.postValue(Event(Unit))

    }

    fun onMovieSelected(movie: Movie) {
        _moviesDetail.postValue(movie)
        _navigationToDetailsLiveData.postValue(Event(Unit))
    }

    private suspend fun persistMovieData(movieList: List<Movie>?) {
        movieList?.let {
            movieDao.deleteAll()
            movieDao.insertList(movieList)
        }

    }

    private suspend fun errorHandle(error: String, playing: MovieType){
        val movieList = loadPersistedMovieData()

        Log.e("TAG", "errorHandle: $movieList")
        if(movieList.isNullOrEmpty()){
            _error.value = error
            _appState.value = DataState.Error
        } else {
            Log.e("TAG", "errorHandleIsNotEmpty: $movieList")
            when(playing){
                MovieType.PLAYING -> _moviesPlaying.value = movieList
                MovieType.POPULAR -> _moviesPopular.value = movieList
                MovieType.TOP -> _moviesTop.value = movieList
            }
            _appState.value = DataState.Success
        }

    }

    private suspend fun loadPersistedMovieData() = movieDao.getAll()

}