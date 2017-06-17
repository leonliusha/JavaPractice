/**
 * Created by liu on 15-5-13.
 */

import java.sql.*;
public class Driver {
    private String url;
    private String userName;
    private String password;

    public Driver(){
        url = "jdbc:mysql://localhost:3306/test";
        userName = "root";
        password = "19830421";
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            connection =  DriverManager.getConnection(url, userName, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public void insertionOperation(Statement statement, String sql){
        try {
            statement.executeUpdate(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void queryOperation(Statement statement, String sql){
        try{
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                System.out.println(result.getString("LastName")+","+result.getString("firstName"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateOperation(Statement statement, String sql){
        try{
            statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void preparedStatement(PreparedStatement pStatement,int personId, String address){
        try {
            pStatement.setInt(1, personId);
            pStatement.setString(2, address);
            System.out.println(pStatement.toString());
            ResultSet result = pStatement.executeQuery();
            while(result.next()){
                System.out.println(result.getString("LastName")+","+result.getString("firstName"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String args[]){
        Driver driver = new Driver();
        try{
            Connection connection = driver.getConnection();
            Statement statement = connection.createStatement();
            //insertion
//            String insertionSql = "insert into Persons "
//                        + "(PersonID,LastName,FirstName,Address,City)"
//                        + "values(2,'Brown','David','Shanghai','Shanghai China')";
//            driver.insertionOperation(statement, insertionSql);
//            System.out.println("inserting completed");
            //query
            String querySql = "select * from Persons";
            driver.queryOperation(statement, querySql);

            //update
//            String updateSql = "update Persons "
//                            + "set Address = 'Pudong district Shanghai'"
//                            + "where LastName = 'Brown'";
//            driver.updateOperation(statement, updateSql);
//            driver.queryOperation(statement, "select * from Persons");

            //prepared statement
            String pSql = "select * from Persons where PersonID > ? and Address = ?";
            int personId = 0;
            String address = "Shanghai Pingpu";
            PreparedStatement pStatement = connection.prepareStatement(pSql);
            driver.preparedStatement(pStatement,personId,address);

            //stored procedures
            //A group of SQL Statement that perform a particular task, normally created by DBA, can have combination of input
            //, output and input/output parameters.
            //it is a kind of script written by SQL Language to perform some task.
//            CallableStatement cStatement = connection.prepareCall("{call get_count_for_person(?)}");
//            cStatement.registerOutParameter(1,Types.INTEGER);
//            cStatement.setInt(1,0);
//            cStatement.execute();



        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
