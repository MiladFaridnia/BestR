package com.faridnia.bestr.di

import com.faridnia.bestr.data.remote.GoogleDirectionsApi
import com.faridnia.bestr.data.repository.GoogleDirectionsRepositoryImpl
import com.faridnia.bestr.domain.repository.GoogleDirectionsRepository
import com.faridnia.bestr.domain.use_case.GoogleDirectionsUseCase
import com.faridnia.bestr.util.Constants
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
    fun provideApi(): GoogleDirectionsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GoogleDirectionsApi::class.java)
    }


    @Provides
    @Singleton
    fun provideRepository(api: GoogleDirectionsApi): GoogleDirectionsRepository =
        GoogleDirectionsRepositoryImpl(api)


    @Provides
    @Singleton
    fun provideUseCase(repository: GoogleDirectionsRepository): GoogleDirectionsUseCase =
        GoogleDirectionsUseCase(repository)

}