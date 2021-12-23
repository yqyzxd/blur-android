package com.wind.blur

import android.content.Context
import android.graphics.Bitmap

/**
 * created by EDY on 2021/11/11 20:54
 */

class EmptyBlur :IBlur {
    override fun blur(context: Context?, source: Bitmap?, radius: Float): Bitmap? {
        return source
    }
}