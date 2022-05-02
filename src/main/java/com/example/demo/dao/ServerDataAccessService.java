package com.example.demo.dao;

import com.example.demo.model.*;
import com.example.demo.p4p.user.UserVector2;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository("postgres0")
public class ServerDataAccessService implements ServerDao{
    private static List<Person> DB = new ArrayList<>();
    private final String url = "jdbc:postgresql://localhost:5432/server1";
    private final String user = "postgres";
    private final String password = "password";
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

        @Override
    public int insertUiandProof(UUID data_id, UiandProof uiandProof) {
        String SQL = "INSERT INTO V_PERSON_DATA(data_id,name,u1,u2,verified) "
                    + "VALUES(?,?,?,?,?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            System.out.println("uiandProof.getUi()"+Arrays.toString(uiandProof.getUi()));
            pstmt.setObject(1, data_id);
            pstmt.setObject(2, uiandProof.getUserid());
            long[] ui_arr =  uiandProof.getUi();
            Long[] aLong = new Long[ui_arr.length];
            Arrays.setAll(aLong, i -> aLong[i]);
            Array sg = conn.createArrayOf("BIGINT", aLong);
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
    public int insertGaussParamsandSampleRange(GaussParamsandSampleRange gaussian_params) {
        return 0;
    }

    @Override
    public int insertVSum(VSum vSum) {
        return 0;
    }


    @Override
    public int distanceofReceiveRquestSumCount(SampleSumandCount sampleSumandCount) {
        return 0;
    }

    @Override
    public long[] sumUi(Person person) {
        return new long[0];
    }

    @Override
    public long[] sumUandV(Person person) {
        return new long[0];
    }
}
