package cn.wsxter.dao;

import cn.wsxter.domain.Answer;
import cn.wsxter.domain.Collect;

import java.util.List;

public interface CollectDao {
    int findCollect(int parseInt, Integer user_id);

    void addCollect(String answer_content, String question_name, Integer user_id ,int parseInt);

    int collect_num(Integer user_id);


    List<Collect> findByPageUser(Integer user_id, int start, int pageSize);
}
