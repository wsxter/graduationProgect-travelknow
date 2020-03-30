package cn.wsxter.service;

import cn.wsxter.domain.Answer;
import cn.wsxter.domain.PageBean;

public interface AnswerService {

    PageBean<Answer> pageQuery(int place_id, int pageSize, int currentPage);
}