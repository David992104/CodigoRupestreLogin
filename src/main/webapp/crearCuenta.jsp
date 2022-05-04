<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear cuenta</title>
</head>
<body>
	<h2>Crear cuenta</h2>

	<form action="registrarUsuario" method="post">
		<table>
			<tr>
				<td><label>Nombre</label></td>
				<td><input type="text" name="nombre"></td>
			</tr>
			<tr>
				<td><label>Primer apellido</label></td>
				<td><input type="text" name="apellido1"></td>
			</tr>
			<tr>
				<td><label>Segundo apellido</label></td>
				<td><input type="text" name="apellido2"></td>
			</tr>
			<tr>
				<td><label>Email</label></td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td><label>Telefono</label></td>
				<td><input type="text" name="telefono"></td>
			</tr>
			<tr>
				<td><label>Pais</label></td>
				<td><input type="text" name="pais"></td>
			</tr>
			<tr>
				<td><label>Contraseña</label></td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><label>Confirma contraseña</label></td>
				<td><input type="password" name="passConfirm"></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">Registrar</button></td>
			</tr>
			
		</table>
	</form>
</body>
</html>