package cn.wsxter.service;

import cn.wsxter.domain.Customer;

public interface UserService {
    Customer login(Customer customer);

   boolean  addUser(Customer customer);


}
