package controle;

import java.util.Calendar;
import java.util.GregorianCalendar;
import users.Usuario;
import disciplina.Exercicio;
import java.util.Iterator;
import java.util.List;

public class Util {
    final static int DIA = 0;
    final static int MES = 1;
    final static int ANO = 2;
    public static Calendar criaCalendario(String cal) {
	String[] date = cal.split("/");

	return new GregorianCalendar(Integer.parseInt(date[ANO]), Integer.parseInt(date[MES])-1, Integer.parseInt(date[DIA]));
    }

    public static String ListToString(List l) {
        String string = "";
        Iterator it = l.iterator();
        while (it.hasNext()){
            string += it.next().toString();
        }
        return string;
    }

    public static int geraId(String tipo) {
        int maior = 0;
        if (tipo.equalsIgnoreCase("exercicio")) {
            for (Exercicio exercicio : BD.getExercicios()) {
                if (exercicio.getId() > maior) {
                    maior = exercicio.getId();
                }
            }
        }
        else if (tipo.equalsIgnoreCase("usuario")) {
            for (Usuario usuario : BD.getUsuarios()) {
                if (usuario.getId() > maior) {
                    maior = usuario.getId();
                }
            }
        }
        else if (tipo.equalsIgnoreCase("submissao")) {
            for (Submissao submissao : BD.getSubmissoes()) {
                if (submissao.getId() > maior) {
                    maior = submissao.getId();
                }
            }
        }
        return maior +1;
    }

}
