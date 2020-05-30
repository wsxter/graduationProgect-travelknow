package cn.wsxter.dao;

import cn.wsxter.domain.falseques;

import java.util.HashMap;
import java.util.List;

public interface FQDao {
    /*
     * @Description //TODO 查询总记录数
     * @Param []
     * @return int
     **/
    public int findTotalCount();
    /*
     * @Description //TODO 分页map
     * @Param [start, pageSize]
     * @return java.util.List<cn.wsxter.domain.falseques>
     **/
    List<falseques> findByPage(HashMap map);
    /*
     * @Description //TODO 删除
     * @Param [parseInt]
     * @return void
     **/
    void delques(int parseInt);
    public falseques findbyid(int ques_id);
    /*
     * @Description //TODO 添加问题到问题表
     * @Param [falseques]
     * @return void
     **/
    void userAddQues(falseques falseques);
}
