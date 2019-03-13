package arvore_binaria;

import java.util.ArrayList;
import java.util.List;

public class Delete {
	
	//Cria a lista para os itens que estao abaixo do item a ser removido
	static List<String> lista = new ArrayList<>();
	
	static void DeleteNum (Nodo raiz, Nodo atual, int num) {
		
		//Verifico se o valor do nodo atual é o que deve ser excluido
		//Caso sim entra na primeira condicao se nao chama o DeleteNum dos itens abaixo
		if (num == atual.getValor()) {
			//Populo a lista com os itens que estao abaixo do item que quero remover
			//Removo o item 0 que é o item a ser excluido
			MapeiaAbaixo(atual, lista);
			//System.out.println(lista); //descomentar para ver a lista
			lista.remove(0);
			System.out.println(lista);
			
			//Removo os nodos abaixo do qual quero remover
			LimpaAbaixo(atual);
			//Removo a referencia do nodo que eu quero remover
			LimpaRefPai(raiz, atual.getValor());
			
			//Insiro novamente os valores da lista
			if (raiz != null) {
				for (int i = 0; i<lista.size(); i++)
					raiz.insere(Integer.parseInt(lista.get(i)));
			}
			
		} else if (num < atual.getValor()) {
			DeleteNum(raiz, atual.getEsquerda(), num);
		} else if (num > atual.getValor()) {
			DeleteNum(raiz, atual.getDireita(), num);
		}
		
	}
	
	//Metodo para achar o nodo a cima do qual quero remover, e removo a referencia que faz ao nodo o qual quero remover
	private static void LimpaRefPai(Nodo raiz, int filho) {
		if (raiz.getValor() == filho) {
			raiz = null;
		}
			
		if (raiz.getDireita() != null)
			if (raiz.getDireita().getValor() == filho)
				raiz.setDireita(null);
			else
				LimpaRefPai(raiz.getDireita(), filho);
		
		if (raiz.getEsquerda() != null)
			if (raiz.getEsquerda().getValor() == filho)
				raiz.setEsquerda(null);
			else
				LimpaRefPai(raiz.getEsquerda(), filho);
	}
	
	//Metodo que remove todos os nodos abaixo do nodo que quero remover
	private static void LimpaAbaixo(Nodo atual) {
		if (atual.getEsquerda() != null) {
			LimpaAbaixo(atual.getEsquerda());
		}
		if (atual.getDireita() != null) {
			LimpaAbaixo(atual.getDireita());
		}
		atual = null;
	}

	//Metodo que mapeia todos os nodos abaixo do qual quero remover
	public static void MapeiaAbaixo (Nodo atual, List<String> lista) {
		lista.add(Integer.toString(atual.getValor()));
		if (atual.getEsquerda() != null) {
			MapeiaAbaixo(atual.getEsquerda(), lista);
		}
		if (atual.getDireita() != null) {
			MapeiaAbaixo(atual.getDireita(), lista);
		}
	}
	
	//Metodo que recebe e devolve uma lista com o mapeamento dos nodos da arvore
	static List<String> MapeiaAbaixoRaiz(Nodo atual, List<String> lista) {
		lista.add(Integer.toString(atual.getValor()));
		if (atual.getEsquerda() != null) {
			MapeiaAbaixo(atual.getEsquerda(), lista);
		}
		if (atual.getDireita() != null) {
			MapeiaAbaixo(atual.getDireita(), lista);
		}
		return lista;
	}

}
