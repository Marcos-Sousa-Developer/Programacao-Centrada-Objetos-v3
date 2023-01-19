
/**
 * Subclasse de CorpoCeleste cujas instâncias representam corpos celestes com uma
 * massa tal
 * @author PCO 59, Marcos Leitão 55852, Rafael Ribeiro 56958, Gabriel Fonseca 57155
 * @date Dezembro 2021
 */

public class BuracoNegro extends CorpoCeleste {
	
	/**
     *Inicializa um novo objeto com uma massa igual a massa e uma posição igual a pos
     *@param massa - Massa do buraco negro
     *@param pos - Posição do buraco negro
     *@requires massa > 0.0
     */

	 public BuracoNegro (double massa, Ponto3D pos) {
		 
		 super(massa,pos);
		
	 }
	 
	 /**
      * Retorna o valor da distância mínima a que um outro corpo celeste tem que estar
      * para não ser muito afetado pela força de atração deste buraco negro
      * @return Valor da raiz quadrada do produto das massas do buraco negro e do CorpoCeleste c
      */
	 
	 public double distanciaMinimaSeguranca(CorpoCeleste c) {

		 return Math.sqrt( super.massa() * c.massa() );
		 
	 }
}
