package com.tencent.weishi.util;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final String TAG = "Main";

    public static void main(String[] args) throws IOException {
        // (可选) 设置日志输出级别, 默认为 INFO 级别
        LogUtils.setLogOutLevel(LogUtils.Level.DEBUG);

        // (可选) 设置日志输出文件(追加到文件尾部)
        LogUtils.setLogOutFile(new File ("f://exception//MyLog.log"));

        // (可选) 设置日志输出位置(是否输出到控制台 和 是否输出到文件), 默认只输出到控制台, 不输出到文件
        LogUtils.setLogOutTarget(true, true);

        //int b = 5/0;
        //stem.out.println(b);



        // 输出日志
        //LogUtils.export(TAG,b);
//        LogUtils.debug(TAG, "The debug log.\r\n");
//        LogUtils.info(TAG, "The info log.\r\n");
//        LogUtils.warn(TAG, "The warn log.\r\n");
//        LogUtils.error(TAG, "The error log.\r\n");
    }
}
