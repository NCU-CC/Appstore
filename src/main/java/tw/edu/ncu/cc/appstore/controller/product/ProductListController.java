package tw.edu.ncu.cc.appstore.controller.product;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tw.edu.ncu.cc.appstore.entity.Page;
import tw.edu.ncu.cc.appstore.entity.Product;
import tw.edu.ncu.cc.appstore.entity.ProductState;
import tw.edu.ncu.cc.appstore.entity.ProductStateEnum;
import tw.edu.ncu.cc.appstore.service.IProductStateService;

import com.opensymphony.xwork2.ActionSupport;
@Component
@Scope("prototype")
public class ProductListController extends ActionSupport{
    private static final long serialVersionUID = 1L;
    private static final int COUNT = 6;
    private IProductStateService<ProductState> serivce;
    private List<Product> productList;
    private List<Integer> productsId;
    private int page;    
    private Page pageManager;
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
        if(page<=0){
            page=1;
        }
        for(ProductState ps : list){
            List<Product> psList = ps.getAllProducts();
            for(int i=psList.size()-1;i>=0;i--){
                Product psp = psList.get(i);
                if(psp.getState().equals(ProductStateEnum.CHECKED.toString())){
                    if(group == null || group.length()==0){
                        productList.add(psp);
                        productsId.add(ps.getId());
                    }else if(psp.getUserGroup().contains(group) || psp.getCategory().contains(group) ){
                        productList.add(psp);
                        productsId.add(ps.getId());                        
                    }
                    break;
                }
            }            
        }
        doPagination();        
        return SUCCESS;
    }
    private void doPagination(){
        pageManager = new Page();
        pageManager.setPreviousPage(page-1);
        int from = (page-1)*COUNT;
        int end  = (page)*COUNT-1;
        if(productList.size()-1<from){
            productList=null;
            productsId=null;
            pageManager.setNextPage(-1);
        }else if(productList.size()-1<=end){
            productList= productList.subList(from, productList.size());
            productsId = productsId.subList(from, productsId.size());
            pageManager.setNextPage(-1);
        }else{
            productList= productList.subList(from, end+1);
            productsId = productsId.subList(from, end+1);
            pageManager.setNextPage(page+1);
        }
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
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public Page getPageManager() {
        return pageManager;
    }
    public void setPageManager(Page pageManager) {
        this.pageManager = pageManager;
    }

}
