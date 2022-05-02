package com.example.demo.model;

import java.util.UUID;

public class P_VifromSQMatrix {
    UUID peerId;
    int row;
    int col;

    public P_VifromSQMatrix(UUID peerId, int row, int col) {
        this.peerId = peerId;
        this.row = row;
        this.col = col;
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
