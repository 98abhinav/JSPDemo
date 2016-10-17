/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aurionpro.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author abhinav.kumar
 */
public class FetchUser {

    public static ArrayList<User> users() throws ClassNotFoundException, SQLException {
        Connection con = GetCon.getCon();
        ArrayList<User> users = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("Select id,username,address,phone from user");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));

                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
