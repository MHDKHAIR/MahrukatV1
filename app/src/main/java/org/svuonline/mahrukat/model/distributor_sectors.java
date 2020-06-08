package org.svuonline.mahrukat.model;

import java.lang.ref.SoftReference;

public class distributor_sectors {
    private int id;
    private int distributor_id;
    private int sector_id;

    public distributor_sectors() {
    }

    public distributor_sectors(int id, int distributor_id, int sector_id) {
        this.id = id;
        this.distributor_id = distributor_id;
        this.sector_id = sector_id;
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

    public int getSector_id() {
        return sector_id;
    }

    public void setSector_id(int sector_id) {
        this.sector_id = sector_id;
    }
}
