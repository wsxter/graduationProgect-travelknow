package cn.wsxter.service;

import cn.wsxter.domain.PageBean;

public interface userZoneService {
    PageBean userZoneQuery(Integer user_id, int currentPage, int pageSize, int buttonCetogry);
}
