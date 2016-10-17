package com.aurionpro.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterUser {

    private String username;
    private String password;
    private String address;
    private String phone;
    static int status = 0;

    public int register(String username, String password, String address, String phone) {
        //public static int register(String email,String password,String gender,String country,String name){
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;

        Connection con = GetCon.getCon();
        PreparedStatement ps;
        try {

            ps = con.prepareStatement("Insert into user (username, password, address, phone) values(?,?,?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, address);
            ps.setString(4, phone);

            status = ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return status;

    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("username: " + this.username+"<br>")
                .append("password: " + this.password+"<br>")
                .append("address: " + this.address+"<br>")
                .append("phone: " + this.phone)
                .toString();
    }
}
