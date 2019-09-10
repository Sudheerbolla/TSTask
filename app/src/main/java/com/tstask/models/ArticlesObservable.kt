package com.tstask.models

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.tstask.BaseApplication
import com.tstask.response.ArticlesResponse
import com.tstask.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticlesObservable : BaseObservable() {

    internal var status: String = "NO"
    internal var articles = MutableLiveData<List<ArticleModel>>()

    fun getStatus(): String {
        return status
    }

    fun getArticles(): MutableLiveData<List<ArticleModel>> {
        return articles
    }

    fun fetchList(pos: Int) {
        val callback = object : Callback<ArticlesResponse> {
            override fun onResponse(
                call: Call<ArticlesResponse>, response: Response<ArticlesResponse>
            ) {
                val body = response.body()
                if (body != null) {
                    status = body.status
                    articles.setValue(body.articleModels)
                } else {
                    status = "ERROR"
                    articles.value = null
                }
            }

            override fun onFailure(call: Call<ArticlesResponse>, t: Throwable) {
                status = "Error"
                Log.e("error: ", t.message, t)
            }
        }

        BaseApplication.getWsClientListener().getAllArticles(
            when (pos) {
                1 -> 7
                2 -> 30
                else -> 1
            }, Constants.NYT_API_KEY
        ).enqueue(callback)

    }

}