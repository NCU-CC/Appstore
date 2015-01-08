package tw.edu.ncu.cc.appstore.controller.login;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tw.edu.ncu.cc.appstore.service.AuthService;
import tw.edu.ncu.cc.appstore.service.LoggerService;

import com.opensymphony.xwork2.ActionSupport;
@Component
@Scope("prototype")
public class AuthController extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private HttpServletRequest request;  
    private AuthService authService; 
    private String student_id = "";
    private LoggerService loggerService;
    @Inject
    public void setLoggerService(LoggerService loggerService) {
        this.loggerService = loggerService;
    }
    @Override
    public String execute() throws Exception {
        request=ServletActionContext.getRequest();
        student_id = checkOpenId();
        if (!isStringEmpty(student_id)) {     
                login(student_id);
                logLoginSuccess(request, student_id);
                return SUCCESS;
        }
        logLoginFailure(request);
        return ERROR;
    }
    
    private void logLoginSuccess(HttpServletRequest request,String student_id){
        loggerService.logWithIp("member ["+ student_id +"] login success", request);
    }
    
    private void logLoginFailure(HttpServletRequest request){
        loggerService.logWithIp("admin login failure", request);
    }
    
    private boolean isStringEmpty(String string){
        return !(string!=null && string.length()>0);
    }
    private void login(String id){
        HttpSession session=request.getSession(true);
        session.setAttribute("tmpId", id);
    }

    private String checkOpenId() {
            boolean isChecked = authService.isLoginSuccess(request);
            if(isChecked){
                return authService.getIdentityId(request);
            }
        return null;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
    @Inject
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

}
