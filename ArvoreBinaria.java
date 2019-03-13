package arvore_binaria;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria {
	
	private Nodo raiz;
	
	static List<String> lista = new ArrayList<>();
	
	public boolean insere(int value) {
		if(raiz == null) {
			System.out.println(value+" eh a raiz da arvore.");
			raiz = new Nodo(value);
			return true;
		} else
			return raiz.insere(value);
	}
		
	//Chama a classe delete passando raiz, raiz e numero a ser deletado
	void deletar(int num) {
		Delete.DeleteNum(raiz, raiz, num);
	}
	
	//Returna true se é a raiz
	boolean deletarEhRaiz(int num) {
		if (raiz.getValor() == num) 
			return true;
		else
			return false;
	}
	
	//Retorna a lista de numeros na arvore
	List<String> MapeiaAbaixo() {
		//chama outro metodo da classe delete para mapear a arvore mas passando e retornando uma lista
		lista = Delete.MapeiaAbaixoRaiz(raiz, lista);
		return lista;
	}
	
	void percorre(IPercorre metodo) {
		metodo.percorre(raiz);
	}
	
	//Metodo que seta a nova raiz e deleta o restante da arvore
	void setNewRaiz(int num) {
		raiz.setValor(num);
		raiz.setEsquerda(null);
		raiz.setDireita(null);
	}

}
