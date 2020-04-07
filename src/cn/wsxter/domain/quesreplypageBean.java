package cn.wsxter.domain;

public class quesreplypageBean {
    private Customer customer;
    private Question question;
    private place place;

    public cn.wsxter.domain.place getPlace() {
        return place;
    }

    public void setPlace(cn.wsxter.domain.place place) {
        this.place = place;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "quesreplypageBean{" +
                "customer=" + customer +
                ", question=" + question +
                ", place=" + place +
                '}';
    }
}
