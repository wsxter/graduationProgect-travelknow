package cn.wsxter.domain;

public class Customer {
    private Integer user_id;
    private  String username;
    private  String password;
    private  String email;
    private  String autograph;
    private Integer role;
    private Integer status;
    private Integer root;
    private String create_time;

    public Integer getRoot() {
        return root;
    }

    public void setRoot(Integer root) {
        this.root = root;
    }

    public Integer getStatus() {


        return status;


    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getRole() {

        return role;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }


    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", autograph='" + autograph + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", root=" + root +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}