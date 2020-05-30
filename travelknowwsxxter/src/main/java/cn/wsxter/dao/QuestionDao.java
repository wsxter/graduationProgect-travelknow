package cn.wsxter.dao;

import cn.wsxter.domain.Question;

import java.util.HashMap;
import java.util.List;

public interface QuestionDao {

    //根据place_id查询总记录数
    public   int findTotalCount(int place_id, String question_name);

    /*
     * @Description //TODO 最新的、排序
     * @Param [start, pageSize]
     * @return java.util.List<cn.wsxter.domain.Question>
     **/
    public  List<Question> findNewest(HashMap map);


    //传入问题名、和地点id，返回对象、传入id，返回对象
    Question findByOneByNameByplace(Question question);

    //添加问题，传入question对象
    void addques(Question question);

    //按点赞数排序
    List<Question> find_hot();



    //limt start ，pageSize，  place_id,question_name
    // 分页，传入用户id、star、pageSize，返回列表
    public  List<Question> findByPage(HashMap map);


    //传入问题名，模糊查询，返回列表
    List<Question> findlikename(String question_name);
}
