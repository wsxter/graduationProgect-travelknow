package cn.wsxter.dao;

import cn.wsxter.domain.Answer;
import cn.wsxter.domain.PageBean;
import cn.wsxter.domain.Question;

import java.util.List;

public interface QuestionDao {

    //根据place_id查询总记录数
    public   int findTotalCount(int place_id);
    //limt start ，pageSize，  place_id
    public  List<Question> findByPage(int place_id, int start, int pageSize);
}
