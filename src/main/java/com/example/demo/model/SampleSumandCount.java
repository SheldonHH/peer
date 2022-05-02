package com.example.demo.model;

import java.util.UUID;

public class SampleSumandCount {
    UUID userid;
    long[] di_sum;
    long di_count;

    public SampleSumandCount(UUID userid, long[] di_sum, long di_count) {
        this.userid = userid;
        this.di_sum = di_sum;
        this.di_count = di_count;
    }

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public long[] getDi_sum() {
        return di_sum;
    }

    public void setDi_sum(long[] di_sum) {
        this.di_sum = di_sum;
    }

    public long getDi_count() {
        return di_count;
    }

    public void setDi_count(long di_count) {
        this.di_count = di_count;
    }
}
