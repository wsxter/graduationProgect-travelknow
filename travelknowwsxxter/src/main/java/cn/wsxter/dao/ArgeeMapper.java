package cn.wsxter.dao;

import cn.wsxter.domain.Agreeoppose;

import java.util.HashMap;

public interface ArgeeMapper {
    //判断点赞多少，传入回答id，用户id
    int judgment(HashMap<String, Object> map);
    //添加点赞，传入agreeoppose
    void addagree(Agreeoppose a);

    //查询问题的点赞数
    int commentnum(int parseInt);
}
