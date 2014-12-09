package tw.edu.ncu.cc.appstore.controller.product;

import java.util.List;

import javax.inject.Inject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import tw.edu.ncu.cc.appstore.entity.Product;
import tw.edu.ncu.cc.appstore.entity.ProductState;
import tw.edu.ncu.cc.appstore.service.IProductStateService;
import tw.edu.ncu.cc.appstore.util.PersonInfo;
import tw.edu.ncu.cc.appstore.util.PersonUtil;

@Controller
@Scope("prototype")
public class ProductEditController extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private IProductStateService<ProductState> serivce;
    @Inject
    public void setSerivce(IProductStateService<ProductState> serivce) {
        this.serivce = serivce;
    }
    private int id;
    private Product product;
    
    @Override
    public String execute(){
        if(!PersonUtil.isLogined(ServletActionContext.getRequest())){            
            return LOGIN;
        }        
        if(id==0){            
            return INPUT;
        }        
        ProductState productState= serivce.find(ProductState.class, id);
        if(productState!=null){
            List<Product> list =productState.getAllProducts();
            product=list.get(list.size()-1);
            PersonInfo info=PersonUtil.getPersonInfo(ServletActionContext.getRequest());
            if(product.getAuthor().getAccount().equals(info.getAccount())){                
                return SUCCESS;
            }
        }       
        return ERROR;
    }
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
