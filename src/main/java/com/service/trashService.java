package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.TrashDTO;
import com.dto.sendboxDTO;
import com.util.JDBCUtil;

public class trashService {
	public static List<TrashDTO> getAllBanks() throws SQLException {
		Connection connection = null;
		PreparedStatement preset = null;
		ResultSet rs = null;
		List<TrashDTO> trashList = new ArrayList<TrashDTO>();
		String selectSQL = "select * from trash";
		connection = JDBCUtil.getConnection();
		preset = connection.prepareStatement(selectSQL);
		rs = preset.executeQuery();

		while (rs.next()) {
			TrashDTO trash = new TrashDTO();
			trash.setTot(rs.getString("tot"));
			trash.setSubject(rs.getString("subject"));
			trash.setMessage(rs.getString("message"));
			trashList.add(trash);
		}
		return trashList;
	}
}
