package controle;

import org.apache.commons.mail.SimpleEmail;

public class SendMail {

	static void enviaEmail(String nomeUser, String emailUser, String senhaUser)
			throws Exception {
		SimpleEmail email = new SimpleEmail();

		email.setDebug(true);
		email.setHostName("smtp.gmail.com");
		email.setAuthentication("suporte.lp2", "apoio-lp2");
		email.setSSL(true);
		email.addTo(emailUser); // pode ser qualquer um email
		email.setFrom("suporte.lp2@gmail.com"); // aqui necessita ser o email
												// que voce fara a autenticacao
		email.setSubject("Recuperacao de Senha");
		email
				.setMsg("Ola, " + nomeUser + ", \n\n   Sua senha eh: "
						+ senhaUser+". \n\nAtenciosamente,\n\nEquipe de Suporte");
		email.send();

	}

}