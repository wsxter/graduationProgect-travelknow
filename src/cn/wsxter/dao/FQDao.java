package cn.wsxter.dao;

import cn.wsxter.domain.falseques;

import java.util.List;

public interface FQDao {
    public int findTotalCount();

    List<falseques> findByPage(int start, int pageSize);

    void delques(int parseInt);
    public falseques findbyid(int ques_id);

    void userAddQues(falseques falseques);
}
