package com.example.demo.model;

import java.util.UUID;

public class VHashMatrix {
    UUID userid;
    long[][]vi;
    RowColHash rowColHash;

    public VHashMatrix(UUID userid, long[][] vi, RowColHash rowColHash) {
        this.userid = userid;
        this.vi = vi;
        this.rowColHash = rowColHash;
    }

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public long[][] getVi() {
        return vi;
    }

    public void setVi(long[][] vi) {
        this.vi = vi;
    }

    public RowColHash getRowColHash() {
        return rowColHash;
    }

    public void setRowColHash(RowColHash rowColHash) {
        this.rowColHash = rowColHash;
    }
}
