package tw.edu.ncu.cc.appstore.controller.login;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tw.edu.ncu.cc.appstore.entity.Person;
import tw.edu.ncu.cc.appstore.entity.PersonType;
import tw.edu.ncu.cc.appstore.service.IPersonService;
import tw.edu.ncu.cc.appstore.util.PersonUtil;
import tw.edu.ncu.cc.appstore.util.StringOperator;

import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope("prototype")
public class AdminLoginController extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private static final String adminName="admin";
    private HttpServletRequest request;
    private IPersonService<Person> service;
    @Inject
    public void setService(IPersonService<Person> service) {
        this.service = service;
    }
    private String userName;
    private String userPassword;
    @Override
    public String execute() {
        return LOGIN;
    }
    public String login(){
        request=ServletActionContext.getRequest();
        Person person= service.findAdminByAccount(adminName);
        if(person==null){
            person= new Person();
            newLogin(person,adminName);
            person.setPassword(StringOperator.md5(adminName));
            service.create(person);
        }
        
        Person pp = service.findAdminByAccountAndPassword(userName, userPassword);
        if(pp!=null){            
            HttpSession session=request.getSession();
            session.invalidate();
            session=request.getSession(true);
            notNewLogin(person);
            service.save(person);
            addInSession(person);  
            return SUCCESS;
        }
        
        return LOGIN;
    }
    private void addInSession(Person person){
        PersonUtil.setPersonInf(request, person);
    }
    
    private void newLogin(Person person,String id){
        person.setAccount(id);
        person.setDateCreated(new Date());
        person.setDateLastActived(new Date());
        person.setDeleted(false);
        person.setIpCreated(request.getRemoteAddr());
        person.setIpLastActived(request.getRemoteAddr());
        person.setType(PersonType.ADMIN.toString());
    }
    
    private void notNewLogin(Person person){
        person.setDateLastActived(new Date());
        person.setIpLastActived(request.getRemoteAddr());
    }
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
