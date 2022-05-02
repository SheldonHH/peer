package com.example.demo.dao;

import com.example.demo.model.P_SumandCountforUnit;
import com.example.demo.model.P_VifromSQMatrix;
import com.example.demo.model.Person;
import com.example.demo.model.RCVisTuple;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao{
    private final String url = "jdbc:postgresql://localhost:5432/demodb";
    private final String user = "postgres";
    private final String password = "password";
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    private static List<Person> DB = new ArrayList<>();

//    https://www.postgresqltutorial.com/postgresql-jdbc/insert/
    @Override
    public int insertPerson(UUID person_uuid, Person person){
        String SQL = "INSERT INTO PERSON(person_id,name) "
                + "VALUES(?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setObject (1, person_uuid);
            pstmt.setString(2, person.getName());
            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    System.out.println(rs);
//                    if (rs.next()) {
////                        id = rs.getLong(1);
//                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertPerson(Person person) {
        return PersonDao.super.insertPerson(person);
    }

    @Override
    public RCVisTuple requestVifromSQMatrix(P_VifromSQMatrix p_vifromSQMatrix){ return null; }

    @Override
    public long[] requestSumandCountforUnit(P_SumandCountforUnit p_sumandCountforUnit) {
        return new long[0];
    }

    @Override
    public List<Person> selectAllPeople(){
        List<Person> personList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * from PERSON")) {
            while(rs.next()){
                UUID person_id = (UUID) rs.getObject("person_id");
                String username = rs.getString("name");
                personList.add(new Person(person_id,username));
            }
            if (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return personList;
//        return List.of(new Person(UUID.randomUUID(), " SELECT FROM POSTGRES DB"));
    }
//  List.of()  Returns an immutable list containing zero elements.

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
