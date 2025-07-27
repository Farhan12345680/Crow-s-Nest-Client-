//package com.example.crows__nest__client_trial.dbms;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class dbms1_call {
//    private static final String Client_DataBase_URL = "jdbc:sqlite:app_data.db";
//
//
//    public void send_to_the_server(){
//
//    }
//    public static void initialize_database(){
//        try(Connection data_base_connection= DriverManager.getConnection(Client_DataBase_URL) ){
//            if(data_base_connection!= null){
//                String db_statement= """
//                        CREATE TABLE IF NOT EXISTS Friends(
//                            Name_id TEXT PRIMARY KEY,
//                            friend BLOB NOT NULL
//                        );
//                        """;
//
//                    try(Statement statement=data_base_connection.createStatement()){
//                        statement.execute(db_statement);
//                        System.out.println("table created");
//                    }
//            }
//        }catch (SQLException e){
//            System.out.println("Error occured" +e.getMessage());
//        }
//    }
//
//}

package com.example.crows__nest__client_trial.dbms;
import java.sql.*;
import java.util.concurrent.ThreadLocalRandom;

public class dbms1_call{
    public static final String dbms_connection_string="jdbc:sqlite:client_database.db";
    public static String RandomStringGenerator(int length) {
        StringBuilder temp = new StringBuilder();
        ThreadLocalRandom random_generator = ThreadLocalRandom.current();
        for (int i = 0; i < length; i++) {
            temp.append((char) ('A' + random_generator.nextInt(26))); // 0 to 25 inclusive
        }
        return temp.toString();
    }
    public static void send_to_the_server(){

    }
    public static void initialize_database()
    {
        try(Connection connection_to_database = DriverManager.getConnection(dbms_connection_string)){
            if(connection_to_database!=null){
                System.out.println("database establishment successfull");
                String create_table_statement= """
                        CREATE TABLE IF NOT EXISTS Profiles(name_id TEXT NOT NULL PRIMARY KEY,
                                                            is_friend BLOB not NULL
                        );
                        """;

                try(PreparedStatement ps=connection_to_database.prepareStatement(create_table_statement)){
                    ps.execute();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                String update_statement="INSERT INTO Profiles(name_id , is_friend) VALUES(? , ?)";

                try(PreparedStatement insert_ps=connection_to_database.prepareStatement(update_statement)){
                    for(int i=1;i<=1000; i++ ){
                        String temp=RandomStringGenerator(10);
                        insert_ps.setString(1 , temp);
                        insert_ps.setInt(2 ,1);
                        insert_ps.addBatch();
                    }
                    insert_ps.executeBatch();

                }catch (SQLException excption){

                }finally{

                }


            }
        }catch (SQLException e){
            System.out.println("Exception Occured"+e.getMessage());
        }
    }

    public static void getData(){
        try(Connection conn= DriverManager.getConnection(dbms_connection_string)){
            if(conn!=null){
                String select_string= "SELECT * from Profiles";

                try(PreparedStatement ps=conn.prepareStatement(select_string)){
                    try(ResultSet rs= ps.executeQuery()){
                        while(rs.next()){
                            String data=rs.getString(1);
                            int is_friend=rs.getInt(2);

                            System.out.println(data+" "+((is_friend==1)?"friend":"not friend"));
                        }
                    }catch (SQLException e){

                    }

                } catch (SQLException e) {

                }
            }

        }catch (SQLException e){

        }
    }


}