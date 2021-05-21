import java.util.ArrayList;
import java.util.List;

import java.util.Random;

import classes.Bug;
import classes.Prioridade;

public class TestePrincipal {

	// METODO PRINCIPAL
	public static void main(String[] args) {

		// INSTANCIANDO UM OBJETO PARA GERAR NUMEROS RANDOMICOS
		Random gerator = new Random();

		// INSTANCIANDO UMA LISTA DE BUGS
		List<Bug> listaBugs = new ArrayList<Bug>();

		// FOR PARA PREENCHER A LISTA COM 10 DADOS ALEATORIOS
		for (int i = 1; i < 11; i++) {
			// ATRIBUICAO DA VARIAVEL STATUS ( CRITICO OU NORMAL) USANDO O METODO
			// "analisaPrioridade()"
			Prioridade status = analisaPrioridade(gerator.nextInt(2));

			// ATRIBUICAO DA VARIAVEL IDADE( SE O STATUS FOR CRITICO A IDADE DO BUG SO PODE
			// SER 1 CASO CONTRÁRIO PODE SER ATÉ 3
			int idade = (status == Prioridade.CRITICO ? 1 : gerator.nextInt(3) + 1);

			// ADICIONANDO OS VALORES A LISTA BUGS
			listaBugs.add(new Bug(i, "Bug " + i, idade, status));
		}
		// IMPRIMI A LISTA BUGS NO CONSOLE
		System.out.println("Lista de Bugs:");
		System.out.println(listaBugs);

		// IMPRIMI A LISTA DE IDS DOS BUGS CRITICOS DO DIA
		System.out.println("Lista de Ids dos Bugs para serem resolvidos hoje:");
		System.out.println(listaBugsDiarios(listaBugs));
	}

	// METODO QUE ANALISA A PRIORIDADE, RECEBE UM NUMERO INTEIRO E RETORNA A
	// PRIORIDADE (n=O =>"NORMAL"// n=1=>"CRITICO")
	public static Prioridade analisaPrioridade(int n) {
		return (n == 0 ? Prioridade.NORMAL : Prioridade.CRITICO);
	}

	// METODO QUE RECEBE UMA LISTA DE BUGS E RETORNA UMA LISTA DE BUGS CRITICOS PARA
	// SEREM RESOLVIDOS NO DIA.
	public static List<Integer> listaBugsDiarios(List<Bug> listaBugs) {

		// INSTANCIANDO AS LISTAS AUXILIARES
		List<Integer> listaIdBugsDiarios = new ArrayList<Integer>();
		List<Integer> bugsNormais = new ArrayList<Integer>();
		List<Integer> bugsCriticos = new ArrayList<Integer>();

		// FOR PARA PERCORRER A LISTA DE BUGS, PROCURANDO OS BUGS CRITICOS E TAMBEM OS
		// BUGS NORMAIS COM 3 DIAS(LIMITE PARA SER RESOLVIDO)
		for (Bug i : listaBugs) {
			if (i.getPrioridade().equals(Prioridade.CRITICO)) {
				bugsCriticos.add(i.getId());
			} else if (i.getPrioridade().equals(Prioridade.NORMAL) && i.getIdade() > 2) {
				bugsCriticos.add(i.getId());
			} else {
				bugsNormais.add(i.getId());
			}

		}
		// ADICIONA A LISTA DE BUGS A LISTA DE BUGS DIARIOS PARA SEREM RESOLVIDOS
		listaIdBugsDiarios.addAll(bugsCriticos);

		/*
		 * SO NÃO EXISTA BUGS CRITICOS( COM PRIORIDADE ) É ADICIONADO A LISTA DE BUGS
		 * NORMAIS PARA A LISTA BUGS DIARIOS ASSIM, MESMO QUE NÃO EXISTA BUGS CRITICOS
		 * VAI TER OUTROS BUGS PARA RESOLVER NO DIA
		 */
		if (listaIdBugsDiarios.size() == 0) {
			System.out.println("Não existem Bugs com prioridade para hoje! ");
			listaIdBugsDiarios.addAll(bugsNormais);
		}

		return listaIdBugsDiarios;
	}

}
