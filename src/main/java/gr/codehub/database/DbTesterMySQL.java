package gr.codehub.database;

import java.sql.*;

public class DbTesterMySQL {

    public static void runTest1() {
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:mysql://localhost:3306";
        String username = "root";
        String password = "root";
        String database = "sakila";
        try {
            System.out.println("Connecting...");
            Connection con = DriverManager.getConnection(connectionUrl + "/" + database, username, password);
            System.out.println("Connected");
            Statement stmt = con.createStatement();
            String SQL = "select * from actor";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        runTest1();
    }
}













//    PreparedStatement ps = con.prepareStatement("select * from film where title like ?");
//    ps.setString(1, "%MER%");
//    ResultSet rs = ps.executeQuery();
//    ps.close();