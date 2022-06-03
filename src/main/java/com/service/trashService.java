package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.sendboxDTO;
import com.util.JDBCUtil;

public class trashService {
	public static List<sendboxDTO> getAllBanks() throws SQLException {
		Connection connection = null;
		PreparedStatement preset = null;
		ResultSet rs = null;
		List<sendboxDTO> trashList = new ArrayList<sendboxDTO>();
		String selectSQL = "select * from trashtable ";
		connection = JDBCUtil.getConnection();
		preset = connection.prepareStatement(selectSQL);
		rs = preset.executeQuery();

		while (rs.next()) {
			sendboxDTO send = new sendboxDTO();
			send.setTot(rs.getString("tot"));
			send.setSubject(rs.getString("subject"));
			send.setMessage(rs.getString("message"));
			trashList.add(send);
		}
		return trashList;
	}

}
