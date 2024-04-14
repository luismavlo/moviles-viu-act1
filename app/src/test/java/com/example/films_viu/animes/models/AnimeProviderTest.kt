package com.example.films_viu.animes.models

import com.example.films_viu.animes.models.ApiResponse.AnimeListResponse
import com.example.films_viu.animes.models.ApiResponse.AtributosResponse
import com.example.films_viu.animes.models.ApiResponse.DataResponse
import com.example.films_viu.animes.models.ApiResponse.ImagePosterResponse
import com.example.films_viu.animes.service.AnimeRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AnimeProviderTest{
    @RelaxedMockK
    lateinit var animeRepository: AnimeRepository
    lateinit var animeModels: AnimeListResponse
    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        animeRepository = AnimeRepository()
    }
    @Test
    fun testCuandoElServicioObtieneDatosDelApi() = runBlocking {
        val animeModels:AnimeListResponse = animeRepository.getAllAnimesFromApi()
        //Comprobaciones
        Assert.assertTrue(animeModels.data.isNotEmpty())
    }
}