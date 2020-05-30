package cn.wsxter.dao;

import cn.wsxter.domain.falseanswer;

import java.util.HashMap;
import java.util.List;

public interface FADao {
    /*
     * @Description //TODO 添加待审核回答
     * @Param [answer]
     * @return void
     **/
    void addAnswer(falseanswer answer);
    /*
     * @Description //TODO 查询待审核回答总数
     * @Param []
     * @return int
     **/
    int findTotalCount();
    /*
     * @Description //传入map，返回待审核列表
     * @Param [start, pageSize]
     * @return java.util.List<cn.wsxter.domain.falseanswer>
     **/
    List<falseanswer> findByPage(HashMap map);
    /*
     * @Description //TODO 删除回答
     * @Param [answer_id]
     * @return void
     **/
    void delAanswer(Integer answer_id);
    /*
     * @Description //TODO 根据id查询回答
     * @Param [answer_id]
     * @return cn.wsxter.domain.falseanswer
     **/
    falseanswer findbyid(Integer answer_id);
}
