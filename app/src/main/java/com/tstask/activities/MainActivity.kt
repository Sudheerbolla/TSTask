package com.tstask.activities

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.tstask.R
import com.tstask.databinding.ActivityMainBinding
import com.tstask.fragments.ArticlesFragment
import com.tstask.utils.Constants
import com.tstask.utils.StaticUtils


class MainActivity : BaseActivity(), View.OnClickListener {

    public lateinit var binding: ActivityMainBinding
    private var backPressed: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initComponents()
    }

    override fun initComponents() {
        binding.imgBack.setOnClickListener(this)
        setHomeScreen()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.imgBack -> {
                onBackPressed()
            }
        }
    }

    public fun setHomeScreen() {
        replaceFragmentWithoutAnimation(ArticlesFragment.newInstance(), false)
    }

    public fun showTopBarBack(heading: String) {
        binding.txtHeading.setText(heading)
        binding.imgBack.visibility = View.VISIBLE
        binding.txtFilter.visibility = View.GONE
    }

    public fun hideTopBarBack(heading: String) {
        binding.txtHeading.setText(heading)
        binding.imgBack.visibility = View.GONE
        binding.txtFilter.visibility = View.VISIBLE
    }


    override
    fun onBackPressed() {
        val fragment = getCurrentFragment()
        if (fragment is ArticlesFragment) {
            if (backPressed + Constants.BACK_PRESSED_TIME > System.currentTimeMillis()) {
                super.onBackPressed()
            } else {
                StaticUtils.showSimpleToast(
                    this, getString(com.tstask.R.string.press_once_again_to_exit_the_app)
                )
            }
            backPressed = System.currentTimeMillis()
        } else /*popBackStack()*/ {
            if (supportFragmentManager.getBackStackEntryCount() > 0) {
                supportFragmentManager.popBackStack()
            } else {
                super.onBackPressed();
            }
        }
    }

    private fun getCurrentFragment(): Fragment {
        return supportFragmentManager.findFragmentById(R.id.mainFrame)!!
    }

}
