package com.controller;

import java.io.IOException;
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

import com.dto.sendboxDTO;
import com.service.sendService;

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
		// TODO Auto-generated method stub
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

				// session.setAttribute("tot", sendDTO.getTot());
				System.out.println(sendDTO.getTot());
				s.add(sendDTO);
				session.setAttribute("s2", s);
			}
			dispatcher = request.getRequestDispatcher("delete.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		dispatcher.forward(request, response);
	}
}
