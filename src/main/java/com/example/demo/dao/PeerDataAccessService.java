package com.example.demo.dao;

import com.example.demo.model.*;
import com.example.demo.model.vmatrixhash.P_VifromSQMatrix;
import com.example.demo.model.vmatrixhash.ResponseVRowCol;
import com.example.demo.model.vmatrixhash.RowColTreeHMaps;
import com.example.demo.p4p.server.P4PServer;
import com.example.demo.p4p.sim.P4PSim;
import com.example.demo.p4p.user.UserVector2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.demo.p4p.sim.P4PSim.m;

@Repository("postgres1")
public class PeerDataAccessService implements PeerDao{
    public static Map<String, String> userNameMap = Stream.of(new String[][] {
//            { "f000aa01-0451-4000-b000-000000000000", "client1" },
//            { "0c1e1494-aa4a-4afa-b494-d49754b0e244", "client2" },
//            { "5ce6d22a-67be-4b64-9fee-e3302c972f6f", "client3" },
//            { "7371c17b-f1c4-45f7-84e5-0909d3470a26", "client4" },
            { "b06f2b0a-db55-42f6-a01d-7b4307229896", "client5" },
            { "61dd18f9-0d0a-4dd7-a04e-c8a36c3fc461", "client6" }
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
    public static Map<String, String> userPortMap = Stream.of(new String[][] {
//            { "f000aa01-0451-4000-b000-000000000000", "6001" },
//            { "0c1e1494-aa4a-4afa-b494-d49754b0e244", "6002" },
//            { "5ce6d22a-67be-4b64-9fee-e3302c972f6f", "6003" },
//            { "7371c17b-f1c4-45f7-84e5-0909d3470a26", "6004" },
            { "b06f2b0a-db55-42f6-a01d-7b4307229896", "6005" },
            { "61dd18f9-0d0a-4dd7-a04e-c8a36c3fc461", "6006" }
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
    private static List<Person> DB = new ArrayList<>();
    private final String url = "jdbc:postgresql://localhost:5432/peer2";
    private final String user = "peer2";
    private final String password = "password";
    UUID peer_id = UUID.fromString("5ce6d22a-67be-4b64-9fee-e3302c972f6f");
    public static UserVector2 pv = new UserVector2(m, P4PSim.F, P4PSim.l, P4PSim.g, P4PSim.h);

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    final static CloseableHttpClient httpClient = HttpClients.createDefault();

    @Override
    public int commenceVi(PersonCount personCount) {
        HashMap<String, String> userNameHashMap =
                (userNameMap instanceof HashMap)
                        ? (HashMap) userNameMap
                        : new HashMap<String, String>(userNameMap);
        String SQL = "INSERT INTO PERSON_STATS(user_id, client_name, count,created_at) "
                + "VALUES(?,?,?,NOW())";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setObject(1, personCount.getPerson_ID());
            pstmt.setString(2, userNameHashMap.get(personCount.getPerson_ID().toString()));
            pstmt.setInt(3, personCount.getCount());
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
        return min + (int)(Math.random()*max);
//        return random.nextInt(max - min) + min;
    }

    @Override
    public int finishVi(PersonCount personCount){
        //TODO: route port with person id
//        int person_id = person.getId();

        sumVi(personCount.getPerson_ID());
        System.out.println("personCount.getPerson_ID()"+personCount.getPerson_ID());
        System.out.println("personCount"+personCount.getCount());

        int sqWidth = sqWidth(personCount.getCount());
        int request_Row = 0;
        int request_Col = 0;

        request_Row = getRandomNumberUsingNextInt(1,sqWidth-1);
        request_Col = getRandomNumberUsingNextInt(1,sqWidth-1);
        while((request_Row+1)*(request_Col+1)>sqWidth){
            request_Row = getRandomNumberUsingNextInt(1,sqWidth-1);
            request_Col = getRandomNumberUsingNextInt(1,sqWidth-1);
        }
        System.out.println("request_Row"+request_Row);
        System.out.println("request_Col"+request_Col);


        String SQL = "INSERT INTO PERSON_RC(rc_id, user_id, row, col, created_at) "
                + "VALUES(?,?,?,?,NOW())";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setObject(1, UUID.randomUUID());
            pstmt.setObject(2, personCount.getPerson_ID());
            pstmt.setInt(3, request_Row);
            pstmt.setInt(4, request_Col);
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
        // this peer_id
        try {
            HashMap<String, String> portHashMap =
                    (userPortMap instanceof HashMap)
                            ? (HashMap) userPortMap
                            : new HashMap<String, String>(userPortMap);

            HttpPost request = new HttpPost("http://localhost:"+ portHashMap.get(personCount.getPerson_ID().toString())+"/api/v1/person/requestrc");
            P_VifromSQMatrix p_vifromSQMatrix = new P_VifromSQMatrix(peer_id,request_Row, request_Col);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
            StringEntity json = new StringEntity(mapper.writeValueAsString(p_vifromSQMatrix), ContentType.APPLICATION_JSON);
            request.setEntity(json);
            CloseableHttpResponse response = httpClient.execute(request);
            if(response.getStatusLine().getStatusCode() != 200){
                System.out.println("requested rcViTuples not added! "+response.getStatusLine().getStatusCode() );
            }
            response.close();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertViandProof(UUID data_id,ViandProof viandProof)
    {
        String SQL = "INSERT INTO V_PERSON_DATA(data_id,client_id,vi,verified,created_at) "
                + "VALUES(?,?,?,?,NOW())";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            System.out.println("viandProof.getVi()"+ Arrays.toString(viandProof.getVi()));
            pstmt.setObject(1, data_id);
            pstmt.setObject(2, viandProof.getUserid());
            long[] vi_arr =  viandProof.getVi();
            // convert to string array first, then insert as TEXT array
            String[] strArray = Arrays.stream(vi_arr)
                    .mapToObj(String::valueOf)
                    .toArray(String[]::new);
            Array vi_array = conn.createArrayOf("TEXT", strArray);
            pstmt.setArray(3,  vi_array);
            long [] V_longs = Arrays.stream(strArray).mapToLong(Long::parseLong).toArray();
            pv.setV(V_longs);
            boolean peerPassed = pv.verify2(viandProof.getPeerProof()); // 🌟 verify2 🌟
            pstmt.setBoolean(4, peerPassed);
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
    public int hashVerifywithReceiveRquestRCVisTuple(ResponseVRowCol responseVRowCol) {
        HashMap<String, String> userNameHashMap =
                (userNameMap instanceof HashMap)
                        ? (HashMap) userNameMap
                        : new HashMap<String, String>(userNameMap);


//        UUID userID = rcVisTupleUser.getUserid();
        System.out.println("rcVisTupleUser getColVs" + responseVRowCol.getColVs());
        System.out.println("rcVisTupleUser getRowVs" + responseVRowCol.getRowVs());
        System.out.println("responseVRowCol.getRowVs().toString():" + responseVRowCol.getRowVs().toString());
        System.out.println("rcVisTupleUser getRowVs hash" + responseVRowCol.getRowVs().toString().hashCode());
        String rcSQL = "SELECT row, col from person_rc where user_id = ?";
        String RowHashSQL = "SELECT hashresult from hashlist where index = ? and client_id = ? and roworcol='row'";
        String colHashSQL = "SELECT hashresult from hashlist where index = ? and client_id = ? and roworcol='col'";
        try {
            Connection conn = connect();
            PreparedStatement preparedStatement = conn.prepareStatement(rcSQL);
            //TODO: change to UUID tyope
            preparedStatement.setObject(1, responseVRowCol.getUser_id());
            ResultSet rs = preparedStatement.executeQuery();
            int row=0;
            int col=0;
            while (rs.next()) {
               row = rs.getInt(1);
               col = rs.getInt(2);
            }
            rs.close();


            preparedStatement = conn.prepareStatement(RowHashSQL);
            preparedStatement.setInt(1, row);
            preparedStatement.setObject(2, responseVRowCol.getUser_id());
            ResultSet rsRow = preparedStatement.executeQuery();
            int hashResultRow = 0;
            while (rsRow.next()) {
                hashResultRow = rsRow.getInt(1);
            }
            rsRow.close();

            preparedStatement = conn.prepareStatement(colHashSQL);
            preparedStatement.setInt(1, col);
            preparedStatement.setObject(2, responseVRowCol.getUser_id());
            ResultSet rsCol = preparedStatement.executeQuery();
            int hashResultcol = 0;
            while (rsCol.next()) {
                hashResultcol = rsCol.getInt(1);
            }
            rsCol.close();
            System.out.println("responseVRowCol.getUser_id():"+responseVRowCol.getUser_id());
            System.out.println("hashResultcol"+hashResultcol);

            System.out.println("hashResultRow"+hashResultRow);
            if(hashResultRow == responseVRowCol.getRowVs().toString().hashCode()){
                System.out.println(userNameHashMap.get(responseVRowCol.getUser_id().toString())+" row V verification pass");
            }

            if(hashResultcol == responseVRowCol.getColVs().toString().hashCode()){
                System.out.println(userNameHashMap.get(responseVRowCol.getUser_id().toString())+" col V verification pass");
            }
            if(hashResultcol != responseVRowCol.getColVs().toString().hashCode() || hashResultRow != responseVRowCol.getRowVs().toString().hashCode()){
                System.out.println(userNameHashMap.get(responseVRowCol.getUser_id().toString())+" NOT PASS V Hash TEST");
//                try {
//                    HttpPost request = new HttpPost("http://localhost:8081/api/v1/server/cancel_ds");
//                    ObjectMapper mapper = new ObjectMapper();
//                    mapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
//                    StringEntity json = new StringEntity(mapper.writeValueAsString(responseVRowCol.getUser_id()), ContentType.APPLICATION_JSON);
//                    request.setEntity(json);
//                    CloseableHttpResponse response = httpClient.execute(request);
//                    if(response.getStatusLine().getStatusCode() != 200){
//                        System.out.println("requested rcViTuples not added! "+response.getStatusLine().getStatusCode() );
//                    }
//                    response.close();
//                } catch (JsonProcessingException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
        @Override
    public int rowcoltreeHashMap(RowColTreeHMaps rowColTreeHMaps) {
        String SQL = "INSERT INTO " +
                "HashList(hash_id, client_id, rowOrCol, index, HashResult, created_at) "
                + "VALUES(?,?,?,?,?, NOW())";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < rowColTreeHMaps.getRowHashMap().size(); i++) {
                pstmt.setObject(1, UUID.randomUUID());
                pstmt.setObject(2, rowColTreeHMaps.getUser_id());
                pstmt.setString(3, "row");
                pstmt.setInt(4, i);
                pstmt.setInt(5, rowColTreeHMaps.getRowHashMap().get(i));
                int affectedRows = pstmt.executeUpdate();
                // check the affected rows
                if (affectedRows > 0) {
                    // get the ID back
                    try (ResultSet rs = pstmt.getGeneratedKeys()) {
                        System.out.println(rs);
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            for (int i = 0; i < rowColTreeHMaps.getColHashMap().size(); i++) {
                pstmt.setObject(1, UUID.randomUUID());
                pstmt.setObject(2, rowColTreeHMaps.getUser_id());
                pstmt.setString(3, "col");
                pstmt.setInt(4, i);
                pstmt.setInt(5, rowColTreeHMaps.getColHashMap().get(i));
                int affectedRows = pstmt.executeUpdate();
                // check the affected rows
                if (affectedRows > 0) {
                    // get the ID back
                    try (ResultSet rs = pstmt.getGeneratedKeys()) {
                        System.out.println(rs);
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public long sumVi(UUID person_id) {
        String SQL = "SELECT vi FROM V_PERSON_DATA where client_id=?";
        try {
            Connection conn = connect();
            PreparedStatement preparedStatement = conn.prepareStatement(SQL);
            System.out.println("sumVi person_id:"+person_id);
            //TODO: change to UUID tyope
            preparedStatement.setString(1,person_id.toString());
            ResultSet rs = preparedStatement.executeQuery();

            ArrayList<ArrayList<Long>> TwoDResultList = new ArrayList<ArrayList<Long>>();
            ArrayList<String> stringList = new ArrayList<String>();
            while (rs.next()) {
                stringList = new ArrayList<>(Arrays.asList((String[]) rs.getArray("vi").getArray()));
                System.out.println(Arrays.asList((String[]) rs.getArray("vi").getArray()));
                ArrayList<Long> resultIntList = new ArrayList<Long>();
                for (String stringValue : stringList) {
                    try {
                        //Convert String to long, and store it into long array list.
                        resultIntList.add(Long.parseLong(stringValue));
                    } catch (NumberFormatException nfe) {
                        System.out.println("Could not parse " + nfe);
//                        Log.w("NumberFormat", "Parsing failed! " + stringValue + " can not be an integer");
                    }
                }
                TwoDResultList.add(resultIntList);
            }
            ArrayList<Long> sum = new ArrayList<Long>(TwoDResultList.get(0).size());
            for (int i = 0; i < TwoDResultList.get(0).size(); i++) {
                sum.add(i, 0L);
            }
            for (ArrayList<Long> vi_array : TwoDResultList) {
                for (int i = 0; i < vi_array.size(); i++) {
                    sum.set(i, sum.get(i) + vi_array.get(i));
                }
            }

            HttpPost request = new HttpPost("http://localhost:8081/api/v1/server/addvsum");
            VSum vsum = new VSum(peer_id, person_id, sum);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
            StringEntity json = new StringEntity(mapper.writeValueAsString(vsum), ContentType.APPLICATION_JSON);
            request.setEntity(json);
            CloseableHttpResponse response = httpClient.execute(request);
            if(response.getStatusLine().getStatusCode() != 200){
                System.out.println("requested rcViTuples not added! "+response.getStatusLine().getStatusCode() );
            }
            response.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

}
