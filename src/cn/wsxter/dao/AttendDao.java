package cn.wsxter.dao;

import cn.wsxter.domain.Answer;
import cn.wsxter.domain.Attendquestion;

import java.util.List;

public interface AttendDao {
    int findTotalCountbyUserId(Integer user_id);

    List<Attendquestion> findByPageUser(Integer user_id);


    Attendquestion attendQuery(int parseInt, Integer user_id);

    void attendQues(int parseInt, Integer user_id);

    void delAttend(int parseInt, Integer user_id);
}
