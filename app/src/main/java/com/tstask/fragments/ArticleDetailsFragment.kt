package com.tstask.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.tstask.R
import com.tstask.activities.MainActivity
import com.tstask.databinding.FragmentDetailsBinding
import com.tstask.models.ArticleModel

class ArticleDetailsFragment : BaseFragment() {

    private lateinit var articleModel: ArticleModel

    private var rootView: View? = null

    private lateinit var mainActivity: MainActivity
    private lateinit var binding: FragmentDetailsBinding

    companion object {
        @JvmStatic
        fun newInstance(articleModel: ArticleModel) = ArticleDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable("articleModel", articleModel)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mainActivity.showTopBarBack("Article Details")
    }

    override fun onPause() {
        super.onPause()
        mainActivity.hideTopBarBack("Most Viewed Articles")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        arguments?.let {
            articleModel = it.getParcelable("articleModel")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        rootView = binding.root
        initComponents()
        return rootView
    }

    override fun initComponents() {
        binding.setObj(articleModel)
        Glide.with(this).load(articleModel.getMedia().get(0).getMediaMetadata().get(1).getUrl())
            .into(binding.imgMedia)
    }

}
