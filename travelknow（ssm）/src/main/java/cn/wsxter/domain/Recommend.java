package cn.wsxter.domain;

public class Recommend {
    private Integer id;
    private Integer answer_id;
    private Integer question_id;
    private String create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
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
        return "Recommend{" +
                "id=" + id +
                ", answer_id=" + answer_id +
                ", question_id=" + question_id +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}

