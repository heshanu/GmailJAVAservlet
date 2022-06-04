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

import com.dto.TrashDTO;
import com.dto.sendboxDTO;
import com.service.sendService;
import com.service.trashService;

@WebServlet("/trash")
public class TrashServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TrashServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// doGet(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tot1 = request.getParameter("tot");
		String subject1 = request.getParameter("subject");
		String message1 = request.getParameter("message");
		RequestDispatcher dispatcher1 = null;
		HttpSession session1 = request.getSession();
		JFrame parent = new JFrame();
		List<TrashDTO> s1 = new ArrayList<>();
		try {
			// sendService.getAllBanks();
			List<TrashDTO> trash = trashService.getAllBanks();
			// System.out.println(banks.size());

			for (TrashDTO trashdto : trash) {
				trashdto.getTot();
				trashdto.getSubject();
				trashdto.getMessage();
				// session.setAttribute("tot", sendDTO.getTot());
				// System.out.println(trashdto.getTot());
				s1.add(trashdto);
				session1.setAttribute("s1", s1);	
				System.out.println(trashdto.getMessage());
			}
			dispatcher1 = request.getRequestDispatcher("trash.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		dispatcher1.forward(request, response);
	}
}