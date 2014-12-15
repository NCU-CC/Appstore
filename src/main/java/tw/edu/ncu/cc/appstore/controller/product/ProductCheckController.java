package tw.edu.ncu.cc.appstore.controller.product;

import java.util.List;

import javax.inject.Inject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import tw.edu.ncu.cc.appstore.controller.TokenBasisController;
import tw.edu.ncu.cc.appstore.entity.PersonType;
import tw.edu.ncu.cc.appstore.entity.Product;
import tw.edu.ncu.cc.appstore.entity.ProductCategory;
import tw.edu.ncu.cc.appstore.entity.ProductState;
import tw.edu.ncu.cc.appstore.entity.ProductStateEnum;
import tw.edu.ncu.cc.appstore.service.IProductStateService;
import tw.edu.ncu.cc.appstore.util.PersonInfo;
import tw.edu.ncu.cc.appstore.util.PersonUtil;

@Controller
@Scope("prototype")
public class ProductCheckController extends TokenBasisController{
    private static final long serialVersionUID = 1L;
    private IProductStateService<ProductState> serivce;
    @Inject
    public void setSerivce(IProductStateService<ProductState> serivce) {
        this.serivce = serivce;
    }
    private int id;
    private String newState;
    private String newCategory;
    private Product product;
    
    @Override
    public String execute(){
        if(!PersonUtil.isLogined(ServletActionContext.getRequest())){            
            return LOGIN;
        }
        PersonInfo info=PersonUtil.getPersonInfo(ServletActionContext.getRequest());
        if(!info.getType().equals(PersonType.ADMIN.toString())){
            return LOGIN;
        }
        if(id==0){            
            return INPUT;
        }
        
        ProductState productState= serivce.find(ProductState.class, id);
        if(productState!=null){
            List<Product> list =productState.getAllProducts();
            product=list.get(list.size()-1);
            createTokenForGet();
            return SUCCESS;
        }       
        return ERROR;
    }
    
    public String upload(){
        if(!PersonUtil.isLogined(ServletActionContext.getRequest())){            
            return LOGIN;
        }
        PersonInfo info=PersonUtil.getPersonInfo(ServletActionContext.getRequest());
        if(!info.getType().equals(PersonType.ADMIN.toString())){
            return LOGIN;
        }
        if(id==0){            
            return ERROR;
        }
        ProductState productState= serivce.find(ProductState.class, id);
        if(productState!=null){
            boolean isChanged = false;
            List<Product> list =productState.getAllProducts();
            product=list.get(list.size()-1);
            if(newState!=null && (newState.equals(ProductStateEnum.CHECKED.toString()) || newState.equals(ProductStateEnum.CHECKING.toString()) || newState.equals(ProductStateEnum.FAIL.toString()) || newState.equals(ProductStateEnum.UNCHECKED.toString()) )){
                product.setState(newState);
                isChanged=true;
            }
            
            if(newCategory!=null && (newCategory.equals(ProductCategory.NONOFFICIAL.toString()) || newCategory.equals(ProductCategory.OFFICIAL.toString()) || newCategory.equals(ProductCategory.APPCONTEST.toString()) )){
                product.getCategory().remove(ProductCategory.NONOFFICIAL.toString());
                product.getCategory().remove(ProductCategory.OFFICIAL.toString());
                product.getCategory().remove(ProductCategory.APPCONTEST.toString());
                product.getCategory().add(newCategory);
                isChanged=true;
            }
            if(isChanged){
                serivce.save(productState);
            }
            createTokenForGet();
            return SUCCESS;
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

    public String getNewState() {
        return newState;
    }

    public void setNewState(String newState) {
        this.newState = newState;
    }

    public String getNewCategory() {
        return newCategory;
    }

    public void setNewCategory(String newCategory) {
        this.newCategory = newCategory;
    }
    
}
