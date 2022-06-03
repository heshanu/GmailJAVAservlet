package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.JOptionPane;

import com.dto.UserDTO;
import com.dto.sendboxDTO;
import com.service.sendService;

@WebServlet("/sendbox")
public class sendboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public sendboxServlet() {
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
		// TODO Auto-generated method stub
		// doGet(request, response);
		String tot = request.getParameter("tot");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		RequestDispatcher dispatcher = null;
		ResultSet rs = null;
		HttpSession session = request.getSession();
		JFrame parent = new JFrame();
		List<sendboxDTO> s = new ArrayList<>();
		try {
			// sendService.getAllBanks();
			List<sendboxDTO> sends = sendService.getAllBanks();
			// System.out.println(banks.size());
		
			for (sendboxDTO sendDTO : sends) {
				sendDTO.getTot();
				sendDTO.getSubject();
				sendDTO.getMessage();

				// System.out.println(sendDTO.getTot());
				// System.out.println(" ");
				// System.out.println(sendDTO.getSubject());
				// System.out.println(" ");
				// System.out.println(sendDTO.getMessage());
				// session.setAttribute("sendDTO", sendDTO);
				s.add(sendDTO);
				session.setAttribute("s",s.add(sendDTO));
				System.out.println(session.getAttribute(tot));
				session.setAttribute("subject", sendDTO.getSubject());
				session.setAttribute("message", sendDTO.getMessage());
			}
			dispatcher = request.getRequestDispatcher("send.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		dispatcher.forward(request, response);
	}
}
