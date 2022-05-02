package com.example.demo.dao;

import com.example.demo.model.*;
import com.example.demo.p4p.user.UserVector2;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// dependency injection
public interface PeerDao {
    int insertViandProof(UUID id, ViandProof viandProof);
    default int insertViandProof(ViandProof viandProof){
        UUID data_id = UUID.randomUUID();
        return insertViandProof(data_id, viandProof);
    }
    int commenceVi(PersonCount personCount);
    int finishVi(PersonCount personCount);
    int insertVHashMatrix(VHashMatrix vHashMatrix);
    int hashVerifywithReceiveRquestRCVisTuple(RCVisTupleUser rcVisTupleUser);
//    default int insertVi(Person person){
//        UUID id = UUID.randomUUID();
//        return insertVi(id, person);
//    }
    // return zero or one depends on whether data is persisted

    long sumVi(Person person);

//    Optional<long[]> selectPeerVById(UUID id);

//    int deletePersonById(UUID id);
//
//    int updatePersonById(UUID id, Person person);


}
