package cn.wsxter.dao;

import cn.wsxter.domain.place;

import java.util.List;

public interface CategoryDao {
    //查询所有地点，列表返回
   public List<place> findall();
   //传入place_id，返回place
 //  public place findOne(int place_id);
   //添加并返回对应对象
   void inserOne(place place);

   //传入place_name，返回place
    //place findbyname(String place_name);
    place findby(place place);

    //传入place_name添加地点
   // void addplace(String place_name);
}
