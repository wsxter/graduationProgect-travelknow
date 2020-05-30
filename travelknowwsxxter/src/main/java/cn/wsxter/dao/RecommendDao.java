package cn.wsxter.dao;

import cn.wsxter.domain.Recommend;

import java.util.List;

public interface RecommendDao {
   /*
    * @Description //TODO 
    * @Param [Star, Page_Size]
    * @return java.util.List<cn.wsxter.domain.Recommend>
    **/
   public List<Recommend> rec_list(int Star, int Page_Size);
}
