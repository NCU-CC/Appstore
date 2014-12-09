package tw.edu.ncu.cc.appstore.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tw.edu.ncu.cc.appstore.entity.ProductState;
@Service
public class ProductStateServiceImpl <T extends ProductState> extends ServiceImpl<T> implements IProductStateService<T>{

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void create(T baseBean) {
        this.getDao().create(baseBean);
    }
    
    @SuppressWarnings("unchecked")
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public List<T> getAllProductState() {
        List<T> productState = this.getDao().creatQuery(
                "select p from ProductState p " +
                        "where p.deleted=false"
                        ).getResultList();
        
            return productState;
    }
}
