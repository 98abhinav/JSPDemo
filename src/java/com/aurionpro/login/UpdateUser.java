/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aurionpro.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author abhinav.kumar
 */
public class UpdateUser {

    static int status = 0;

    public static int update(int id, String username, String address, String phone) {
        Connection con = GetCon.getCon();
        PreparedStatement ps;
        try {

            ps = con.prepareStatement("UPDATE user SET username = ? , address = ? , phone = ? WHERE id = ?");
            ps.setString(1, username);
            ps.setString(2, address);
            ps.setString(3, phone);
            ps.setInt(4, id);

            status = ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return status;
    }

}
