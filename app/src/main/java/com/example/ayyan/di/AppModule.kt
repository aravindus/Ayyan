package com.example.ayyan.di

import com.example.ayyan.data.remote.MovieListApi
import com.example.ayyan.data.repository.MovieListImpl
import com.example.ayyan.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMovieListApi(): MovieListApi {
        return Retrofit.Builder()
            .baseUrl("https://howtodoandroid.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieListApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieListRepository(api: MovieListApi): MovieRepository {
        return MovieListImpl(api)
    }
}