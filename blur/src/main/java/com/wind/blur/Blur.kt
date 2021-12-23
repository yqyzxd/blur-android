package com.wind.blur

import android.graphics.BitmapFactory
import java.security.MessageDigest

/**
 * created by wind on 2021/11/11 17:57
 */

class Blur {

    companion object{
        val FAST:String="FAST"
        val RENDER_SCRIPT:String="RENDER_SCRIPT"

        fun use(algorithm:String):IBlur{
            var instance:IBlur=EmptyBlur()
            if (FAST.equals(algorithm)){
                instance= FastBlur()
            }else if (RENDER_SCRIPT.equals(algorithm)){
                instance= RenderScriptBlur()
            }
            return instance
        }

    }
}