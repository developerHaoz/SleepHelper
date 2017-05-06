package com.example.developerhaoz.sleephelper.common.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * DiskLruCache 的帮助类
 *
 * Created by developerHaoz on 2017/5/6.
 */

public class DiskLruCacheHelper {

    /**
     * 获取缓存地址
     *
     * @param context 应用上下文
     * @param uniqueName 为了不同类型的数据进行区分而设定的一个唯一值
     * @return 缓存地址
     */
    public File getDiskLruCache(Context context, String uniqueName){
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()){
            cachePath = context.getExternalCacheDir().getPath();
        }else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + uniqueName);
    }

    /**
     * 获取当前应用程序的版本号
     *
     * @param context 应用的上下文
     * @return 应用程序的版本号
     */
    public int getAppVersion(Context context){
        try {
            PackageInfo  info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * 将图片的 URL 进行 MD5 编码
     *
     * @param key 图片的 URL
     * @return 经过 MD5 编码的图片 URL
     */
    public String hashKeyForDisk(String key){
        String cacheKey;
        try {
            final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(key.getBytes());
            cacheKey =bytesToHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            cacheKey = String.valueOf(key.hashCode());
        }
        return cacheKey;
    }

    private String bytesToHexString(byte[] bytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1){
                stringBuilder.append("0");
            }
            stringBuilder.append(hex);
        }
        return stringBuilder.toString();
    }

}























