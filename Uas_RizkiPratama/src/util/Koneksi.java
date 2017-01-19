/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rizki Pratama
 */
public class Koneksi {
    public Connection connect;
    public Statement state;
    public ResultSet res;
    String namaDatabase = "jdbc:mysql://localhost/db_uas_15311628";
    
    public void koneksidatabase() {
        try {
            connect = DriverManager.getConnection(namaDatabase, "root", "@mantap@");
            System.out.println("Koneksi Tidak Bermasalah");
            state = connect.createStatement();
        } catch (Exception ex) {
            System.err.println("Cek Url, username host dan password host");
            System.err.println("SQLException:"+ex.getMessage());
        }
    }
}
