package cn.wsxter.dao;

import cn.wsxter.domain.Answer;

import java.util.List;

public interface AnswerDao {
    //根据place_id查询总记录数
    public  int findTotalCount(int question_id);
    //limt start ，pageSize，  place_id
    public List<Answer> findByPage(int question_id,int start,int pageSize);
    public  List<Answer> findNewest(int start, int pageSize);

    void updateAnswer(Answer answer);
    Answer answer_query(int answer_id);

    int addComment(int parseInt);

    int findTotalCountbyUserId(Integer user_id);

    List<Answer> findByPageUser(Integer user_id, int start, int pageSize);
}
