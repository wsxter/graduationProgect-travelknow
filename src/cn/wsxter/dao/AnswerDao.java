package cn.wsxter.dao;

import cn.wsxter.domain.Answer;

import java.util.List;

public interface AnswerDao {
    //根据place_id查询总记录数
    public  int findTotalCount(int place_id);
    //limt start ，pageSize，  place_id
    public List<Answer> findByPage(int cid,int start,int pageSize);
}
