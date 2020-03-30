package cn.wsxter.domain;

public class place {
    private int place_id;
    private String place_name;

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
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
                '}';
    }
}
