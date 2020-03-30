package cn.wsxter.service.Impl;

import cn.wsxter.dao.CategoryDao;
import cn.wsxter.dao.Impl.CategoryDaoImp;
import cn.wsxter.dao.Impl.UserDaoImpl;
import cn.wsxter.dao.UserDao;
import cn.wsxter.domain.place;
import cn.wsxter.service.CategoryService;

import java.util.List;
import java.util.Locale;

public class CategoryServiceImp implements CategoryService {
    private CategoryDao dao = new CategoryDaoImp();
    @Override
    public List<place> findAll() {
        return dao.findall();

    }
}
