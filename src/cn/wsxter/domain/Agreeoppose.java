package cn.wsxter.domain;

public class Agreeoppose {
    private Integer answer_id;
    private Integer user_id;
    private Integer argopp;

    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getArgopp() {
        return argopp;
    }

    public void setArgopp(Integer argopp) {
        this.argopp = argopp;
    }

    @Override
    public String toString() {
        return "Agreeoppose{" +
                "answer_id=" + answer_id +
                ", user_id=" + user_id +
                ", argopp=" + argopp +
                '}';
    }
}
