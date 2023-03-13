package com.happy.kaoshi.service.impl;

import com.happy.kaoshi.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl {
  Connection conn = null;
  ResultSet rs = null;
  PreparedStatement ps = null;
  public void user() {
    try {
      conn = DBUtil.getConnection();
      System.out.println(conn);

//      ps = conn.prepareStatement("select * from tb_user");
//      rs = ps.executeQuery();
//
//      while (rs.next()) {
//        System.out.println(rs.getInt(1) + " " + rs.getString(2));
//      }
//
//      DBUtil.close(conn, ps, rs);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
