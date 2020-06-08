package org.svuonline.mahrukat.model;

public class order {
    private int id;
    private int distributor_id;
    private int requested_quantity;
    private String request_date;
    private String status;
    private int available_quantity;
    private String receiving_date;

    public order() {
    }

    public order(int id, int distributor_id, int requested_quantity, String request_date, String status, int available_quantity, String receiving_date) {
        this.id = id;
        this.distributor_id = distributor_id;
        this.requested_quantity = requested_quantity;
        this.request_date = request_date;
        this.status = status;
        this.available_quantity = available_quantity;
        this.receiving_date = receiving_date;
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

    public int getRequested_quantity() {
        return requested_quantity;
    }

    public void setRequested_quantity(int requested_quantity) {
        this.requested_quantity = requested_quantity;
    }

    public String getRequest_date() {
        return request_date;
    }

    public void setRequest_date(String request_date) {
        this.request_date = request_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(int available_quantity) {
        this.available_quantity = available_quantity;
    }

    public String getReceiving_date() {
        return receiving_date;
    }

    public void setReceiving_date(String receiving_date) {
        this.receiving_date = receiving_date;
    }
}
