package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.TreeMap;
import java.util.UUID;

public class RowColTreeHMaps {
    UUID user_id;
    TreeMap<Integer, Integer> colHashMap = new TreeMap<>();
    TreeMap<Integer, Integer> rowHashMap = new TreeMap<>();


    public RowColTreeHMaps(@JsonProperty("user_id") UUID user_id, @JsonProperty("colHashMap") TreeMap<Integer, Integer> colHashMap, @JsonProperty("rowHashMap")TreeMap<Integer, Integer> rowHashMap) {
        this.user_id = user_id;
        this.colHashMap = colHashMap;
        this.rowHashMap = rowHashMap;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public TreeMap<Integer, Integer> getColHashMap() {
        return colHashMap;
    }

    public void setColHashMap(TreeMap<Integer, Integer> colHashMap) {
        this.colHashMap = colHashMap;
    }

    public TreeMap<Integer, Integer> getRowHashMap() {
        return rowHashMap;
    }

    public void setRowHashMap(TreeMap<Integer, Integer> rowHashMap) {
        this.rowHashMap = rowHashMap;
    }

}
