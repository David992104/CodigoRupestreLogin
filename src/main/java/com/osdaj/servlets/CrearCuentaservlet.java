package com.osdaj.servlets;

import java.io.IOException;

import com.osdaj.db.UsuarioDB;
import com.osdaj.mail.EmailService;
import com.osdaj.model.UsuarioModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registrarUsuario")
public class CrearCuentaservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String ape1 = req.getParameter("apellido1");
		String ape2 = req.getParameter("apellido2");
		String email = req.getParameter("email");
		String telefono = req.getParameter("telefono");
		String pais = req.getParameter("pais");
		String pass = req.getParameter("password");
		String passConfirm = req.getParameter("passConfirm");
		
		if (pass.equals(passConfirm)) {
			UsuarioModel usuario = new UsuarioModel();
			usuario.setNombre(nombre);
			usuario.setApellido1(ape1);
			usuario.setApellido2(ape2);
			usuario.setEmail(email);
			usuario.setTelefono(telefono);
			usuario.setPais(pais);
			usuario.setPassword(pass);
			
			UsuarioDB usuarioDb = new UsuarioDB(); //Se crea un objeto de usuariodb donde se llenara la base de datos
			String respuesta = usuarioDb.crearUsuario(usuario); //Se envian los datos a la clase y esta los sube a la db mandando un mensaje de respuesta
			
			EmailService emailService =  new EmailService(); //Hace llamado a nuestra clase en com.osdaj.mail
			emailService.sendMail(usuario.getNombreCompleto(), usuario.getEmail());

			req.setAttribute("respuesta", respuesta);

			System.out.println("Usuario creado de forma exitosa");

			req.getRequestDispatcher("home.jsp").forward(req, resp);
			
		}else
			System.out.println("No se creo el usuario");


	}

}
