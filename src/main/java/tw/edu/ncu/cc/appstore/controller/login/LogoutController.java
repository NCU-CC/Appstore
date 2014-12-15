package tw.edu.ncu.cc.appstore.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope("prototype")
public class LogoutController extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private HttpServletRequest request;
    @Override
    public String execute() throws Exception {
        request = ServletActionContext.getRequest();
        HttpSession session=request.getSession(true);
        session.invalidate();
        session=request.getSession(true);
        return SUCCESS;        
    }
}
