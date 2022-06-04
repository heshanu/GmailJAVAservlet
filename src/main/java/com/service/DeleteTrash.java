package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.dto.DeleteDTO;
import com.dto.TrashDTO;
import com.dto.sendboxDTO;
import com.util.JDBCUtil;

public class DeleteTrash {

	public static List<DeleteDTO> getAllBanks() throws SQLException {
		Connection connection = null;
		PreparedStatement preset = null;
		ResultSet rs = null;
		List<DeleteDTO> deleteList = new ArrayList<DeleteDTO>();
		String selectSQL = "select * from deletetable ";
		connection = JDBCUtil.getConnection();
		preset = connection.prepareStatement(selectSQL);
		rs = preset.executeQuery();

		while (rs.next()) {
			DeleteDTO send = new DeleteDTO();
			send.setDeleteId(rs.getInt("deleteId"));
			send.setTot(rs.getString("tot"));
			send.setSubject(rs.getString("subject"));
			send.setMessage(rs.getString("message"));
			deleteList.add(send);
		}
		return deleteList;
	}

}
