
/**
 *Classe cujas inst�ncias representam corpos celestes ou seja, corpos que t�m uma 
 *massa e uma posi��o num espa�o tridimensional
 * @author PCO 59, Marcos Leit�o 55852, Rafael Ribeiro 56958, Gabriel Fonseca 57155
 * @date Dezembro 2021
 */

public class CorpoCeleste {

	/**
     *Massa do corpo celeste
     */
	
	private double massa;
	
	/**
     *Posi��o do corpo celeste
     */
	
	private Ponto3D pos;
	
	/**
     *Matriz de corpos celestes
     *@param massa - Massa do corpo celeste
     *@param pos - Posi��o do corpo celeste
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
     *Retorna a posi��o do corpo celeste
     *@return Posi��o do corpo celeste
     */
	
	public Ponto3D posicao() {
		return this.pos;
	}
	
	/**
     *Retorna a dist�ncia deste corpo celeste a c
     *@param c - Corpo Celeste
     *@return Distancia deste corpo celeste a c
     */
	
	public double distancia(CorpoCeleste c) { 
		
		return this.pos.distancia(c.posicao());
	}

	/**
     *Retorna o valor booleano consoante se other for um corpo celeste e tem massa
     *e posi��o igual � deste corpo celeste
     *@param other - Objeto a verificar se � corpo celeste ou n�o
     *@return Valor booleano para se other for corpo celeste ou n�o e tiver a mesma massa
     *e posi��o que este corpo celeste
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





















