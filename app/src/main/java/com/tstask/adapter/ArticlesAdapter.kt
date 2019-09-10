package com.tstask.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tstask.BR
import com.tstask.R
import com.tstask.databinding.ItemArticlesBinding
import com.tstask.interfaces.IClickListener
import com.tstask.models.ArticleModel
import com.tstask.viewmodel.ArticlesViewModel

class ArticlesAdapter(
    private var articlesViewModel: ArticlesViewModel,
    private var iClickListener: IClickListener?
) : RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {

    private var offersArrayList: ArrayList<ArticleModel>? = null

    init {
        offersArrayList = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_articles, parent, false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(offersArrayList!![position], iClickListener, articlesViewModel)
    }

    fun setArticles(offersArrayList: ArrayList<ArticleModel>?) {
        clearArticles()
        this.offersArrayList?.addAll(offersArrayList!!)
    }

    fun clearArticles() {
        this.offersArrayList?.clear()
    }

    override fun getItemCount(): Int {
        return offersArrayList!!.size
    }

    class ViewHolder(var binding: ItemArticlesBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            offerModel: ArticleModel,
            iClickListener: IClickListener?,
            articlesViewModel: ArticlesViewModel
        ) {
            binding.setVariable(BR.obj, offerModel)
            binding.setVariable(BR.viewModel, articlesViewModel)
            binding.executePendingBindings()

            binding.linBody.setOnClickListener { v ->
                if (iClickListener != null) iClickListener.onClick(v, adapterPosition)
            }

        }

    }

}