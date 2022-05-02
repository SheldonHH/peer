package com.example.demo.model;

import java.util.UUID;

// how to write a client
public class TwoDimensionalGaussianUnit {
    public UUID uuid;
    public int x;
    public int y;
    public long[] di;

    public TwoDimensionalGaussianUnit(int uuid, int x, int y, long[] di) {
        this.x = x;
        this.y = y;
        this.di = di;
    }
}
