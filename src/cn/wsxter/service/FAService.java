package cn.wsxter.service;

import cn.wsxter.domain.PageBean;
import cn.wsxter.domain.falseanswer;

public interface FAService {


    PageBean<falseanswer> findAnswer(int currentPage, int pageSize);

    void addAnswer(falseanswer falseanswer);

    void delanswer(String answer_id);

    void addAnswertrue(String answer_id);

}
