/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelBarang;
import util.Koneksi;

/**
 *
 * @author Rizki Pratama
 */
public class ControllerBarang {
    Koneksi koneksi = new Koneksi();
    
    public void simpanData(ModelBarang mb){
        koneksi.koneksidatabase();
        String query = "insert into tbl_barang(nama,jenis,jumlah) values ('"+mb.getNama()+"','"+mb.getJenis()+"','"+mb.getJumlah()+"')";
        try {
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil DI Simpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tidak Berhasil di simpan");
            System.err.println(""+e);
        }
    }
    public void hapusData(ModelBarang mb){
        try {
            koneksi.koneksidatabase();
            String query = "delete from tbl_barang where id=('"+mb.getId()+"')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Di hapus");
        } catch (Exception e) {
            System.err.println("Error : "+e);
            JOptionPane.showMessageDialog(null, "Tidak Terhapus");
        }
    }
    public void ubahData(ModelBarang mb){
        koneksi.koneksidatabase();
        try {
            int id = mb.getId();
            String nama = mb.getNama();
            String jenis = mb.getJenis();
            int jumlah = mb.getJumlah();
            
            String query = "update tbl_barang "
                    + "set nama=('" + nama + "'),"
                    + "jenis=('" + jenis + "'),"
                    + "jumlah=('" + jumlah + "')"
                    + "where id=('" + id + "')";
            koneksi.state.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil di Update");
        } catch (Exception e) {
            System.err.println("Error : "+ e);
            JOptionPane.showMessageDialog(null, "Tidak Tersimpan");
        }
    }
}
