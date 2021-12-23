package com.wind.blur

import android.content.Context
import android.graphics.Bitmap

/**
 * created by wind on 2021/11/11 17:58
 * https://github.com/mmin18/RealtimeBlurView
 * https://github.com/wasabeef/Blurry
 */

interface IBlur {
    fun blur(
        context: Context?,
        source: Bitmap?,
        radius: Float
    ): Bitmap?
}