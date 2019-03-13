package arvore_binaria;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static List<String> lista = new ArrayList<>();

	public static void main(String[] args) {
		
		ArvoreBinaria ab = new ArvoreBinaria();
		
		ab.insere(5);
		ab.insere(3);
		ab.insere(4);
		ab.insere(7);
		ab.insere(6);
		ab.insere(17);
		ab.insere(12);
		
		//ab.ler();
		
		//Leitura
		System.out.println("_____Em Ordem____________");
		ab.percorre(new EmOrdem());
		System.out.println("_____Profundidade________");
		ab.percorre(new Profundidade());
		System.out.println("_____Em Nivel____________");
		ab.percorre(new EmNivel());
		System.out.println(" ");
		
		//Remocao
		System.out.println("_____Excluindo___________");
		//Numero a ser excluido
		int excluir = 12;
		System.out.println("Excluindo.."+excluir);
		//Metodo para verificar se o numero a ser excluido é a raiz
		if (ab.deletarEhRaiz(excluir)) {
			//Cria uma lista com o que tem na árvore e removo a raiz
			lista = ab.MapeiaAbaixo();
			lista.remove(0);
			System.out.println(lista);
			//Metodo para setar a nova raiz e limpar a árvore
			ab.setNewRaiz(Integer.parseInt(lista.get(0)));
			//Removo o item que se tornou a raiz
			lista.remove(0);
			//Insiro os itens restantes da lista
			for (int i = 0; i<lista.size(); i++)
				ab.insere(Integer.parseInt(lista.get(i)));
		} else {
			//Chama o meotod deletar para quando nao é a raiz
			ab.deletar(excluir);
		}
		System.out.println(" ");
		System.out.println("_____Em Nivel____________");
		ab.percorre(new EmNivel());
	}

}
