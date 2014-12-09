package tw.edu.ncu.cc.appstore.service;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import tw.edu.ncu.cc.appstore.openid.OpenIDManager;

@Service
public class AuthServiceImpl implements AuthService{

    OpenIDManager openIDManager;
    
    @Inject
    public void setOpenIDManager(OpenIDManager openIDManager) {
        this.openIDManager = openIDManager;
    }

    public String getLoginString() {
        return openIDManager.getURLString();
    }

    @SuppressWarnings("rawtypes")
    public boolean isLoginSuccess(HttpServletRequest request) {
        return openIDManager.checkAuthentication(request);
    }

    @SuppressWarnings("rawtypes")
    public String getStudentId(HttpServletRequest request) {
        return openIDManager.getIdentityID(request);
    }

}
