package cn.wsxter.service.Impl;

import cn.wsxter.dao.CategoryDao;
import cn.wsxter.dao.Impl.CategoryDaoImp;
import cn.wsxter.domain.place;
import cn.wsxter.service.CategoryService;

import java.util.List;

public class CategoryServiceImp implements CategoryService {
    private CategoryDao dao = new CategoryDaoImp();
    @Override
    public List<place> findAll() {
        return dao.findall();

    }

    @Override
    public place findOne(int opicId) {
        return dao.findOne(opicId);
    }

    @Override
    public List<place> updateOne(String place_name) {
        return  dao.inserOne(place_name);
    }
}
