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
		HttpSession session2 = request.getSession();
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = null;
		ResultSet rs = null;
		
		JFrame parent = new JFrame();
		List<sendboxDTO> s = new ArrayList<>();
		try {
			// sendService.getAllBanks();
			List<sendboxDTO> sends = sendService.getAllBanks();
			// System.out.println(banks.size());

			
			dispatcher = request.getRequestDispatcher("delete.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		dispatcher.forward(request, response);
	}
}
