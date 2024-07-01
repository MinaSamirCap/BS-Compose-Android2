package com.sample.compose_bs_android2.mine.lru

import android.util.Log
import androidx.collection.LruCache

object MyCache {

    object Keys {
        const val CACHE_KEY = "CacheKey"
    }

    private val maxMemory =
        (Runtime.getRuntime().maxMemory() / 1024).toInt() // we have size now in KiloBytes

    private val cacheSize = maxMemory / 8

    private val cache = LruCache<String, List<String>>(cacheSize)

    fun saveValues(value: List<String>) {
        cache.put(Keys.CACHE_KEY, value)
    }

    fun getValues(): List<String>? {
        return cache[Keys.CACHE_KEY]
    }

    fun info() {
        Log.i("myCache", "Max Memory: $maxMemory")
        Log.i("myCache", "Cache size: $cacheSize")
        Log.i("myCache", "Cache: $cache")
    }
}