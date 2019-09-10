package com.tstask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tstask.adapter.ArticlesAdapter
import com.tstask.models.ArticleModel
import com.tstask.models.ArticlesObservable

class ArticlesViewModel : ViewModel() {

    var adapter: ArticlesAdapter? = null
    private var articleObserver: ArticlesObservable? = null
    lateinit var selected: MutableLiveData<ArticleModel>

    fun init() {
        articleObserver = ArticlesObservable()
        selected = MutableLiveData()
        adapter = ArticlesAdapter(this, null)
    }

    fun fetchList(pos:Int) {
        articleObserver!!.fetchList(pos)
    }

    fun getBreeds(): MutableLiveData<List<ArticleModel>> {
        return articleObserver?.getArticles()!!
    }

    fun setDogBreedsInAdapter(articles: ArrayList<ArticleModel>) {
        this.adapter?.setArticles(articles)
        this.adapter?.notifyDataSetChanged()
    }

    fun getStatus(): Boolean {
        if (articleObserver == null) return false
        else return articleObserver?.getStatus().equals("OK", true)
    }

    fun onItemClick(dogBreed: ArticleModel) {
        selected.setValue(dogBreed)
    }

}