package cn.wsxter.service.Impl;

import cn.wsxter.dao.Impl.UserDaoImpl;
import cn.wsxter.dao.UserDao;
import cn.wsxter.domain.User;
import cn.wsxter.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();


    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);

    }


}