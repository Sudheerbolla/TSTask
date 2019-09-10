package com.tstask.activities

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.tstask.R

abstract class BaseActivity : AppCompatActivity() {

    abstract fun initComponents()

    fun hideKeyboard() {
        val view = currentFocus
        if (view != null) {
            (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                view.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }

    fun replaceFragment(fragment: Fragment, needToAddToBackStack: Boolean) {
        val tag = fragment.javaClass.simpleName
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (needToAddToBackStack)
            fragmentTransaction.replace(R.id.mainFrame, fragment, tag).addToBackStack(tag).commit()
        else
            fragmentTransaction.replace(R.id.mainFrame, fragment, tag).commit()
    }

    fun addFragment(fragment: Fragment, needToAddToBackStack: Boolean) {
        val tag = fragment.javaClass.simpleName
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (needToAddToBackStack) fragmentTransaction.add(
            R.id.mainFrame,
            fragment,
            tag
        ).addToBackStack(tag).commit()
        else fragmentTransaction.add(R.id.mainFrame, fragment, tag).commit()
    }

    fun replaceFragmentWithoutAnimation(fragment: Fragment, needToAddToBackStack: Boolean) {
        val tag = fragment.javaClass.simpleName
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (needToAddToBackStack) fragmentTransaction.replace(
            R.id.mainFrame,
            fragment,
            tag
        ).addToBackStack(tag).commitAllowingStateLoss()
        else fragmentTransaction.replace(R.id.mainFrame, fragment, tag).commitAllowingStateLoss()
    }


    fun popBackStack() {
        supportFragmentManager.popBackStackImmediate()
    }

}