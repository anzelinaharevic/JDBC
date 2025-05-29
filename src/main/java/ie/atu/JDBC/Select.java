package ie.atu.JDBC;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Select {
    public static void main(String[] args) throws SQLException {

        String selectsql = "SELECT s.name, s.age, s.email FROM person s";

        try(Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/anzdatabase", "root", "password")){

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectsql);

            while(rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                System.out.println(name + " " + age + " "+ email +  " "  );
            }

        }
        catch(SQLException e){
            System.out.println(e);
        }

    }
}