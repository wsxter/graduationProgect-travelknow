package cn.wsxter.domain;

public class Image {
    private Integer img_id;
    private  Integer user_id;
    private String img_desc;
    private String photo;
    private Integer img_place;
    private String create_time;

    public Integer getImg_id() {
        return img_id;
    }

    public void setImg_id(Integer img_id) {
        this.img_id = img_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getImg_desc() {
        return img_desc;
    }

    public void setImg_desc(String img_desc) {
        this.img_desc = img_desc;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getImg_place() {
        return img_place;
    }

    public void setImg_place(Integer img_place) {
        this.img_place = img_place;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Image{" +
                "img_id=" + img_id +
                ", user_id=" + user_id +
                ", img_desc='" + img_desc + '\'' +
                ", photo='" + photo + '\'' +
                ", img_place=" + img_place +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
