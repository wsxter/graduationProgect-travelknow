package cn.wsxter.service;

import cn.wsxter.domain.place;

import java.util.List;

public interface CategoryService {

    public List<place> findAll();
    public place findOne(int opicId);
    public List<place> updateOne(String place_name);
}
