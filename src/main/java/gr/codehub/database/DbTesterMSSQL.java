package gr.codehub.database;

import java.io.FileNotFoundException;
import java.sql.*;

public class DbTesterMSSQL {

    public static void runTest1() throws SQLException {
        Connection conn = null;
        try {
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=AdventureWorks2017";
            String user = "sa";
            String password = "password";
            conn = DriverManager.getConnection(dbURL, user, password);
            if (conn != null) {
               // showConnectionData(conn);
                Statement stmt = conn.createStatement();
                String SQL = getSQLStatement();
                ResultSet rs = stmt.executeQuery(SQL);
                while (rs.next()) {
                    showResultData(rs);
                }
            } else {
                throw new FileNotFoundException();
            }
            throw new NullPointerException();
        } catch (FileNotFoundException  | NullPointerException ex)  {  // caught, unchaught
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void showResultData(ResultSet rs) throws SQLException {
        System.out.println(rs.getString("FirstName") + " "
                + rs.getString("LastName") +
                rs.getString("JobTitle"));
    }

    private static String getSQLStatement() {
        String SQL = "";
        return SQL;
    }

    private static void showConnectionData(Connection conn) throws MyBusinessException {
        try {
            DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
            System.out.println("Driver name: " + dm.getDriverName());
            System.out.println("Driver version: " + dm.getDriverVersion());
            System.out.println("Product name: " + dm.getDatabaseProductName());
            System.out.println("Product version: " + dm.getDatabaseProductVersion());
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        runTest1();
    }
}
