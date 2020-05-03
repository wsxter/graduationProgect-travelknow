package cn.wsxter.service;

import cn.wsxter.domain.PageBean;
import cn.wsxter.domain.falseques;

public interface FQService {

    PageBean<falseques> findQues(int currentPage, int pageSize);

    void delques(int parseInt);

    void addques(int parseInt);

    void userAddQues(falseques falseques);
}
