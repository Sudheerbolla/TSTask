package com.tstask.wsutils

import com.tstask.response.ArticlesResponse
import com.tstask.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface WSInterface {

    @Headers("Content-Type: application/json; charset=utf-8")
    @GET("/svc/mostpopular/v2/viewed/{period}.json")
    fun getAllArticles(@Path("period") period: Int, @Query("api-key") apikey: String): Call<ArticlesResponse>

}
