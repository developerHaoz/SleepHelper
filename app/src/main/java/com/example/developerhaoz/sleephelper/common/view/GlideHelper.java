package com.example.developerhaoz.sleephelper.common.view;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.util.concurrent.ExecutionException;

/**
 * Glide 相关的帮助类
 *
 * Created by developerHaoz on 2017/5/6.
 */

public class GlideHelper {

    /**
     * 根据图片的网络地址，拿到使用 Glide 进行缓存后的图片缓存地址
     * 注意！！！ 该方法要在子线程中调用，否则会出错
     *
     * @param imageUrl 图片的网络地址
     * @return 图片的缓存地址
     */
    public static String getImagePathFromCache(String imageUrl, Context context) {

        FutureTarget<File> futureTarget = Glide.with(context)
                .load(imageUrl)
                .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
        File cacheFile;
        try {
            cacheFile = futureTarget.get();
            return cacheFile.getAbsolutePath();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }


}























