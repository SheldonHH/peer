package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

// response to server's request of the specified row and col number
public class RCVisTuple {
    public ArrayList<String> row_vi;
    public ArrayList<String> col_vi;
    public RCVisTuple(@JsonProperty("row_vi") ArrayList<String> row_vi, @JsonProperty("col_vi")  ArrayList<String> col_vi) {
        this.row_vi = row_vi;
        this.col_vi = col_vi;
    }

    public void setRow_vi(ArrayList<String> row_vi) {
        this.row_vi = row_vi;
    }

    public void setCol_vi(ArrayList<String> col_vi) {
        this.col_vi = col_vi;
    }

    public ArrayList<String> getRow_vi() {
        return row_vi;
    }

    public ArrayList<String> getCol_vi() {
        return col_vi;
    }
}
