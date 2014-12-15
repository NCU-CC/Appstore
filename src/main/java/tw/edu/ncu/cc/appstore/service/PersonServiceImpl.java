package tw.edu.ncu.cc.appstore.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tw.edu.ncu.cc.appstore.entity.Person;
import tw.edu.ncu.cc.appstore.entity.PersonType;
import tw.edu.ncu.cc.appstore.util.StringOperator;

@Service
public class PersonServiceImpl <T extends Person> extends ServiceImpl<T> implements IPersonService<T>{

    @SuppressWarnings("unchecked")
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public T findPersonByAccount(String account) {
        List<T> person = this.getDao().creatQuery(
                "select p from Person p " +
                        "where p.account = :account and deleted=false "
                        ).setParameter("account", account.trim()).getResultList();
        if(person.size()>0){
            return person.get(0);
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public T findAdminByAccount(String account) {
        List<T> person = this.getDao().creatQuery(
                "select p from Person p " +
                        "where p.account = :account and deleted=false and p.type = :type "
                        ).setParameter("account", account.trim()).setParameter("type", PersonType.ADMIN.toString()).getResultList();
        if(person.size()>0){
            return person.get(0);
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    @Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
    public T findAdminByAccountAndPassword(String account,String passwordin) {
        String password = StringOperator.md5(passwordin);
        List<T> person = this.getDao().creatQuery(
                "select p from Person p " +
                        "where p.account = :account and deleted=false and p.type = :type and p.password = :password "
                        ).setParameter("account", account.trim()).setParameter("type", PersonType.ADMIN.toString()).setParameter("password", password).getResultList();
        if(person.size()>0){
            return person.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void create(T person) {
        if(findPersonByAccount(person.getAccount())!=null){
            throw new RuntimeException("account " +person.getAccount() + "has already existed");
        }
        this.getDao().create(person);
    }    
}
