package com.wind.blur

import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur

/**
 * created by wind on 2021/11/11 19:12
 */

class RenderScriptBlur :IBlur {
    override fun blur(context: Context?, source: Bitmap?, radius: Float): Bitmap? {
        if (context == null || source==null) {
            return source
        }
        //Set the radius of the Blur. Supported range 0 < radius <= 25

        var blurRadius=radius
        if (blurRadius<0){
            blurRadius=1f
        }
        if (blurRadius>25){
            blurRadius=25f
        }

        var rs: RenderScript? = null
        var input: Allocation? = null
        var output: Allocation? = null
        var blur: ScriptIntrinsicBlur? = null

        try {
            rs = RenderScript.create(context)
            rs.messageHandler = RenderScript.RSMessageHandler()
            input = Allocation.createFromBitmap(
                rs, source, Allocation.MipmapControl.MIPMAP_NONE,
                Allocation.USAGE_SCRIPT
            )
            output = Allocation.createTyped(rs, input.getType())
            blur = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs))

            blur.setInput(input)
            blur.setRadius(blurRadius)
            blur.forEach(output)
            output.copyTo(source)
        }catch (e:Exception){
            e.printStackTrace()
        }finally {
            if (rs != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    RenderScript.releaseAllContexts();
                } else {
                    rs.destroy();
                }
            }
            if (input != null) {
                input.destroy();
            }
            if (output != null) {
                output.destroy();
            }
            if (blur != null) {
                blur.destroy();
            }
        }




        return source

    }
}