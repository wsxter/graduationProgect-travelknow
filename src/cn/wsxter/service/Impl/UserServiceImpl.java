package cn.wsxter.service.Impl;

import cn.wsxter.dao.Impl.UserDaoImpl;
import cn.wsxter.dao.UserDao;
import cn.wsxter.domain.Customer;
import cn.wsxter.service.UserService;
import org.apache.taglibs.standard.lang.jstl.NullLiteral;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();


    @Override
    public Customer login(Customer customer) {
        return dao.findUserByUsernameAndPassword(customer.getUsername(),customer.getPassword());
    }

    @Override
    public boolean addUser(Customer customer) {
        Customer customer1 = dao.findbyUsername(customer.getUsername());
        if (customer1 != null){
            return false;
        }else {
            dao.addUser(customer);
            return true;

        }


    }


}