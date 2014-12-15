package tw.edu.ncu.cc.appstore.controller.product;

import java.util.ArrayList;
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
public class ProductListController extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private IProductStateService<ProductState> serivce;
    private List<Product> productList;
    private List<Integer> productsId;
    private String group;
    @Inject
    public void setSerivce(IProductStateService<ProductState> serivce) {
        this.serivce = serivce;
    }
    @Override
    public String execute(){
        List<ProductState> list = serivce.getAllProductState();
        productList= new ArrayList<Product>();
        productsId = new ArrayList<Integer>();
        if(list==null){
            return SUCCESS;
        }
        for(ProductState ps : list){
            List<Product> psList = ps.getAllProducts();
            for(int i=psList.size()-1;i>=0;i--){
                Product psp = psList.get(i);
                if(psp.getState().equals(ProductStateEnum.CHECKED.toString())){
                    if(group == null || group.length()==0){
                        productList.add(psp);
                        productsId.add(ps.getId());
                    }else if(psp.getUserGroup().contains(group)){
                            productList.add(psp);
                            productsId.add(ps.getId());                        
                    }
                    break;
                }
            }            
        }
        return SUCCESS;
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
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }

}
