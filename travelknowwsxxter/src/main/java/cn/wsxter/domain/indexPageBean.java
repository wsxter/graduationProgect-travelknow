package cn.wsxter.domain;

public class indexPageBean{

    private Answer answer;
    private Question question;
    private String question_name;
    private String place_name;
    private String username;

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public String getQuestion_name() {
        return question_name;
    }

    public void setQuestion_name(String question_name) {
        this.question_name = question_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "indexPageBean{" +
                "question_name='" + question_name + '\'' +
                ", username='" + username + '\'' +
                ", answer=" + answer +
                ", question=" + question +
                ", place_name='" + place_name + '\'' +
                '}';
    }
}
