package com.progdispmov.trabalhopdm;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {

    public void ConexaoBD(){
        System.out.println("MySQL Connect Example.");
        Connection conn = null;
        String url = "jdbc:mysql://jcruz1.mysql.pythonanywhere-services.com/";
        String dbName = "trabalho";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "jcruz1";
        String password = "trabalhopdm";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url+dbName,userName,password);
            System.out.println("Connected to the database");
            conn.close();
            System.out.println("Disconnected from database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
