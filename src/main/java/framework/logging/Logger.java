package framework.logging;

import framework.enums.Status;

public class Logger {

    private static LogHandler handler;

    public static void setHandler(LogHandler logHandler) {
        handler = logHandler;
    }

    public static void log(Status status, String message) {
        if (handler != null) {
            handler.log(status, message);
        }
    }

    public static void logWithScreenShot(Status status, String message, String testname) {
        if (handler != null) {
            handler.logWithScreenShot(status, message, testname);
        }
    }

}