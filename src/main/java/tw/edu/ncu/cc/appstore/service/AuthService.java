package tw.edu.ncu.cc.appstore.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {
    String getLoginString();
    @SuppressWarnings("rawtypes")
    boolean isLoginSuccess(HttpServletRequest request);
    @SuppressWarnings("rawtypes")
    String getStudentId(HttpServletRequest request);
}
