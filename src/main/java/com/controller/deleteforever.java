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
import com.dto.sendboxDTO;
import com.service.DeleteService;
import com.service.DeleteServiceF;
import com.service.sendService;
import com.util.JDBCUtil;

/**
 * Servlet implementation class deleteforever
 */
@WebServlet("/df")
public class deleteforever extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public deleteforever() {
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
		try {
			int id = (Integer) session.getAttribute("id");
			System.out.println(id);
			DeleteServiceF.deleteF(id);
			// session.setAttribute("s7", s7);

			dispatcher = request.getRequestDispatcher("delete.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		dispatcher.forward(request, response);
	}

}
