package cn.wsxter.dao;

import cn.wsxter.domain.place;
import java.util.List;

public interface CategoryDao {
   public List<place> findall();
   public place findOne(int place_id);
}
