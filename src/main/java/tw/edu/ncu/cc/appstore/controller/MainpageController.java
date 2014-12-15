package tw.edu.ncu.cc.appstore.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope("prototype")
public class MainpageController extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {    
                    return SUCCESS;
    }
}
