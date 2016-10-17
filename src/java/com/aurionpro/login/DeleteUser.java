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
public class DeleteUser {

    static int status = 0;

    public static int delete(int id) {
        Connection con = GetCon.getCon();
        PreparedStatement ps;
        try {

            ps = con.prepareStatement("DELETE FROM  user where  id = ?");
            ps.setInt(1, id);

            status = ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return status;
    }
}
