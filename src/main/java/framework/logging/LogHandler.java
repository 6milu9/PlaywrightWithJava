package framework.logging;

import framework.enums.Status;

public interface LogHandler {
    void log(Status status, String message);
    void logWithScreenShot(Status status, String message, String testname);
}
