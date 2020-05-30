package cn.wsxter.dao;

import cn.wsxter.domain.Collect;

import java.util.HashMap;
import java.util.List;

public interface CollectDao {
    //传入用户id和回答名，返回记录条数
    int findCollect(HashMap map);

    //添加收藏，传入collect对象
    void addCollect(Collect collect);

    //传入用户id，返回收藏数量
    int collect_num(Integer user_id);
    /**
     * @Description //TODO
     * @Date 17:17 2020/5/18
     * @Param [user_id, start, pageSize]
     * @return java.util.List<cn.wsxter.domain.Collect>
     **/
    List<Collect> findByPageUser(HashMap map);
}
