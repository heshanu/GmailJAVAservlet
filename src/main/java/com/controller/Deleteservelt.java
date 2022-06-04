package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;

import com.dto.DeleteDTO;
import com.dto.TrashDTO;
import com.dto.TrashDTODeleteDTO;
import com.dto.sendboxDTO;
import com.service.DeleteService;
import com.service.sendService;
import com.service.trashService;
import com.util.JDBCUtil;

@WebServlet("/Delete")
public class Deleteservelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Deleteservelt() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		Connection connection = null;
		ResultSet rs = null;
		HttpSession session = request.getSession();
		JFrame frame = new JFrame();
		PreparedStatement preset = null;
		connection = JDBCUtil.getConnection();
		List<DeleteDTO> s6 = new ArrayList<DeleteDTO>();
		try {
			PreparedStatement pst = connection.prepareStatement("select * from deletetable");
//			pst.setInt(1, trashId);
			// pst.setInt(1,trashId);
			rs = pst.executeQuery();
			if (rs.next()) {
				// request.setAttribute("sta", connection)

				List<DeleteDTO> d = DeleteService.getAllBanks();
				// System.out.println(banks.size());

				for (DeleteDTO DDTO : d) {
					DDTO.getTot();
					DDTO.getSubject();
					DDTO.getMessage();

					// session.setAttribute("tot", sendDTO.getTot());
					//System.out.println(DDTO.getTot());
					s6.add(DDTO);
					session.setAttribute("s6", s6);
					session.setAttribute("id", DDTO.getDeleteId());
				}

				dispatcher = request.getRequestDispatcher("delete.jsp");

			} else {
				request.setAttribute("status", "failed");
				// int result = JOptionPane.showConfirmDialog(frame, "Unable to save");
				// JOptionPane.showInternalConfirmDialog(desktop, "Continue printing?");

				// System.out.println(JOptionPane.CANCEL_OPTION == result);
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
