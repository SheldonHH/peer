package com.example.demo.service;

import com.example.demo.dao.PeerDao;
import com.example.demo.dao.PersonDao;
import com.example.demo.dao.ServerDao;
import com.example.demo.model.*;
import com.example.demo.p4p.user.UserVector2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServerService {
    private final ServerDao serverDao;

    @Autowired
    public ServerService( @Qualifier("postgres0") ServerDao serverDao) {
        this.serverDao = serverDao;
    }

    public int insertUiandProof(UiandProof uiandProof) {
        return serverDao.insertUiandProof(uiandProof);
    }

    public int insertGaussParamsandSampleRange(GaussParamsandSampleRange gaussian_params){
        return serverDao.insertGaussParamsandSampleRange(gaussian_params);
    }

    public int insertVSum(VSum vSum){
        return serverDao.insertVSum(vSum);
    }

    public int sendRquestSampleSumCount(SampleSumandCount sampleSumandCount){
        return serverDao.distanceofReceiveRquestSumCount(sampleSumandCount);
    }

}