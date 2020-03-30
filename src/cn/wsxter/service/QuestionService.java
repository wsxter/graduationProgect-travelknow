package cn.wsxter.service;


import cn.wsxter.domain.PageBean;
import cn.wsxter.domain.Question;

public interface QuestionService {
    public PageBean<Question> pageQuery(int place_id, int pageSize, int currentPage,String question_name);
}
