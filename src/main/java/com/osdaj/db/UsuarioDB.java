package com.osdaj.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.osdaj.connection.SqlServerConnection;
import com.osdaj.model.UsuarioModel;

public class UsuarioDB {

	private SqlServerConnection sqlserver = new SqlServerConnection();

	public String crearUsuario(UsuarioModel usuario) {
		String mensaje = "";

		try {
			Connection connection = sqlserver.getConnection();

			String insert = "insert into usuarios (nombre, apellido1, apellido2, email, telefono, pais, password, activo) \n"
					+ "values (?,?,?,?,?,?,?,?);";

			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getApellido1());
			statement.setString(3, usuario.getApellido2());
			statement.setString(4, usuario.getEmail());
			statement.setString(5, usuario.getTelefono());
			statement.setString(6, usuario.getPais());
			statement.setString(7, usuario.getPassword());
			statement.setBoolean(8, false);

			statement.executeUpdate();

			mensaje += "Usuario creado de forma exitosa, Activar desde tu email";

		} catch (SQLException e) {
			mensaje += e.getMessage();
			e.printStackTrace();
		}

		return mensaje;
	}
	
	public void activarCuenta(String email) {
		try {
			Connection connection = sqlserver.getConnection();
			String update = "Update usuarios set activo = 1 where email = '"+ email + "'";
			
			Statement stmt = connection.createStatement(); //Como es una actualizacion no piden mas de un valor por ende ocupamos el createStatement
			
			stmt.executeUpdate(update);
			
			System.out.println("Se activa de forma exitosa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
