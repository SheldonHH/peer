package com.example.demo.dao;

import com.example.demo.model.*;
import com.example.demo.model.vmatrixhash.ResponseVRowCol;
import com.example.demo.model.vmatrixhash.RowColTreeHMaps;

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

    int rowcoltreeHashMap(RowColTreeHMaps rowColTreeHMaps);
    int hashVerifywithReceiveRquestRCVisTuple(ResponseVRowCol responseVRowCol);
//    default int insertVi(Person person){
//        UUID id = UUID.randomUUID();
//        return insertVi(id, person);
//    }
    // return zero or one depends on whether data is persisted

    long sumVi(UUID person_id, String batch_time);

//    Optional<long[]> selectPeerVById(UUID id);

//    int deletePersonById(UUID id);
//
//    int updatePersonById(UUID id, Person person);


}
