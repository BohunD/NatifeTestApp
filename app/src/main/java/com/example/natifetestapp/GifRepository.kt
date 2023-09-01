package com.example.natifetestapp

class GifRepository(private val apiService: GifsApiService) {

    suspend fun getTrendingGifs(
        apiKey: String,
        limit: Int,
        offset: Int,
        rating: String,
        bundle: String
    ): List<GifItem>? {
        val response = apiService.getTrendingGifs(apiKey, limit, offset, rating, bundle)
        if (response.isSuccessful) {
            return response.body()?.data
        }
        return null
    }
}
