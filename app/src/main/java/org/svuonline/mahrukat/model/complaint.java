package org.svuonline.mahrukat.model;

public class complaint {
    private int id;
    private int distributor_id;
    private int customer_id;
    private String reason;
    private String date;
    private String status;

    public complaint() {
    }

    public complaint(int id, int distributor_id, int customer_id, String reason, String date, String status) {
        this.id = id;
        this.distributor_id = distributor_id;
        this.customer_id = customer_id;
        this.reason = reason;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistributor_id() {
        return distributor_id;
    }

    public void setDistributor_id(int distributor_id) {
        this.distributor_id = distributor_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
