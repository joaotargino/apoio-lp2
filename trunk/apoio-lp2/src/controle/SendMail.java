package controle;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendMail {
	
	public static void main(String[] args) {

		SimpleEmail email = new SimpleEmail();

		try {
		email.setDebug(true);
		email.setHostName("smtp.gmail.com");
		email.setAuthentication("suporte.lp2","apoio-lp2");
		email.setSSL(true);
		email.addTo("jessicadesousacg@gmail.com"); //pode ser qualquer um email
		email.setFrom("suporte.lp2@gmail.com"); //aqui necessita ser o email que voce fara a autenticacao
		email.setSubject("Teste com barra n =P! =D");
		email.setMsg("Mensagem Testando\nblablabla");
		email.send();

		} catch (EmailException e) {

		System.out.println(e.getMessage());

		} 

	}

}}