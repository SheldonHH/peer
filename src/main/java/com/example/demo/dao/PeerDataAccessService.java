package com.example.demo.dao;

import com.example.demo.model.*;
import com.example.demo.p4p.user.UserVector2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.*;
import java.util.*;

@Repository("postgres1")
public class PeerDataAccessService implements PeerDao{
    private static List<Person> DB = new ArrayList<>();
    private final String url = "jdbc:postgresql://localhost:5432/peer1";
    private final String user = "peer1";
    private final String password = "password";
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    final static CloseableHttpClient httpClient = HttpClients.createDefault();

    @Override
    public int commenceVi(PersonCount personCount) {
        String SQL = "INSERT INTO PERSON_STATS(user_id, count) "
                + "VALUES(?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setObject(1, personCount.getPerson_ID());
            pstmt.setInt(2, personCount.getCount());
            // convert to string array first, then insert as TEXT array
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
    public int sqWidth(double israel){
        return (int)Math.ceil(Math.sqrt(israel));
    }
    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @Override
    public int finishVi(PersonCount personCount){
        //TODO: route port with person id
//        int person_id = person.getId();
        HttpPost request = new HttpPost("http://localhost:10001/api/v1/person/requestrc");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
        StringEntity json = null;
        int sqWidth = sqWidth(personCount.getCount());
        try {
            int request_Row = getRandomNumberUsingNextInt(0,sqWidth-1);
            int request_Col = getRandomNumberUsingNextInt(0,sqWidth-1);
            while((request_Row+1)*(request_Col+1)>sqWidth){
                request_Row = getRandomNumberUsingNextInt(0,sqWidth-1);
                request_Col = getRandomNumberUsingNextInt(0,sqWidth-1);
            }
                                                                                    // this peer_id
            json = new StringEntity(mapper.writeValueAsString(new P_VifromSQMatrix(UUID.fromString("b75de71c-c097-47c9-b4ee-62deeaba5280"),request_Row, request_Col)), ContentType.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        request.setEntity(json);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response.getStatusLine().getStatusCode() != 200){
            System.out.println("finishSending is not added! "+response.getStatusLine().getStatusCode() );
        }
        return 0;
    }

    @Override
    public int insertViandProof(UUID data_id,ViandProof viandProof)
    {
        String SQL = "INSERT INTO V_PERSON_DATA(data_id,name,v1,v2,verified) "
                + "VALUES(?,?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            System.out.println("uiandProof.getUi()"+ Arrays.toString(viandProof.getVi()));
            pstmt.setObject(1, data_id);
            pstmt.setObject(2, viandProof.getUserid());
            long[] vi_arr =  viandProof.getVi();
            // convert to string array first, then insert as TEXT array
            String[] strArray = Arrays.stream(vi_arr)
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new);
            Array sg = conn.createArrayOf("TEXT", strArray);
            pstmt.setArray(3,  sg);
            pstmt.setArray(4, sg);
            pstmt.setBoolean(5, false);
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
    public int insertVHashMatrix(VHashMatrix vHashMatrix) {

        return 0;
    }

    @Override
    public int hashVerifywithReceiveRquestRCVisTuple(RCVisTupleUser rcVisTupleUser) {
//        UUID userID = rcVisTupleUser.getUserid();

        return 0;
    }

    @Override
    public long sumVi(Person person) {
        return 0;
    }

}
