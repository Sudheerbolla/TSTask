package com.tstask

import androidx.multidex.MultiDexApplication
import com.google.gson.GsonBuilder
import com.tstask.BaseApplication.RetrofitInitialization.initRetrofit
import com.tstask.models.ArticleModel
import com.tstask.response.ArticlesResponse
import com.tstask.utils.Constants
import com.tstask.wsutils.WSInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class BaseApplication : MultiDexApplication() {

    private var mInstance: BaseApplication? = null

    companion object {
        var wsInterface: WSInterface? = null
        var okHttpClient: OkHttpClient? = null

        fun getWsClientListener(): WSInterface {
            return wsInterface!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        initRetrofit()
    }

    object RetrofitInitialization {
        fun initRetrofit() {
            okHttpClient = OkHttpClient().newBuilder().addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            ).readTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.SECONDS).writeTimeout(
                    Constants.CONNECTION_TIMEOUT, TimeUnit.SECONDS
                ).build()
            val articlesDeserializer =
                GsonBuilder().setLenient().registerTypeAdapter(ArticleModel::class.java, ArticleModel.FacetsDeserilizer()).create()

            wsInterface =
                Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(articlesDeserializer))
                    .client(okHttpClient!!).build().create(WSInterface::class.java)
        }
    }

    @Synchronized
    fun getInstance(): BaseApplication {
        if (mInstance == null) mInstance = BaseApplication()
        return mInstance as BaseApplication
    }

}