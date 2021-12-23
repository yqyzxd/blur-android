package com.wind.blur;

import android.content.Context;
import android.graphics.Bitmap;

import org.jetbrains.annotations.Nullable;

/**
 * created by wind on 2021/11/11 20:04
 */

public class CppBlur implements IBlur{
    @Nullable
    @Override
    public Bitmap blur(@Nullable Context context, @Nullable Bitmap source, float radius) {
        if (context == null || source==null) {
            return source;
        }


        return null;

    }

    public native Bitmap blur(Bitmap source, float radius);
}
