package com.osdaj.servlets;

import java.io.IOException;

import com.osdaj.db.UsuarioDB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/activar")
public class ActivarCuentaServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		
		UsuarioDB userdb = new UsuarioDB();
		
		userdb.activarCuenta(email);
		
		req.setAttribute("respuesta", "Cuenta activada de forma exitosa");
		req.getRequestDispatcher("home.jsp").forward(req, resp);;
		
	}
	
	
}
