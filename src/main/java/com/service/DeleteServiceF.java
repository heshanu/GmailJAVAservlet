package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.DeleteDTO;
import com.util.JDBCUtil;

public class DeleteServiceF {

	public static void deleteF(int Id) {
		Connection connection = null;
		PreparedStatement preset = null;
		connection = JDBCUtil.getConnection();
		String deleteSql = "delete from deletetable where deleteId=? ";
		try {
			preset = connection.prepareStatement(deleteSql);
			preset.setInt(1, Id);
			preset.executeUpdate();
			// System.out.println(returnV);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
