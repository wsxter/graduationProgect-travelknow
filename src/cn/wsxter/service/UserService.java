package cn.wsxter.service;

import cn.wsxter.domain.User;

public interface UserService {
    User login(User user);

   void  addUser(User user);


}
