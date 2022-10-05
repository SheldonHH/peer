package com.example.demo.model.vmatrixhash;

import java.util.UUID;

public class P_VifromSQMatrix {
    UUID peerId;
    int row;
    int col;
    String batch_time;

    public P_VifromSQMatrix(UUID peerId, int row, int col,  String batch_time) {
        this.peerId = peerId;
        this.row = row;
        this.col = col;
        this.batch_time = batch_time;
    }

    public String getBatch_time() {
        return batch_time;
    }

    public void setBatch_time(String batch_time) {
        this.batch_time = batch_time;
    }

    public UUID getPeerId() {
        return peerId;
    }

    public void setPeerId(UUID peerId) {
        this.peerId = peerId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
