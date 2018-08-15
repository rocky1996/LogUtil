package com.tencent.weishi.util;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final String TAG = "Main";

    public static void main(String[] args) throws IOException {
        // (��ѡ) ������־�������, Ĭ��Ϊ INFO ����
        LogUtils.setLogOutLevel(LogUtils.Level.DEBUG);

        // (��ѡ) ������־����ļ�(׷�ӵ��ļ�β��)
        LogUtils.setLogOutFile(new File ("f://exception//MyLog.log"));

        // (��ѡ) ������־���λ��(�Ƿ����������̨ �� �Ƿ�������ļ�), Ĭ��ֻ���������̨, ��������ļ�
        LogUtils.setLogOutTarget(true, true);

        //int b = 5/0;
        //stem.out.println(b);



        // �����־
        //LogUtils.export(TAG,b);
//        LogUtils.debug(TAG, "The debug log.\r\n");
//        LogUtils.info(TAG, "The info log.\r\n");
//        LogUtils.warn(TAG, "The warn log.\r\n");
//        LogUtils.error(TAG, "The error log.\r\n");
    }
}
