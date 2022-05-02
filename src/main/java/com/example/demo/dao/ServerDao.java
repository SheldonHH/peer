package com.example.demo.dao;

import com.example.demo.model.*;
import com.example.demo.p4p.user.UserVector2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.UUID;

// dependency injection
public interface ServerDao {
    int insertUiandProof(UUID id, UiandProof uniandproof);
    default int insertUiandProof(UiandProof uniandproof){
        UUID data_id = UUID.randomUUID();
        return insertUiandProof(data_id, uniandproof);
    }

    int insertGaussParamsandSampleRange(GaussParamsandSampleRange gaussian_params);

    int insertVSum(VSum vSum);

    int distanceofReceiveRquestSumCount(SampleSumandCount sampleSumandCount);

//    default int insertVi(Person person){
//        UUID id = UUID.randomUUID();
//        return insertVi(id, person);
//    }
    // return zero or one depends on whether data is persisted

    long[] sumUi(Person person);

    long[] sumUandV(Person person);

//    Optional<long[]> selectPeerVById(UUID id);

//    int deletePersonById(UUID id);
//
//    int updatePersonById(UUID id, Person person);


}
