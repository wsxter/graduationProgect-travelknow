package cn.wsxter.dao;

import cn.wsxter.domain.Answer;
import cn.wsxter.domain.Question;
import cn.wsxter.domain.place;

import java.util.List;

public interface QuestionDao {

    //根据place_id查询总记录数
    public   int findTotalCount(int place_id,String question_name);
    //limt start ，pageSize，  place_id
    public  List<Question> findByPage(int place_id, int start, int pageSize,String question_name);
    public  List<Question> findNewest(int start, int pageSize);
    public  int totalcount();
    public  Question findOne(int question_id);

    List<Question> find_hot();

    void addques(String ques_name, String ques_describle, Integer place_id, Integer user_id);

    Question findbyname(String ques_name,int opicId);

    int findTotalCountbyUserId(Integer user_id);

    List<Question> findByPageUser(Integer user_id, int start, int pageSize);

    List<Question> findlikename(String question_name);
}
