package cn.wsxter.domain;

public class falseques {
    private Integer ques_id;
    private String ques_name;
    private Integer user_id;
    private  String ques_describle;
    private  String place_name;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getQues_id() {
        return ques_id;
    }

    public void setQues_id(Integer ques_id) {
        this.ques_id = ques_id;
    }

    public String getQues_name() {
        return ques_name;
    }

    public void setQues_name(String ques_name) {
        this.ques_name = ques_name;
    }

    public String getQues_describle() {
        return ques_describle;
    }

    public void setQues_describle(String ques_describle) {
        this.ques_describle = ques_describle;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    @Override
    public String toString() {
        return "falseques{" +
                "ques_id=" + ques_id +
                ", ques_name='" + ques_name + '\'' +
                ", user_id=" + user_id +
                ", ques_describle='" + ques_describle + '\'' +
                ", place_name='" + place_name + '\'' +
                '}';
    }
}
