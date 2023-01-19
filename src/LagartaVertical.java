
/**
 *Implementa o interface Direcionador
 * @author PCO 59, Marcos Leitão 55852, Rafael Ribeiro 56958, Gabriel Fonseca 57155
 * @date Dezembro 2021 
 */

public class LagartaVertical implements Direcionador {

	/**
     *Universo sobre o qual o direcionador vai trabalhar
     */
	
	private CorpoCeleste[][] m;
	
	/**
     *Define o universo sobre o qual o direcionador vai trabalhar como sendo m
     *@param m - Matriz deste universo
     *@requires Cada array de m tem de ter o mesmo número de elementos
     */
	
	public void defineUniverso(CorpoCeleste[][] m) {
		
		this.m=m;
		
	}	
	
	/**
     *Devolve o elemento na posição n da matriz universo, de acordo com a estratégia
     *de lagarta vertical
     *@param n - Indice a verificar na matriz universo
     *@return Elemento na posição n
     *@requires n > 0
     */
	
	public CorpoCeleste nEsimoElemento(int n) {
		
		int coluna = 0;
		int contador =1;
		
		do {
			
			while (coluna != this.m[0].length) {
					
				for(int l=0; l<this.m.length; l++) {
					
					if (contador == n) {
						return this.m[l][coluna];
					}
					contador ++;
				}
				if(coluna+1 == this.m[0].length) {
					break;
				}
				coluna ++;
					
				for(int l=this.m.length-1; l>=0; l--) {
					if (contador == n) {
						return this.m[l][coluna];
					}
					contador ++;
				}
				if(coluna+1 == this.m[0].length) {
					break;
				}
				coluna ++;
			}
			while (coluna != -1) {
					
				for(int l=this.m.length-1; l>=0; l--) {

					if (contador == n) {
						return this.m[l][coluna];
					}
					contador ++;
				}
				if(coluna-1 == -1) {
					break;
				}
				coluna --;

				for(int l=0; l<this.m.length; l++) {
					
					if (contador == n) {
						return this.m[l][coluna];
					}
					contador ++;
				}
				if(coluna-1 == -1) {
					break;
				}
				coluna --;
			}
		} while (contador != n);

		return null;
	}
}
