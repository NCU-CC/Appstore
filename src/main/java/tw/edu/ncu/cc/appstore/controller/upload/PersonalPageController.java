package tw.edu.ncu.cc.appstore.controller.upload;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tw.edu.ncu.cc.appstore.entity.Person;
import tw.edu.ncu.cc.appstore.entity.ProductState;
import tw.edu.ncu.cc.appstore.service.IPersonService;
import tw.edu.ncu.cc.appstore.util.PersonUtil;

import com.opensymphony.xwork2.ActionSupport;
@Component
@Scope("prototype")
public class PersonalPageController extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private IPersonService<Person> service;
    private List<ProductState> productsList;
    public List<ProductState> getProductsList() {
        return productsList;
    }
    public void setProductsList(List<ProductState> productsList) {
        this.productsList = productsList;
    }
    @Inject
    public void setService(IPersonService<Person> service) {
        this.service = service;
    }
    @Override
    public String execute() throws Exception {
        if(PersonUtil.isLogined(ServletActionContext.getRequest())){
            HttpServletRequest request=ServletActionContext.getRequest();        
            String tmpId=PersonUtil.getStudentId(request);
            if(tmpId!=null && tmpId.length()>0){
                Person person=service.findPersonByAccount(tmpId);
                if(person!=null){
                    List<ProductState> forDelete = new ArrayList<ProductState>();
                    List<ProductState> productsList =person.getProducts();
                    for(ProductState pp : productsList){
                        if(pp.isDeleted()==true){
                            forDelete.add(pp);
                        }
                    }
                    productsList.removeAll(forDelete);
                    this.productsList=productsList;
                    return SUCCESS;
                }                
            }        
        }
        return LOGIN;
    
    }
}
