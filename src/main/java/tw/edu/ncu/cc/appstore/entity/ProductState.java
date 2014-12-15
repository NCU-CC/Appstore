package tw.edu.ncu.cc.appstore.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.IndexColumn;

@Entity
public class ProductState extends BaseBean{
    private static final long serialVersionUID = 1L;
    private String state;   
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date lastChanged;
    @IndexColumn(name="LIST_INDEX")
    @OneToMany (cascade=CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Product> allProducts=new ArrayList<Product>();
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Date getLastChanged() {
        return lastChanged;
    }
    public void setLastChanged(Date lastChanged) {
        this.lastChanged = lastChanged;
    }
    public List<Product> getAllProducts() {
        return allProducts;
    }
    public void setAllProducts(List<Product> allProducts) {
        this.allProducts = allProducts;
    }
}
