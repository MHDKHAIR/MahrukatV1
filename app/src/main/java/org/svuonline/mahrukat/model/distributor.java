package org.svuonline.mahrukat.model;

public class distributor {
    private int id;
    private String full_name;
    private String password;
    private int mobile;
    private int national_id;
    private String address;
    private String profile_pic;
    private int cr_no;
    private String status;
    private int max_cylinders;
    private String city_id;

    public distributor() {
    }

    public distributor(int id, String full_name, String password, int mobile, int national_id, String address, String profile_pic, int cr_no, String status, int max_cylinders, String city_id) {
        this.id = id;
        this.full_name = full_name;
        this.password = password;
        this.mobile = mobile;
        this.national_id = national_id;
        this.address = address;
        this.profile_pic = profile_pic;
        this.cr_no = cr_no;
        this.status = status;
        this.max_cylinders = max_cylinders;
        this.city_id = city_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getNational_id() {
        return national_id;
    }

    public void setNational_id(int national_id) {
        this.national_id = national_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public int getCr_no() {
        return cr_no;
    }

    public void setCr_no(int cr_no) {
        this.cr_no = cr_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMax_cylinders() {
        return max_cylinders;
    }

    public void setMax_cylinders(int max_cylinders) {
        this.max_cylinders = max_cylinders;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }
}
