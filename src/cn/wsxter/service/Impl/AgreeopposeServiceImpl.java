package cn.wsxter.service.Impl;

import cn.wsxter.dao.AnswerDao;
import cn.wsxter.dao.ArgeeopposeDao;
import cn.wsxter.dao.Impl.AgreeopposeDaoImpl;
import cn.wsxter.dao.Impl.AnswerDaoImp;
import cn.wsxter.domain.Agreeoppose;
import cn.wsxter.domain.ResultInfo;
import cn.wsxter.service.AgreeopposeService;

public class AgreeopposeServiceImpl implements AgreeopposeService {

    private ArgeeopposeDao argeeopposeDao = new AgreeopposeDaoImpl();
    ResultInfo resultInfo = new ResultInfo();

    @Override
    public ResultInfo judgment(int parseInt,int user_id,int agropp) {
        int judgment = argeeopposeDao.judgment(parseInt, user_id);
        if (judgment < 1){
            argeeopposeDao.addarg(parseInt,user_id,agropp);

            resultInfo.setFlag(true);
            resultInfo.setErrorMsg("已赞同");

        }else {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("赞同不能取消");
        }
        return resultInfo;
    }

    @Override
    public ResultInfo loadjudgment(int i, int user_id, int i1) {
        int judgment = argeeopposeDao.judgment(i, user_id);
        if (judgment < 1){
            resultInfo.setFlag(false);
        }
        else {
            resultInfo.setFlag(true);
            resultInfo.setErrorMsg("已赞同");
        }
        return  resultInfo;
    }

    @Override
    public int comment_num(int parseInt) {
        return argeeopposeDao.comment_num(parseInt);
    }
}
