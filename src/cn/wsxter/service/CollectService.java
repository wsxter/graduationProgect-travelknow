package cn.wsxter.service;

import cn.wsxter.domain.ResultInfo;

public interface CollectService {
    ResultInfo findCollect(int parseInt, Integer user_id);

    ResultInfo loadfindCollect(int parseInt, Integer user_id);

    int collect_num(Integer user_id);
}
