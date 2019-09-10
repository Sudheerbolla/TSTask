package com.tstask.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tstask.R
import com.tstask.activities.MainActivity
import com.tstask.databinding.FragmentListBinding
import com.tstask.models.ArticleModel
import com.tstask.utils.StaticUtils
import com.tstask.viewmodel.ArticlesViewModel

class ArticlesFragment : BaseFragment(), PopupMenu.OnMenuItemClickListener, View.OnClickListener {

    private var viewModel: ArticlesViewModel? = null

    private var rootView: View? = null

    private lateinit var mainActivity: MainActivity
    private lateinit var binding: FragmentListBinding

    companion object {
        @JvmStatic
        fun newInstance() = ArticlesFragment()
    }

    override fun onResume() {
        super.onResume()
        mainActivity.hideTopBarBack("Most Viewed Articles")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        rootView = binding.root
        viewModel = ViewModelProviders.of(this).get(ArticlesViewModel::class.java)
        if (savedInstanceState == null) {
            viewModel!!.init()
        }
        binding.viewModel = viewModel
        initComponents()
        return rootView
    }

    override fun initComponents() {
        binding.recyclerView.layoutManager = LinearLayoutManager(mainActivity)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                mainActivity,
                RecyclerView.VERTICAL
            )
        )
        callOnFilter(0)
        mainActivity.binding.txtFilter.setOnClickListener(this)
    }

    private fun setupListClick() {
        viewModel!!.selected.observe(this, Observer<ArticleModel> { article ->
            if (article != null) {
                mainActivity.addFragment(ArticleDetailsFragment.newInstance(article), true)
            }
        })
    }

    fun showPopUp() {
        val menu = PopupMenu(mainActivity, mainActivity.binding.txtFilter)
        menu.getMenu().add(getString(R.string.yesterday))
        menu.getMenu().add(getString(R.string.last_7_days))
        menu.getMenu().add(getString(R.string.last_1_month))
        menu.setOnMenuItemClickListener(this)
        menu.show()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.txtFilter -> {
                showPopUp()
            }
        }
    }

    fun callOnFilter(pos: Int) {
        viewModel!!.fetchList(pos)
        viewModel!!.getBreeds().observe(this,
            Observer<List<Any>> { dogBreeds ->
                run {
                    binding.progressBar.visibility = View.GONE
                    if (dogBreeds != null) {
                        viewModel!!.setDogBreedsInAdapter(dogBreeds as ArrayList<ArticleModel>)
                        if (dogBreeds.size > 0) {
                            binding.recyclerView.visibility = View.VISIBLE
                            binding.txtNoData.visibility = View.GONE
                        } else {
                            binding.recyclerView.visibility = View.GONE
                            binding.txtNoData.visibility = View.VISIBLE
                        }
                    } else {
                        StaticUtils.showSimpleToast(
                            mainActivity, getString(R.string.something_went_wrong)
                        )
                        binding.recyclerView.visibility = View.GONE
                        binding.txtNoData.visibility = View.VISIBLE
                    }
                }
            })
        setupListClick()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.title) {
            getString(R.string.yesterday) -> {
                callOnFilter(0)
            }
            getString(R.string.last_7_days) -> {
                callOnFilter(1)
            }
            getString(R.string.last_1_month) -> {
                callOnFilter(2)
            }
        }
        return true
    }

}
