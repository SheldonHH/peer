package com.example.demo.service;

import com.example.demo.dao.PeerDao;
import com.example.demo.model.*;
import com.example.demo.model.vmatrixhash.ResponseVRowCol;
import com.example.demo.model.vmatrixhash.RowColTreeHMaps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

    public int hashVerifywithReceiveRquestRCVisTuple(ResponseVRowCol responseVRowCol){
        return  peerDao.hashVerifywithReceiveRquestRCVisTuple(responseVRowCol);
    }

    public int commenceVi(PersonCount personCount){
        return peerDao.commenceVi(personCount);
    }

    public int finishVi(PersonCount personCount){
        return peerDao.finishVi(personCount);
    }

    public int rowcoltreeHashMap(RowColTreeHMaps rowColTreeHMaps){
        return peerDao.rowcoltreeHashMap(rowColTreeHMaps);
    }

}