package cn.wsxter.domain;

import java.util.Date;

public class Question {
    private Integer question_id;
    private Integer user_id;
    private String question_name;
    private String ques_describle;
    private String photo;
    private Integer opicId;
    private Integer attend_num;
    private Integer answer_num;
    private Date create_time;
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
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

    public String getQues_describle() {
        return ques_describle;
    }

    public void setQues_describle(String ques_describle) {
        this.ques_describle = ques_describle;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getOpicId() {
        return opicId;
    }

    public void setOpicId(Integer opicId) {
        this.opicId = opicId;
    }

    public Integer getAttend_num() {
        return attend_num;
    }

    public void setAttend_num(Integer attend_num) {
        this.attend_num = attend_num;
    }

    public Integer getAnswer_num() {
        return answer_num;
    }

    public void setAnswer_num(Integer answer_num) {
        this.answer_num = answer_num;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question_id=" + question_id +
                ", user_id=" + user_id +
                ", question_name='" + question_name + '\'' +
                ", ques_describle='" + ques_describle + '\'' +
                ", photo='" + photo + '\'' +
                ", opicId=" + opicId +
                ", attend_num=" + attend_num +
                ", answer_num=" + answer_num +
                ", create_time=" + create_time +
                ", status=" + status +
                '}';
    }

}
