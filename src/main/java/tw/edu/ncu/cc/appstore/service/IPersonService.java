package tw.edu.ncu.cc.appstore.service;

import tw.edu.ncu.cc.appstore.entity.Person;

public interface IPersonService<T extends Person> extends IService<T>{
    T findPersonByAccount(String account);
}
