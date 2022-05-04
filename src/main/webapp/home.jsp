<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - OSDAJ</title>
</head>
<body>
	<h2>Login OSDAJ</h2>

	<table>
	
		<tr>
			<td><label>Usuario</label></td>
			<td><input type="text"></td>
		</tr>
		<tr>
			<td><label>Contraseña</label></td>
			<td><input type="password"></td>
		</tr>
		<tr>
			<td><label></label></td>
			<td><button type="submit">Iniciar sesion</button></td>
		</tr>
	</table>
	<table>
	
	<tr>
	<td><label>${respuesta}</label></td>
	<td></td>
	</tr>
	
		<tr>
			<td><a href="crearCuenta.jsp">Crear cuenta nueva</a></td>
			<td><a href="recuperar.jsp">Recuperar contraseña</a></td>
		</tr>
		<tr>
			<td><a href="#">Iniciar con facebok</a></td>
			<td><a href="#">Iniciar con google</a></td>
			<td><a href="#">Iniciar con GitHub</a></td>
		</tr>
	
	</table>

</body>
</html>