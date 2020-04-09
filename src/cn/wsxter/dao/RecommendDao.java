package cn.wsxter.dao;

import cn.wsxter.domain.Recommend;

import java.util.List;

public interface RecommendDao {
   public List<Recommend> rec_list(int Star,int Page_Size);
}
