package tw.edu.ncu.cc.appstore.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService{
    private static final Logger logger = Logger.getLogger(LoggerServiceImpl.class);
    public void log(String message) {
        logger.info(message);
    }

    public void logWithIp(String message, HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        log(ip+" ==>"+message);
    }
}
