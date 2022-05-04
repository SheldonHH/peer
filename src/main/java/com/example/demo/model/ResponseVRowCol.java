package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ResponseVRowCol {
    ArrayList<ArrayList<String>> rowVs;
    ArrayList<ArrayList<String>> colVs;

    public ResponseVRowCol( @JsonProperty("rowVs") ArrayList<ArrayList<String>> rowVs, @JsonProperty("colVs")ArrayList<ArrayList<String>> colVs) {
        this.rowVs = rowVs;
        this.colVs = colVs;
    }

    public ArrayList<ArrayList<String>> getRowVs() {
        return rowVs;
    }

    public void setRowVs(ArrayList<ArrayList<String>> rowVs) {
        this.rowVs = rowVs;
    }

    public ArrayList<ArrayList<String>> getColVs() {
        return colVs;
    }

    public void setColVs(ArrayList<ArrayList<String>> colVs) {
        this.colVs = colVs;
    }
}
