package com.tstask.utils

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.net.ConnectivityManager
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.tstask.R

class StaticUtils {

    companion object {

        var softKeyBarHeight = 100
        var DEVICE_WIDTH = 60
        var DEVICE_HEIGHT = 60

        fun setDisplayConstants(context: Context) {
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val display = windowManager.defaultDisplay
            val size = Point()
            display.getSize(size)
            DEVICE_WIDTH = size.x
            DEVICE_HEIGHT = size.y
            softKeyBarHeight = pxFromDp(context, softKeyBarHeight.toFloat()).toInt()
        }

        fun showSimpleToast(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }

        fun showSimpleToast(context: Context, message: Int) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }

        fun showToast(container: View, message: String) {
            try {
                val snackbar = snackbar(container, message, Snackbar.LENGTH_LONG)
                snackbar.show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun showToast(
            container: View,
            message: String,
            actionText: String,
            onClickListener: View.OnClickListener
        ) {
            try {
                val snackbar = snackbar(container, message, Snackbar.LENGTH_LONG)
                snackbar.setAction(actionText, onClickListener)
                snackbar.setActionTextColor(Color.BLACK)
                snackbar.show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun showIndefiniteToast(
            container: View,
            message: String,
            actionText: String,
            onClickListener: View.OnClickListener
        ) {
            try {
                val snackbar = snackbar(container, message, Snackbar.LENGTH_INDEFINITE)
                snackbar.setAction(actionText, onClickListener)
                snackbar.setActionTextColor(Color.WHITE)
                snackbar.show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        private fun snackbar(container: View, message: String, duration: Int): Snackbar {
            val snackbar = Snackbar.make(container, message, duration)
            try {
                val sbView = snackbar.view
                val params: ViewGroup.LayoutParams
                params = sbView.getLayoutParams() as FrameLayout.LayoutParams
                params.gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
                params.setMargins(0, 0, 0, softKeyBarHeight)
                sbView.setLayoutParams(params)
                sbView.setBackgroundColor(container.resources.getColor(R.color.colorLightGrey))
                val textView = sbView.findViewById<View>(R.id.snackbar_text) as TextView
                textView.setTextColor(Color.DKGRAY)
                textView.maxLines = 5
                textView.gravity = Gravity.CENTER_HORIZONTAL
                snackbar.addCallback(object : Snackbar.Callback() {

                    override fun onDismissed(snackbar: Snackbar?, event: Int) {
                        if (event == DISMISS_EVENT_TIMEOUT) {
                            // Snackbar closed on its own
                        }
                    }

                    override fun onShown(snackbar: Snackbar?) {}
                })
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return snackbar
        }

        fun dpFromPx(context: Context, px: Float): Float {
            return px / context.resources.displayMetrics.density
        }

        fun pxFromDp(context: Context, dp: Float): Float {
            return dp * context.resources.displayMetrics.density
        }

        fun checkInternetConnection(context: Context): Boolean {
            val _activeNetwork =
                (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
            return _activeNetwork != null && _activeNetwork.isConnectedOrConnecting
        }

    }

}