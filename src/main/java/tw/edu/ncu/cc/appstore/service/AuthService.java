package tw.edu.ncu.cc.appstore.service;

import java.util.Map;

public interface AuthService {
    String getLoginString();
    @SuppressWarnings("rawtypes")
    boolean isLoginSuccess(Map request);
    @SuppressWarnings("rawtypes")
    String getStudentId(Map request);
}
