package com.example.demo.dao;

import com.example.demo.model.*;
import com.example.demo.p4p.user.UserVector2;
import org.springframework.stereotype.Repository;

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
