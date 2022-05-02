package com.example.demo.model;

import com.example.demo.p4p.user.UserVector2;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UiandProof {
    private UUID userid;
    private long[] ui;
    private UserVector2.L2NormBoundProof2 serverProof;
    @JsonCreator
    public UiandProof(@JsonProperty("userid") UUID userid, @JsonProperty("ui") long[] ui,@JsonProperty("serverProof")  UserVector2.L2NormBoundProof2 serverProof) {
        this.userid = userid;
        this.ui = ui;
        this.serverProof = serverProof;
    }

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public long[] getUi() {
        return ui;
    }

    public void setUi(long[] ui) {
        this.ui = ui;
    }

    public UserVector2.L2NormBoundProof2 getServerProof() {
        return serverProof;
    }

    public void setServerProof(UserVector2.L2NormBoundProof2 serverProof) {
        this.serverProof = serverProof;
    }
}
