package cn.wsxter.domain;

public class Collect {
    private Integer collect_id;
    private Integer answer_id;
    private Integer user_id;
    private String question_name;
    private String answer_content;
    private String create_time;

    public Integer getCollect_id() {
        return collect_id;
    }

    public void setCollect_id(Integer collect_id) {
        this.collect_id = collect_id;
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

    public String getQuestion_name() {
        return question_name;
    }

    public void setQuestion_name(String question_name) {
        this.question_name = question_name;
    }

    public String getAnswer_content() {
        return answer_content;
    }

    public void setAnswer_content(String answer_content) {
        this.answer_content = answer_content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "collect_id=" + collect_id +
                ", answer_id=" + answer_id +
                ", user_id=" + user_id +
                ", question_name='" + question_name + '\'' +
                ", answer_content='" + answer_content + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
