package tw.edu.ncu.cc.appstore.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tw.edu.ncu.cc.appstore.openid.OpenIDException;
import tw.edu.ncu.cc.appstore.openid.OpenIDManager;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class AuthController extends ActionSupport {

    private static final long serialVersionUID = 1L;
    @Autowired
    private HttpServletRequest request;  
    private String student_id = "";

    @Override
    public String execute() throws Exception {
        request = ServletActionContext.getRequest();
        student_id = checkOpenId();
        if (student_id != null && student_id.trim().length() > 0) {               
                login(student_id);
                return SUCCESS;
        }
        return ERROR;
    }
    
    private void login(String id){
        HttpSession session=request.getSession(true);
        session.setAttribute("tmpId", id);
    }

    private String checkOpenId() {
        try {
            OpenIDManager manager = new OpenIDManager();
            boolean isChecked = manager.checkAuthentication(request);
            if(isChecked){
                return manager.getIdentityID(request);
            }
        } catch (OpenIDException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

}
