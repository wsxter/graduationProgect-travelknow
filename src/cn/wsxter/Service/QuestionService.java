package cn.wsxter.Service;


import cn.wsxter.domain.PageBean;
import cn.wsxter.domain.Question;
import cn.wsxter.domain.indexPageBean;

import java.util.List;

public interface QuestionService {
    public PageBean<Question> pageQuery(int place_id, int pageSize, int currentPage, String question_name);
    public PageBean<Question> newestpageQuery(int pageSize, int currentPage);
    public  Question findOne(int question_id);
    public indexPageBean questionQuery(int question_id);
    public List<Question> find_hot();
    public PageBean<Question> findbyname(String question_name);


}
