package com.osdaj.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

	private static final String SERVLET = "http://localhost:9080/ConsultorPlataformasDigitales-01/activar";

	public void sendMail(String nombreCompleto, String email) {
		String from = "david.osornio1121@gmail.com";
		final String userName = "david.osornio1121@gmail.com";
		final String password = "fchd & djos & $";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		/*
		 * Login a nuestra cuenta
		 */

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});

		/*
		 * Crear el mensaje a mandar por nuestra cuenta
		 */

		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from)); // Desde donde sale el mansaje

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email)); // Para quinees es enviado
																							// elcorreo

			message.setSubject("Activacion de cuenta");

			message.setContent("Bienvenido " + nombreCompleto
					+ ", a OSDAJ, para activar tu cuenta por favor confirma tu email haciendo click en el siguiente enlace "
					+ "<a href=\"" + SERVLET + "?email=" + email + "\">Activar mi cuenta</a>", "text/html");

			Transport.send(message);

			System.out.println("Email enviando de forma exitosa a " + email);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
