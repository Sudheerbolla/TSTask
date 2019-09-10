package com.tstask.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.databinding.DataBindingUtil
import com.tstask.R
import com.tstask.databinding.ActivitySplashBinding
import com.tstask.utils.Constants
import com.tstask.utils.StaticUtils

class SplashActivity : BaseActivity() {

    private lateinit var splashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        initComponents()
    }

    override fun initComponents() {
        StaticUtils.setDisplayConstants(this)
    }

    override fun onResume() {
        super.onResume()
        checkForInternetAndProceed()
    }

    private fun checkForInternetAndProceed() {
        if (StaticUtils.checkInternetConnection(this)) {
            navigateToMainActivity()
        } else {
            StaticUtils.showIndefiniteToast(window.decorView.rootView,
                getString(R.string.no_internet_connection),
                getString(R.string.retry),
                View.OnClickListener { checkForInternetAndProceed() })
        }
    }

    private fun navigateToMainActivity() {
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left)
            finishAffinity()
        }, Constants.HALF_SECOND_DELAY.toLong())
    }

}
