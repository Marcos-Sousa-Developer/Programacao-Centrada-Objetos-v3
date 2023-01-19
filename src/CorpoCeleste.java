
/**
 *Classe cujas instâncias representam corpos celestes ou seja, corpos que têm uma 
 *massa e uma posição num espaço tridimensional
 * @author PCO 59, Marcos Leitão 55852, Rafael Ribeiro 56958, Gabriel Fonseca 57155
 * @date Dezembro 2021
 */

public class CorpoCeleste {

	/**
     *Massa do corpo celeste
     */
	
	private double massa;
	
	/**
     *Posição do corpo celeste
     */
	
	private Ponto3D pos;
	
	/**
     *Matriz de corpos celestes
     *@param massa - Massa do corpo celeste
     *@param pos - Posição do corpo celeste
     *@requires massa > 0.0
     */
	
	public CorpoCeleste (double massa, Ponto3D pos) {
		
		this.massa=massa;
		
		this.pos=pos;
		
	}
	
	/**
     *Retorna a massa do corpo celeste
     *@return Massa do corpo celeste 
     */
	
	public double massa() 	{
		return this.massa;
	}
	
	/**
     *Retorna a posição do corpo celeste
     *@return Posição do corpo celeste
     */
	
	public Ponto3D posicao() {
		return this.pos;
	}
	
	/**
     *Retorna a distância deste corpo celeste a c
     *@param c - Corpo Celeste
     *@return Distancia deste corpo celeste a c
     */
	
	public double distancia(CorpoCeleste c) { 
		
		return this.pos.distancia(c.posicao());
	}

	/**
     *Retorna o valor booleano consoante se other for um corpo celeste e tem massa
     *e posição igual à deste corpo celeste
     *@param other - Objeto a verificar se é corpo celeste ou não
     *@return Valor booleano para se other for corpo celeste ou não e tiver a mesma massa
     *e posição que este corpo celeste
     */
	
	public boolean equals(Object other) {
		
		if (other instanceof CorpoCeleste) {
			if ((((CorpoCeleste) other).massa() - this.massa) <= 0.0001) { 
				
				if ( ((CorpoCeleste) other).posicao().equals(this.pos)) {
					
					return true;
				}
			}
		}
		return false;
	}
}





















