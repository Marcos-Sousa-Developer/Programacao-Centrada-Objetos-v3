
/**
 *Este interface define um tipo de dados sobre o qual o direcionador 
 *ir� trabalhar
 * @author PCO 59, Marcos Leit�o 55852, Rafael Ribeiro 56958, Gabriel Fonseca 57155
 * @date Dezembro 2021
 */

public interface Direcionador {
	
	/**
     *Define o universo sobre o qual o direcionador
     *vai trabalhar como sendo m
     *@param m - Array bidimensional que define o universo
     *@requires Cada array de m tem de ter o mesmo n�mero de elementos
     */
	
	 void defineUniverso(CorpoCeleste[][] m);
	 
	 /**
      *Devolve o elemento na posi��o n da matriz universo,
      *de acordo com a estrat�gia de direcionamento implementada pelo direcionador
      *@param n - Posi��o na matriz m
      *@requires n > 0
      */
	 
	 CorpoCeleste nEsimoElemento(int n);
}
