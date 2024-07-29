package com.galassinitecnology.movieapp.viewModel.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.galassinitecnology.movieapp.api.model.request.MovieRequest
import com.galassinitecnology.movieapp.api.model.response.categories.CategoriesResponse
import com.galassinitecnology.movieapp.api.model.response.movies.Dates
import com.galassinitecnology.movieapp.api.model.response.movies.Movie
import com.galassinitecnology.movieapp.api.model.response.movies.MovieResponse
import com.galassinitecnology.movieapp.api.model.type.DataState
import com.galassinitecnology.movieapp.dao.MovieDao
import com.galassinitecnology.movieapp.repository.movie.MovieRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class MovieViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MovieRepository

    @Mock
    private lateinit var movieDao: MovieDao

    private lateinit var viewModel: MovieViewModel

    @Mock
    private lateinit var categoriesObserver: Observer<CategoriesResponse>

    @Mock
    private lateinit var moviesPlayingObserver: Observer<List<Movie>?>

    @Mock
    private lateinit var appStateObserver: Observer<DataState>

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = MovieViewModel(repository, movieDao)
        viewModel.categories.observeForever(categoriesObserver)
        viewModel.moviesPlaying.observeForever(moviesPlayingObserver)
        viewModel.appState.observeForever(appStateObserver)
    }

    @Test
    fun `getCategories should post categories on success`() = runTest {
        val categoriesResponse = CategoriesResponse(listOf())
        `when`(repository.getCategories(anyString())).thenReturn(Result.success(categoriesResponse))

        viewModel.getCategories("en")

        verify(categoriesObserver).onChanged(categoriesResponse)
        verify(appStateObserver, never()).onChanged(DataState.Error)
    }

    @Test
    fun `getMoviesPlaying should post movies on success`() = runTest {
        val movie = Movie(
            id = 1,
            title = "Sample Movie",
            adult = false,
            backdropPath = "/path/to/backdrop",
            originalLanguage = "en",
            originalTitle = "Original Title",
            overview = "Overview of the movie",
            popularity = 10.0,
            posterPath = "/path/to/poster",
            releaseDate = "2024-07-26",
            video = false,
            voteAverage = 8.0,
            voteCount = 100
        )
        val movieResponse = MovieResponse(
            dates = Dates("2024-07-01", "2024-07-31"),
            page = 1,
            results = listOf(movie),
            totalPages = 1,
            totalResults = 1
        )
        val movieRequest = MovieRequest(page = 1)

        `when`(repository.getMoviesPlaying(movieRequest)).thenReturn(Result.success(movieResponse))

        viewModel.getMoviesPlaying(movieRequest)

        verify(moviesPlayingObserver).onChanged(movieResponse.results)
        verify(appStateObserver).onChanged(DataState.Success)
    }

    @Test
    fun `getCategories should post error on failure`() = runTest {
        val errorMessage = "Error fetching categories"
        `when`(repository.getCategories(anyString())).thenReturn(Result.failure(Throwable(errorMessage)))

        viewModel.getCategories("en")

        verify(appStateObserver).onChanged(DataState.Error)
    }
}
