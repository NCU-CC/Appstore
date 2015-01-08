package tw.edu.ncu.cc.appstore.service;

import javax.servlet.http.HttpServletRequest;

public interface LoggerService {
    void log(String message);
    void logWithIp(String message,HttpServletRequest request);
}
