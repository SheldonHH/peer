package com.example.demo.model;

import java.util.ArrayList;
import java.util.UUID;

public class VSum
{
    UUID peerID;
    UUID personID;
    ArrayList<Long> v_sum;

    public VSum(UUID peerID, UUID personID, ArrayList<Long> v_sum) {
        this.peerID = peerID;
        this.personID = personID;
        this.v_sum = v_sum;
    }

    public UUID getPersonID() {
        return personID;
    }

    public void setPersonID(UUID personID) {
        this.personID = personID;
    }

    public UUID getPeerID() {
        return peerID;
    }

    public void setPeerID(UUID peerID) {
        this.peerID = peerID;
    }

    public ArrayList<Long> getV_sum() {
        return v_sum;
    }

    public void setV_sum(ArrayList<Long> v_sum) {
        this.v_sum = v_sum;
    }
}
