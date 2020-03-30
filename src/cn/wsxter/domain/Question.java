package cn.wsxter.domain;

public class Question {
    private int question_id;
    private int user_id;
    private String question_name;
    private String ques_describle;
    private String photo;
    private int opicId;
    private int attend_num;
    private int answer_num;
    private String create_time;


    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
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

    public int getOpicId() {
        return opicId;
    }

    public void setOpicId(int opicId) {
        this.opicId = opicId;
    }

    public int getAttend_num() {
        return attend_num;
    }

    public void setAttend_num(int attend_num) {
        this.attend_num = attend_num;
    }

    public int getAnswer_num() {
        return answer_num;
    }

    public void setAnswer_num(int answer_num) {
        this.answer_num = answer_num;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
    @Override
    public String toString() {
        return "question{" +
                "question_id=" + question_id +
                ", user_id=" + user_id +
                ", question_name='" + question_name + '\'' +
                ", question_describle='" + ques_describle + '\'' +
                ", photo='" + photo + '\'' +
                ", opicId=" + opicId +
                ", attend_num=" + attend_num +
                ", answer_num=" + answer_num +
                ", create_time='" + create_time + '\'' +
                '}';
    }

}
