package com.faridnia.bestr.data.repository

import com.faridnia.bestr.data.remote.GoogleDirectionsApi
import com.faridnia.bestr.data.remote.dto.toGoogleDirectionsApiResponse
import com.faridnia.bestr.domain.model.GoogleDirectionsApiResponse
import com.faridnia.bestr.domain.repository.GoogleDirectionsRepository
import com.faridnia.bestr.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GoogleDirectionsRepositoryImpl @Inject constructor(private val api: GoogleDirectionsApi) :
    GoogleDirectionsRepository {
    override fun getDirections(
        start: String,
        destination: String,
        key: String
    ): Flow<Resource<GoogleDirectionsApiResponse>> {
        return flow {

            emit(Resource.Loading())

            try {
                val directionsApiResponseDto =
                    api.getDirections(
                        start = start,
                        destination = destination,
                        key = key
                    ).toGoogleDirectionsApiResponse()

                emit(Resource.Success(data = directionsApiResponseDto))

            } catch (e: IOException) {
                e.printStackTrace()

                emit(
                    Resource.Error(
                        message =
                        e.localizedMessage
                            ?: "Couldn't reach server. Check your internet connection"
                    )
                )

            } catch (e: HttpException) {
                e.printStackTrace()

                emit(Resource.Error(message = "Couldn't load data"))

            } catch (e: Exception) {
                e.printStackTrace()

                emit(Resource.Error(message = "Something is wrong"))

            }
        }
    }
}