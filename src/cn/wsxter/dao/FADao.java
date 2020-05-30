package cn.wsxter.dao;

import cn.wsxter.domain.falseanswer;

import java.util.List;

public interface FADao {
    void addAnswer(falseanswer answer);

    int findTotalCount();

    List<falseanswer> findByPage(int start, int pageSize);

    void delAanswer(String answer_id);

    falseanswer findbyid(String answer_id);
}
