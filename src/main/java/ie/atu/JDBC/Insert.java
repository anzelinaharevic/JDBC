package ie.atu.JDBC;

import java.sql.*;

public class Insert {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/anzdatabase", "root", "password");

        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO person (name, age, email) values(?,?,?)");
            stmt.setString(1, "Eoin");
            stmt.setInt(2, 21);
            stmt.setString(3, "G00431577@atu.ie");
            stmt.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println("insert failed");
            ex.printStackTrace();
        }
        con.close();
    }


    private static int getLastInsertId(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
        rs.next();
        int id = rs.getInt(1);
        rs.close();
        stmt.close();
        return id;
    }
}