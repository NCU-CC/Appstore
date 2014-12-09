package tw.edu.ncu.cc.appstore.controller.product;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tw.edu.ncu.cc.appstore.entity.PersonType;
import tw.edu.ncu.cc.appstore.entity.Product;
import tw.edu.ncu.cc.appstore.entity.ProductState;
import tw.edu.ncu.cc.appstore.service.IProductStateService;
import tw.edu.ncu.cc.appstore.util.PersonInfo;
import tw.edu.ncu.cc.appstore.util.PersonUtil;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class AllProductListController extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private IProductStateService<ProductState> serivce;
    @Inject
    public void setSerivce(IProductStateService<ProductState> serivce) {
        this.serivce = serivce;
    }
    private String wantState;
    private List<Product> productList;
    private List<Integer> productsId;
    
    @Override
    public String execute() throws Exception {
        if(!PersonUtil.isLogined(ServletActionContext.getRequest())){            
            return LOGIN;
        }
        PersonInfo info=PersonUtil.getPersonInfo(ServletActionContext.getRequest());
        if(!info.getType().equals(PersonType.ADMIN.toString())){
            return LOGIN;
        }
        productList= new ArrayList<Product>();
        productsId = new ArrayList<Integer>();
        List<ProductState> allList = serivce.getAllProductState();
        for(ProductState ps : allList){
            List<Product> list = ps.getAllProducts();
            Product product = list.get(list.size()-1);
            if(wantState==null || wantState.length()==0){
                productList.add(product);
                productsId.add(ps.getId());
            }else if(product.getState().equals(wantState)){
                productList.add(product);
                productsId.add(ps.getId());
            }
        }        
        return super.execute();
    }
    
    
    public String getWantState() {
        return wantState;
    }
    public void setWantState(String wantState) {
        this.wantState = wantState.toUpperCase();
    }
    public List<Product> getProductList() {
        return productList;
    }
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    public List<Integer> getProductsId() {
        return productsId;
    }
    public void setProductsId(List<Integer> productsId) {
        this.productsId = productsId;
    }
}
