package com.example.demo.dao;

import com.example.demo.model.P_SumandCountforUnit;
import com.example.demo.model.P_VifromSQMatrix;
import com.example.demo.model.Person;
import com.example.demo.model.RCVisTuple;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person){
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public int insertPerson(Person person) {
        return PersonDao.super.insertPerson(person);
    }

    @Override
    public RCVisTuple requestVifromSQMatrix(P_VifromSQMatrix p_vifromSQMatrix) {
        return null;
    }

    @Override
    public long[] requestSumandCountforUnit(P_SumandCountforUnit p_sumandCountforUnit) {
        return new long[0];
    }

    @Override
    public List<Person> selectAllPeople(){
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person ->person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());

        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id)
                .map(p -> {
                    int indexOfPersonToUpdate = DB.indexOf(update);
                    if(indexOfPersonToUpdate >=0 ){
                        DB.set(indexOfPersonToUpdate, new  Person(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

}
