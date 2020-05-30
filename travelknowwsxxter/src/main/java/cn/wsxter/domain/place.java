package cn.wsxter.domain;

public class place {
    private Integer place_id;
    private String place_name;
    private  String create_time;

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Integer getPlace_id() {
        return place_id;
    }

    public void setPlace_id(Integer place_id) {
        this.place_id = place_id;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    @Override
    public String toString() {
        return "place{" +
                "place_id=" + place_id +
                ", place_name='" + place_name + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
