package controle;

import java.util.List;

//testado por arnett
//testado por jessica
//testado por jessica win
//jao diz: agora vaaaai!
//jes diz: vai mermo? :B
//jao diz: foi!!! era pra fzr um chat no projeto (A)
public interface SistemaI {
	
	public boolean login() throws Exception;
	public boolean logoff() throws Exception;
	public void editaDadosUsuario(List<String> dados);
	
	

}
