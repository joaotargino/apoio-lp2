package util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import users.Usuario;
import disciplina.Exercicio;
import java.util.Iterator;
import java.util.List;

import controle.BD;
import controle.Submissao;

public class Util {

    public static final String ABOUT = "UFCG - Ciência da Computação - Laboratório de Programação 2" + dados.IO.NOVA_LINHA + "Ferramenta de apoio à disciplina LP2" + dados.IO.NOVA_LINHA + "Desenvolvido por:" + dados.IO.NOVA_LINHA + "Arnett de Oliveira Rufino (arnettor@lcc.ufcg.edu.br)" + dados.IO.NOVA_LINHA + "Erickson Filipe dos Santos (ericksonfgds@lcc.ufcg.edu.br)" + dados.IO.NOVA_LINHA + "Jéssica Priscila de Sousa Santos(jessicapss@lcc.ufcg.edu.br)" + dados.IO.NOVA_LINHA + "João Paulo S. Targino(joaopdst@lcc.ufcg.edu.br)";
    public static final String HELP = "Problemas comuns:" + dados.IO.NOVA_LINHA + "Erro nos dados dos usuários: tamanho do login > 4 , 4 < tamanho da senha < 18 , verificar se a matrícula já existe, " + dados.IO.NOVA_LINHA + "verificar se o e-mail já existe." + dados.IO.NOVA_LINHA + "" + dados.IO.NOVA_LINHA + "Mais problemas em breve!";
    final static int DIA = 0;
    final static int MES = 1;
    final static int ANO = 2;

    public static Calendar criaCalendario(String cal) {
        String[] date = cal.split("/");

        return new GregorianCalendar(Integer.parseInt(date[ANO]), Integer.parseInt(date[MES]) - 1, Integer.parseInt(date[DIA]));
    }

    public static String ListToString(List l) {
        String string = "";
        Iterator it = l.iterator();
        while (it.hasNext()) {
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
        } else if (tipo.equalsIgnoreCase("usuario")) {
            for (Usuario usuario : BD.getUsuarios()) {
                if (usuario.getId() > maior) {
                    maior = usuario.getId();
                }
            }
        } else if (tipo.equalsIgnoreCase("submissao")) {
            for (Submissao submissao : BD.getSubmissoes()) {
                if (submissao.getId() > maior) {
                    maior = submissao.getId();
                }
            }
        }
        return maior + 1;
    }
}
