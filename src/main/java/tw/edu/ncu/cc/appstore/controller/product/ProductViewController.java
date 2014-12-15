package tw.edu.ncu.cc.appstore.controller.product;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tw.edu.ncu.cc.appstore.entity.Product;
import tw.edu.ncu.cc.appstore.entity.ProductState;
import tw.edu.ncu.cc.appstore.entity.ProductStateEnum;
import tw.edu.ncu.cc.appstore.service.IProductStateService;

import com.opensymphony.xwork2.ActionSupport;
@Component
@Scope("prototype")
public class ProductViewController extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private IProductStateService<ProductState> serivce;
    @Inject
    public void setSerivce(IProductStateService<ProductState> serivce) {
        this.serivce = serivce;
    }
    private int id;
    private String errorTitle;
    private String errorMessage;
    private Product product;
    @Override
    public String execute() throws Exception {
        if(id==0){            
            return INPUT;
        }
        
        ProductState productState= serivce.find(ProductState.class, id);
        if(productState!=null){
            List<Product> list =productState.getAllProducts();
            for(int i=list.size()-1;i>=0;i--){
                product=list.get(i);
                if(product.getState().equals(ProductStateEnum.CHECKED.toString())){
                    return SUCCESS;
                }
            }            
        }
        
        errorTitle="存取錯誤";
        errorMessage="您所要查詢的APP目前不在架上";
        
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
    public String getErrorTitle() {
        return errorTitle;
    }
    public void setErrorTitle(String errorTitle) {
        this.errorTitle = errorTitle;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
