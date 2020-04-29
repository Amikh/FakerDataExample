package com.am.db;

import filse.PropertyValues;

import java.sql.*;

public class MySQLAccess {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    public  void readDataBase(String dataBaseName, String fullQuery) throws Exception {

        try {

            PropertyValues pv = new PropertyValues();
            pv.getPropValues();


            String url = "jdbc:mysql://amikh053c.mylabserver.com/"+dataBaseName;
            String user = PropertyValues.user;
            String password = PropertyValues.pass;

            // Load the Connector/J driver
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            // Establish connection to MySQL
            Connection conn = DriverManager.getConnection(url, user, password);

            // create the java statement
            Statement st = conn.createStatement();
            st.executeUpdate(fullQuery);

//            resultSet = st.executeQuery("SELECT * FROM person_data");
//            writeResultSet(resultSet);

            conn.close();
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }

    }

    private void writeResultSet(ResultSet rs) throws SQLException {
        while (resultSet.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String dateCreated = rs.getString("email");
            String isAdmin = rs.getString("country");
            String numPoints = rs.getString("city");
            int soc_num = rs.getInt("soc_num");
            System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints,soc_num);
        }
    }


    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }


}
