package com.example.demo.model;

import java.math.BigInteger;

public class RowColHash {
    public String username;
    public String rcType;
    public int index_num;
    public BigInteger[] index_Hash;

    public RowColHash(String username, String rcType, int index_num, BigInteger[] index_Hash) {
        this.username = username;
        this.rcType = rcType;
        this.index_num = index_num;
        this.index_Hash = index_Hash;
    }

}
