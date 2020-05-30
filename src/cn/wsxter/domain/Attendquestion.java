package cn.wsxter.domain;

public class Attendquestion {
    private Integer user_id;
    private Integer question_id;
    private String create_time;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Attendquestion{" +
                "user_id=" + user_id +
                ", question_id=" + question_id +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
