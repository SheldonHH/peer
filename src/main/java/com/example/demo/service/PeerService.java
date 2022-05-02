package com.example.demo.service;

import com.example.demo.dao.PeerDao;
import com.example.demo.dao.PersonDao;
import com.example.demo.model.*;
import com.example.demo.p4p.user.UserVector2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PeerService {
    private final PeerDao peerDao;

    @Autowired
    public PeerService(@Qualifier("postgres1") PeerDao peerDao){
        this.peerDao = peerDao;
    }
    public int addViandProof(ViandProof viandProof){
        return  peerDao.insertViandProof(viandProof);
    }

    public int addVHashMatrix(VHashMatrix vHashMatrix){
         return  peerDao.insertVHashMatrix(vHashMatrix);
    }

    public int hashVerifywithReceiveRquestRCVisTuple(RCVisTupleUser rcVisTupleUser){
        return  peerDao.hashVerifywithReceiveRquestRCVisTuple(rcVisTupleUser);
    }

}