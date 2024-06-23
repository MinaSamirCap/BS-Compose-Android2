package com.sample.compose_bs_android2.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log


class IntentUtil {
    companion object {
        fun openBrowser(context: Context, url: String?) {
            try {
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                context.startActivity(i)
            } catch (ignored: Exception) {
                Log.e("IntentUtil", ignored.toString())
            }
        }

        fun openBrowserWithMap(
            activity: Activity,
            lat: Double,
            lng: Double
        ) {
            openBrowser(activity, "https://maps.google.com/maps?daddr=$lat,$lng")
        }
    }
}