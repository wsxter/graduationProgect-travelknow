package cn.wsxter.Service;

import cn.wsxter.domain.ResultInfo;

public interface AgreeopposeService {
    ResultInfo judgment(int parseInt,int user_id,int agropp);

    ResultInfo loadjudgment(int i, int user_id, int i1);

    int comment_num(int parseInt);
}
