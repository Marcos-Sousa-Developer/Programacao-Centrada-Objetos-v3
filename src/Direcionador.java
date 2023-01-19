
/**
 *Este interface define um tipo de dados sobre o qual o direcionador 
 *irá trabalhar
 * @author PCO 59, Marcos Leitão 55852, Rafael Ribeiro 56958, Gabriel Fonseca 57155
 * @date Dezembro 2021
 */

public interface Direcionador {
	
	/**
     *Define o universo sobre o qual o direcionador
     *vai trabalhar como sendo m
     *@param m - Array bidimensional que define o universo
     *@requires Cada array de m tem de ter o mesmo número de elementos
     */
	
	 void defineUniverso(CorpoCeleste[][] m);
	 
	 /**
      *Devolve o elemento na posição n da matriz universo,
      *de acordo com a estratégia de direcionamento implementada pelo direcionador
      *@param n - Posição na matriz m
      *@requires n > 0
      */
	 
	 CorpoCeleste nEsimoElemento(int n);
}
