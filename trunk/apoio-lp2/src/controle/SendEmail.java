package controle;
import javax.annotation.Resources;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {
	
	public static void main(String[] args) {

		SimpleEmail email = new SimpleEmail();

		try {
		email.setDebug(true);
		email.setHostName("smtp.gmail.com");
		email.setAuthentication("suporte.lp2","apoio-lp2");
		email.setSSL(true);
		email.addTo("arnettor@lcc.ufcg.edu.com.br"); //pode ser qualquer um email
		//email.addTo("jekkitta@hotmail.com"); //pode ser qualquer um email
		//email.addTo("joaotargino@gmail.com");
		email.setFrom("suporte.lp2@gmail.com"); //aqui necessita ser o email que voce fara a autenticacao
		email.setSubject("Teste");
		email.setMsg("Mensagem Testando");
		email.send();

		} catch (EmailException e) {

		//System.out.println(e.getMessage());

		} 

	}

}