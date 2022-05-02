package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

// response to server's request of the specified row and col number
public class RCVisTuple {
    public String[][] row_vi;
    public String[][] col_vi;
    public RCVisTuple(@JsonProperty("row_vi") String[][] row_vi, @JsonProperty("col_vi")  String[][] col_vi) {
        this.row_vi = row_vi;
        this.col_vi = col_vi;
    }

    public void setRow_vi(String[][] row_vi) {
        this.row_vi = row_vi;
    }

    public void setCol_vi(String[][] col_vi) {
        this.col_vi = col_vi;
    }

    public String[][] getRow_vi() {
        return row_vi;
    }

    public String[][] getCol_vi() {
        return col_vi;
    }
}
