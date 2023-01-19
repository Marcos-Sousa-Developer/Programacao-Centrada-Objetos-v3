
/**
 *Implementa o interface Direcionador
 * @author PCO 59, Marcos Leitão 55852, Rafael Ribeiro 56958, Gabriel Fonseca 57155
 * @date Dezembro 2021 
 */

public class LagartaHorizontal implements Direcionador {
	
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
     *de lagarta horizontal
     *@param n - Indice a verificar na matriz universo
     *@return Elemento na posição n
     *@requires n > 0
     */
	
	public CorpoCeleste nEsimoElemento(int n) {
		
		if(n > this.m.length * this.m[0].length) {
			
			n = (n) % (this.m.length * this.m[0].length); 
		} 
		
		int linha=0;
		int contador=1;
		
		for ( CorpoCeleste[] arrayCorpos : this.m ) {
			
			if (linha%2==0) {
				
				for ( CorpoCeleste corpo : arrayCorpos ) {
					
					if (contador==n) {
						
						return corpo;				
					}
					contador++;
				}	
			} else {
				
				 for(int coluna=arrayCorpos.length-1;coluna>=0;coluna--) {
					
					 if (contador==n) {
							
						return arrayCorpos[coluna];
					 } 
					 contador++;
				 }
			}
			linha++;
		}
		return null;
	}
}
