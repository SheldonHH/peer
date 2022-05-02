package com.example.demo.dao;

import com.example.demo.model.P_SumandCountforUnit;
import com.example.demo.model.P_VifromSQMatrix;
import com.example.demo.model.Person;
import com.example.demo.model.RCVisTuple;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// dependency injection
public interface
PersonDao {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }
    // return zero or one depends on whether data is persisted

    RCVisTuple requestVifromSQMatrix(P_VifromSQMatrix p_vifromSQMatrix);
    long[] requestSumandCountforUnit(P_SumandCountforUnit p_sumandCountforUnit);
    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);


}
