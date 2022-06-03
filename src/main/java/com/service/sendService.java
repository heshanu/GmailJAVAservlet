package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.sendboxDTO;
import com.util.JDBCUtil;

public class sendService {
	public static List<sendboxDTO> getAllBanks() throws SQLException {
		Connection connection = null;
		PreparedStatement preset = null;
		ResultSet rs = null;
		List<sendboxDTO> sendList = new ArrayList<sendboxDTO>();
		String selectSQL = "select * from sendtable ";
		connection = JDBCUtil.getConnection();
		preset = connection.prepareStatement(selectSQL);
		rs = preset.executeQuery();

		while (rs.next()) {
			sendboxDTO send = new sendboxDTO();
			send.setTot(rs.getString("tot"));
			send.setSubject(rs.getString("subject"));
			send.setMessage(rs.getString("message"));
			sendList.add(send);
		}
		return sendList;
	}

}
