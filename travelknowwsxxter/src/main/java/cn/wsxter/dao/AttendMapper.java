package cn.wsxter.dao;

import cn.wsxter.domain.Attendquestion;

import java.util.HashMap;
import java.util.List;

public interface AttendMapper {
    //查询用户关注问题数量
    int findTotalCountbyUserId(Integer user_id);

    //传入用户id查询用户关注问题，返回问题list
    List<Attendquestion> findByPageUser(Integer user_id);


    //传入问题id，用户id，返回问题<mape>
    Attendquestion attendQuery(HashMap map);

    //添加关注，传入问题id、用户id
    void attendQues(Attendquestion attendquestion);

    //取消关注，传入问题id、用户id
    void delAttend(Attendquestion attendquestion);
}
