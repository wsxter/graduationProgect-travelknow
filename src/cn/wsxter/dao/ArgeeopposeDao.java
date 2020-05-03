package cn.wsxter.dao;

import cn.wsxter.domain.Agreeoppose;

public interface ArgeeopposeDao {
    int judgment(int parseInt,int user_id);

    void addarg(int parseInt, int user_id, int agropp);

    int comment_num(int parseInt);
}
