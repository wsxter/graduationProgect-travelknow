package cn.wsxter.domain;

public class Answer {

    private Integer answer_id;
    private Integer user_id;
    private Integer question_id;
    private String answer_content;
    private String photo;
    private Integer comment_num;
    private String create_time;



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

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getAnswer_content() {
        return answer_content;
    }

    public void setAnswer_content(String answer_content) {
        this.answer_content = answer_content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getComment_num() {
        return comment_num;
    }

    public void setComment_num(Integer comment_num) {
        this.comment_num = comment_num;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }



    @Override
    public String toString() {
        return "Answer{" +
                "answer_id=" + answer_id +
                ", user_id=" + user_id +
                ", question_id=" + question_id +
                ", answer_content='" + answer_content + '\'' +
                ", photo='" + photo + '\'' +
                ", comment_num=" + comment_num +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
