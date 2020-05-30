package cn.wsxter.Service;

import cn.wsxter.domain.Attendquestion;

public interface AttendService {
    Attendquestion attengQuery(int parseInt, Integer user_id);

    void attendQues(int parseInt, Integer user_id);

    void delAttend(int parseInt, Integer user_id);
}
