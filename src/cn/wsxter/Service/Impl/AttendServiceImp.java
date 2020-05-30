package cn.wsxter.Service.Impl;

import cn.wsxter.dao.AttendDao;
import cn.wsxter.dao.Impl.AttendDaoImp;
import cn.wsxter.domain.Attendquestion;
import cn.wsxter.Service.AttendService;

public class AttendServiceImp implements AttendService {
    private AttendDao attendDao = new AttendDaoImp();
    @Override
    public Attendquestion attengQuery(int parseInt, Integer user_id) {
        return attendDao.attendQuery(parseInt,user_id);
    }

    @Override
    public void attendQues(int parseInt, Integer user_id) {
        attendDao.attendQues(parseInt,user_id);
    }

    @Override
    public void delAttend(int parseInt, Integer user_id) {
        attendDao.delAttend(parseInt,user_id);
    }
}
