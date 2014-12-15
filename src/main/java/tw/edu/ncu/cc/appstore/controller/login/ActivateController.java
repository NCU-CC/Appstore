package tw.edu.ncu.cc.appstore.controller.login;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tw.edu.ncu.cc.appstore.entity.Person;
import tw.edu.ncu.cc.appstore.service.IPersonService;
import tw.edu.ncu.cc.appstore.util.PersonInfo;
import tw.edu.ncu.cc.appstore.util.PersonUtil;

import com.opensymphony.xwork2.ActionSupport;
@Component
@Scope("prototype")
public class ActivateController extends ActionSupport {
    private static final long serialVersionUID = 1L;    
    private HttpServletRequest request;
    private IPersonService<Person> service;
    
  
    @Inject
    public void setService(IPersonService<Person> service) {
        this.service = service;
    }
    
    @Override
    public String execute() throws Exception {
        request=ServletActionContext.getRequest();
        PersonInfo personInfo=PersonUtil.getPersonInfo(request);
        String tmpId=personInfo.getAccount();
        if(tmpId!=null && tmpId.length()>0){
            Person person=service.findPersonByAccount(tmpId);
            if(person!=null){                
                return SUCCESS;
            }
        }                        
        return LOGIN;
    }
 
}
