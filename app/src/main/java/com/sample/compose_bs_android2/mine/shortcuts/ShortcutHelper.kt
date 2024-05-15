package com.sample.compose_bs_android2.mine.shortcuts

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.os.Build
import androidx.core.content.getSystemService
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import com.sample.compose_bs_android2.MainActivity
import com.sample.compose_bs_android2.R

fun addDynamicShortcut(applicationContext: Context) {
    val shortcut = ShortcutInfoCompat.Builder(applicationContext, "dynamic")
        .setShortLabel("Call Mum")
        .setLongLabel("Clicking this will call your Mum")
        .setIcon(
            IconCompat.createWithResource(
                applicationContext,
                R.drawable.ic_calling_mum
            )
        ).setIntent(
            Intent(applicationContext, MainActivity::class.java).apply {
                action = Intent.ACTION_VIEW
                putExtra("shortcut_id", "dynamic")
            }
        ).build()

    ShortcutManagerCompat.pushDynamicShortcut(applicationContext, shortcut)
}

fun addPinnedShortcut(applicationContext: Context) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
        return
    }

    val shortcutManager = applicationContext.getSystemService<ShortcutManager>()!!
    if (shortcutManager.isRequestPinShortcutSupported) {
        val shortcut = ShortcutInfo.Builder(applicationContext, "pinned")
            .setShortLabel("Send message")
            .setLongLabel("Send a message to a frind")
            .setIcon(
                Icon.createWithResource(
                    applicationContext,
                    R.drawable.ic_message
                )
            ).setIntent(
                Intent(applicationContext, MainActivity::class.java).apply {
                    action = Intent.ACTION_VIEW
                    putExtra("shortcut_id", "pinned")
                }
            ).build()

        val callbackIntent = shortcutManager.createShortcutResultIntent(shortcut)
        val successPendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            0,
            callbackIntent,
            PendingIntent.FLAG_IMMUTABLE
        )

        shortcutManager.requestPinShortcut(shortcut, successPendingIntent.intentSender)
    }

}