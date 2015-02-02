package tw.edu.ncu.cc.appstore.entity;

import java.io.Serializable;

public class Page implements Serializable{
    private static final long serialVersionUID = 1L;
    private int nextPage;
    private int previousPage;
    
    public int getNextPage() {
        return nextPage;
    }
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
    public int getPreviousPage() {
        return previousPage;
    }
    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }
    
}
