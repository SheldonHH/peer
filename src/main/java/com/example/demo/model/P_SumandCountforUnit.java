package com.example.demo.model;

import java.util.UUID;

public class P_SumandCountforUnit {
    UUID serverID;
    int x1;
    int x2;

    public UUID getServerID() {
        return serverID;
    }

    public void setServerID(UUID serverID) {
        this.serverID = serverID;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public P_SumandCountforUnit(UUID serverID, int x1, int x2) {
        this.serverID = serverID;
        this.x1 = x1;
        this.x2 = x2;
    }
}
