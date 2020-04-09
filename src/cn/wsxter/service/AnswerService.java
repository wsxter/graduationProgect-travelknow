package cn.wsxter.service;

import cn.wsxter.domain.Answer;
import cn.wsxter.domain.PageBean;
import cn.wsxter.domain.indexPageBean;

public interface AnswerService {

    PageBean<Answer> pageQuery(int question_id, int pageSize, int currentPage);
    void  addAnswer(Answer answer);
    indexPageBean answerQuery(int answer_id);
}