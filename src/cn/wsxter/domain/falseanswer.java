package cn.wsxter.domain;

public class falseanswer {
    private Integer answer_id;
    private Integer user_id;
    private String ques_name;
    private String answer_content;
    private  String place_name;
    private  String  ques_describle;

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

    public String getQues_name() {
        return ques_name;
    }

    public void setQues_name(String ques_name) {
        this.ques_name = ques_name;
    }

    public String getAnswer_content() {
        return answer_content;
    }

    public void setAnswer_content(String answer_content) {
        this.answer_content = answer_content;
    }

    @Override
    public String toString() {
        return "falseanswer{" +
                "answer_id=" + answer_id +
                ", user_id=" + user_id +
                ", ques_name='" + ques_name + '\'' +
                ", answer_content='" + answer_content + '\'' +
                ", place_name='" + place_name + '\'' +
                ", ques_describle='" + ques_describle + '\'' +
                '}';
    }
}
