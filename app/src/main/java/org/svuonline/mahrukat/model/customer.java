package org.svuonline.mahrukat.model;

public class customer {
    private int id;
    private String full_name;
    private String password;
    private int mobile;
    private int national_id;
    private String address;
    private String profile_pic;
    private int card_id;
    private String status;
    private int order_no;
    private String city_id;
    private String sector_id;

    public customer() {

    }

    public customer(int id, String full_name, String password, int mobile, int national_id, String address, String profile_pic, int card_id, String status, int order_no, String city_id, String sector_id) {
        this.id = id;
        this.full_name = full_name;
        this.password = password;
        this.mobile = mobile;
        this.national_id = national_id;
        this.address = address;
        this.profile_pic = profile_pic;
        this.card_id = card_id;
        this.status = status;
        this.order_no = order_no;
        this.city_id = city_id;
        this.sector_id = sector_id;
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

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrder_no() {
        return order_no;
    }

    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getSector_id() {
        return sector_id;
    }

    public void setSector_id(String sector_id) {
        this.sector_id = sector_id;
    }
}
