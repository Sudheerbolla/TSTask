package com.tstask.utils

import com.tstask.BuildConfig

class Constants {

    companion object {

        // sec
        val CONNECTION_TIMEOUT: Long = 125

        val BASE_URL = BuildConfig.BASE_URL
        val NYT_APP_ID = BuildConfig.appId
        val NYT_API_KEY = BuildConfig.apikey
        val NYT_APP_SECRET = BuildConfig.secret

        val QUARTER_SECOND_DELAY = 250.toLong()
        val HALF_SECOND_DELAY = 500
        val ONE_SECOND_DELAY = 1000.toLong()
        val BACK_PRESSED_TIME = 2000

    }


}