package com.galassinitecnology.movieapp.repository.movie

import com.galassinitecnology.movieapp.api.model.response.categories.CategoriesResponse
import com.galassinitecnology.movieapp.api.service.movie.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.mock
import retrofit2.Response

@ExperimentalCoroutinesApi
class MovieRepositoryTest {

    @Mock
    private lateinit var service: MovieService

    private lateinit var repository: MovieRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        repository = MovieRepository(service, Dispatchers.Main)
    }

    @Test
    fun `getCategories returns success`() = runBlockingTest {
        // Arrange
        val language = "en-US"
        val mockResponse = CategoriesResponse(listOf())
        val response = Response.success(mockResponse)
        `when`(service.getCategories(language)).thenReturn(response)

        // Act
        val result = repository.getCategories(language)

        // Assert
        assertTrue(result.isSuccess)
        assertEquals(mockResponse, result.getOrNull())
    }

    @Test
    fun `getCategories returns failure`() = runBlockingTest {
        // Arrange
        val language = "en-US"
        val response = Response.error<CategoriesResponse>(404, mock())
        `when`(service.getCategories(language)).thenReturn(response)

        // Act
        val result = repository.getCategories(language)

        // Assert
        assertTrue(result.isFailure)
    }
}
