package com.example.demo.model;

// response to server's request of the specified row and col number
public class RCVisTuple {
    public long[][] row_vi;
    public long[][] col_vi;
    public RCVisTuple(long[][] row_vi, long[][] col_vi) {
        this.row_vi = row_vi;
        this.col_vi = col_vi;
    }

    public long[][] getRow_vi() {
        return row_vi;
    }

    public void setRow_vi(long[][] row_vi) {
        this.row_vi = row_vi;
    }

    public long[][] getCol_vi() {
        return col_vi;
    }

    public void setCol_vi(long[][] col_vi) {
        this.col_vi = col_vi;
    }
}
