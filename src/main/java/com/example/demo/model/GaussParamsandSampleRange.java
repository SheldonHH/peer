package com.example.demo.model;

import java.util.UUID;

public class GaussParamsandSampleRange {
    UUID userid;
    long[] gaussian_params;
    long[][]xy;

    public GaussParamsandSampleRange(UUID userid, long[] gaussian_params, long[][] xy) {
        this.userid = userid;
        this.gaussian_params = gaussian_params;
        this.xy = xy;
    }

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public long[] getGaussian_params() {
        return gaussian_params;
    }

    public void setGaussian_params(long[] gaussian_params) {
        this.gaussian_params = gaussian_params;
    }

    public long[][] getXy() {
        return xy;
    }

    public void setXy(long[][] xy) {
        this.xy = xy;
    }
}
