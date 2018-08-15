package com.tencent.weishi.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtils {
    /** ÿ�� Log �� tag �������󳤶�, �������ֽ����ض� */
    private static final int TAG_MAX_LENGTH = 20;

    /** ÿ�� Log �� message �������󳤶�, �������ֽ����ض� */
    private static final int MESSAGE_MAX_LENGTH = 1024;

    /** ����ǰ׺��ʽ�� */
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd HH:mm:ss.SSS");

    /** ��־��ǰ���������, Ĭ��Ϊ INFO ���� */
    private static Level logOutLevel = Level.INFO;

    /** �Ƿ����������̨, Ĭ����� */
    private static boolean isOutToConsole = true;

    /** �Ƿ�������ļ� */
    private static boolean isOutToFile = false;

    /** ��־����ļ�, ׷�ӵ��ļ�β */
    private static File logOutFile;

    /** ��־�ļ������, ׷�ӵ��ļ�β  */
    private static RandomAccessFile logOutFileStream;

    public static void setLogOutLevel(Level currentLevel) {
        if (currentLevel == null) {
            currentLevel = Level.INFO;
        }
        LogUtils.logOutLevel = currentLevel;
    }

    public static synchronized void setLogOutFile(File logOutFile) throws IOException {
        LogUtils.logOutFile = logOutFile;

        if (logOutFileStream != null) {
            closeStream(logOutFileStream);
            logOutFileStream = null;
        }

        if (LogUtils.logOutFile != null) {
            try {
                logOutFileStream = new RandomAccessFile(LogUtils.logOutFile, "rw");
                logOutFileStream.seek(LogUtils.logOutFile.length());
            } catch (IOException e) {
                closeStream(logOutFileStream);
                logOutFileStream = null;
                throw e;
            }
        }
    }

    public static void setLogOutTarget(boolean isOutToConsole, boolean isOutToFile) {
        LogUtils.isOutToConsole = isOutToConsole;
        LogUtils.isOutToFile = isOutToFile;
    }

    public static void debug(String tag, String message) {
        printLog(Level.DEBUG, tag, message, false);
    }

    public static void info(String tag, String message) {
        printLog(Level.INFO, tag, message, false);
    }

    public static void warn(String tag, String message) {
        printLog(Level.WARN, tag, message, false);
    }

    public static void error(String tag, String message) {
        printLog(Level.ERROR, tag, message, true);
    }

    public static void error(String tag, Exception e) {
        if (e == null) {
            error(tag, (String) null);
            return;
        }

        PrintStream printOut = null;

        try {
            ByteArrayOutputStream bytesBufOut = new ByteArrayOutputStream();
            printOut = new PrintStream(bytesBufOut);
            e.printStackTrace(printOut);
            printOut.flush();
            error(tag, new String(bytesBufOut.toByteArray(), "UTF-8"));

        } catch (Exception e1) {
            e1.printStackTrace();

        } finally {
            closeStream(printOut);
        }
    }

    private static void printLog(Level level, String tag, String message, boolean isOutToErr) {
        if (level.getLevelValue() >= logOutLevel.getLevelValue()) {
            String log = DATE_FORMAT.format(new Date()) +
                    " " +
                    level.getTag() +
                    "/" +
                    checkTextLengthLimit(tag, TAG_MAX_LENGTH) +
                    ": " +
                    checkTextLengthLimit(message, MESSAGE_MAX_LENGTH);

            if (isOutToConsole) {
                outLogToConsole(isOutToErr, log);
            }
            if (isOutToFile) {
                outLogToFile(log);
            }
        }
    }

    private static void outLogToConsole(boolean isOutToErr, String log) {
        if (isOutToErr) {
            // System.err �� System.out ��������ͬ�������ͨ��, �������ʱ������
            // ����� log �� err �� out, ����̨�ϵĴ�ӡ˳����ܻ᲻��ȫ��ʱ���ӡ.
            System.err.println(log);
        } else {
            System.out.println(log);
        }
    }

    private static synchronized void outLogToFile(String log) {
        if (logOutFileStream != null) {
            try {
                logOutFileStream.write((log + "\n").getBytes("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String checkTextLengthLimit(String text, int maxLength) {
        if ((text != null) && (text.length() >  maxLength)) {
            text = text.substring(0, maxLength - 3) + "...";
        }
        return text;
    }

    private static void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (Exception e) {
                // nothing
            }
        }
    }

    public static enum Level {
        DEBUG("D", 1), INFO("I", 2), WARN("W", 3), ERROR("E", 4);

        private String tag;

        private int levelValue;

        private Level(String tag, int levelValue) {
            this.tag = tag;
            this.levelValue = levelValue;
        }

        public String getTag() {
            return tag;
        }

        public int getLevelValue() {
            return levelValue;
        }
    }

    public static void export(String tar,Object o){
        LogUtils.error(tar,o.toString());
        LogUtils.info(tar,o.toString());
        LogUtils.debug(tar,o.toString());
        LogUtils.warn(tar,o.toString());
    }
}