package com.tencent.weishi;

import com.tencent.weishi.util.GetNowTime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class IO2File {
    public static void main(String[] args) throws IOException {
//        String str = GetNowTime.TimeStamp().toString()+".log";
//        File file = new File("f://exception//",str);
//        if(!file.exists()){
//            file.createNewFile();
//        }
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        PrintStream printStream = new PrintStream(fileOutputStream);
//        String object = GetNowTime.getTimeAccurateHour();
//        printStream.write(object.getBytes());
//        printStream.write("日志信息如下：".getBytes());
//        printStream.write("\r\n".getBytes());
//        printStream.flush();
//        System.setOut(printStream);
//        System.setErr(printStream);
//        System.out.println("this is a message");
//        int b = 5/0;
//        System.out.println(b);
        IO2File.exportLog();
        System.out.println("I love rocky");
        int b = 5/0;
        System.out.println(b);
    }

    public static void exportLog(){
        String object = GetNowTime.getTimeAccurateHour();
        FileOutputStream fileOutputStream = null;
        PrintStream printStream = null;
        String str = GetNowTime.TimeStamp().toString()+".log";
        File file = new File("f://exception//",str);

        if(!file.exists()) {
            try {
                file.createNewFile();
                fileOutputStream = new FileOutputStream(file);
                printStream = new PrintStream(fileOutputStream);
                printStream.write(object.getBytes());
                printStream.write("日志信息如下：".getBytes());
                printStream.write("\r\n".getBytes());
                printStream.flush();
                System.setOut(printStream);
                System.setErr(printStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
