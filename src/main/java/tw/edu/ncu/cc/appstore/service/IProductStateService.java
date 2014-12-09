package tw.edu.ncu.cc.appstore.service;

import java.util.List;

import tw.edu.ncu.cc.appstore.entity.ProductState;

public interface IProductStateService <T extends ProductState> extends IService<T>{
    List<T> getAllProductState();
}
