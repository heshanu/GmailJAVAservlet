package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;

/**
 * Servlet implementation class deleteforever
 */
@WebServlet("/df")
public class deleteforever extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deleteforever() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// int deleteId
		RequestDispatcher dispatcher = null;
		Connection connection = null;
		ResultSet rs = null;
		HttpSession session = request.getSession();
		JFrame frame = new JFrame();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration_form?useSSL=false",
					"root", "");
			PreparedStatement pst = connection.prepareStatement("delete from deletetable where deleteId=?");
			// pst.setInteger(1, deleteId);

			rs = pst.executeQuery();
			if (rs.next()) {
				// request.setAttribute("sta", connection)
				session.setAttribute("name", rs.getString("uname"));
				// int result = JOptionPane.showConfirmDialog(frame, "Record has been saved!");
				// JOptionPane.showInternalConfirmDialog(desktop, "Continue printing?");

				// System.out.println(JOptionPane.CANCEL_OPTION == result);
				dispatcher = request.getRequestDispatcher("index.jsp");
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
