import java.util.List;

/**
 *Subclasse de AbstractSistemaSolar, cujas instâncias representam sistemas solares
 *em que os corpos celestes estão organizados numa matriz
 * @author PCO 59, Marcos Leitão 55852, Rafael Ribeiro 56958, Gabriel Fonseca 57155
 * @date Dezembro 2021
 */

public class Sistema2D extends AbstractSistemaSolar {
	
	/**
     *Matriz de corpos celestes
     */
	
	private CorpoCeleste[][] m;
	
	/**
     *Direcionador referenciando uma das suas instâncias
     */
	
	private Direcionador d;

	/**
     *Inicializa um novo objeto com nome nome, uma matriz de corpos celestes igual
     *a m e um direcionador igual a d
     *@param nome - Nome do sistema solar
     *@param m - Matriz de corpos celestes
     *@param d - Direcionador de instancias
     *@requires Cada array de m tem de ter o mesmo número de elementos
     */
	
	public Sistema2D(String nome, CorpoCeleste[][] m, Direcionador d) {
	
		super(nome);
		
		this.m=m;
		
		this.d=d;
	}
	
	/**
     *Devolve o número de elementos da matriz deste sistema 2D
     *@return Número de elementos da matriz
     */
	
	public int quantosElementos() {
		
		return this.m.length * this.m[0].length;
	}

	/**
     *Devolve o corpo celeste da matriz deste sistema solar correspondente ao número
     *de ordem n
     *@param n - Numero de ordem na matriz
     *@return Corpo celeste correspondente ao número de ordem n
     *@requires n > 0
     */
	
	public CorpoCeleste getElemento(int n) { 
		
		this.d.defineUniverso(m);
		
		return this.d.nEsimoElemento(n);
	}

	/**
     *Devolve o buraco negro deste sistema solar que se    encontra mais perto    do corpo
     *celeste c
     *@param c - Corpo celeste que se quer verificar o buraco negro mais próximo
     *@return Buraco Negro mais próximo 
     */
	
	public BuracoNegro buracoNegroMaisPerto (CorpoCeleste c) {
			
		double distanciaMinima=0.0;
		
		BuracoNegro bnMaisProximo = null;
		
		int contador = 0;  
				
		for ( CorpoCeleste[] arrayCorpos : this.m ) {
			
			for ( CorpoCeleste corpo : arrayCorpos ) {
				
				if ( corpo instanceof BuracoNegro) {
				
					if ( contador==0 ) {
						
						distanciaMinima = corpo.distancia(c);
						
						bnMaisProximo = (BuracoNegro) corpo;
						
						contador++;
						
					} else {
			
						if ( corpo.distancia(c) < distanciaMinima) {
							
							distanciaMinima = corpo.distancia(c);
							
							bnMaisProximo = (BuracoNegro) corpo;				
						}
					}
				}
			}
		}
		return bnMaisProximo;
	}
	
	/**
     *Devolve o valor booleano consoante se todos os inteiros contidos na lista 
     *aVisitar são maiores que zero e menores ou iguais a quantosElementos() 
     *e se todos os elementos da matriz correspondentes aos números de ordem em aVisitar são
     *corpos celestes vulgares (não são buracos negros nem null)
     *@param aVisitar - Lista de inteiros a verificar se tem no seu todo apenas corpos celestes
     *@return Valor booleano 
     */
	
	public boolean podeVisitar(List<Integer> aVisitar) {
		
		for(int valor:aVisitar) {
					
			if (valor<=0 || valor>quantosElementos()) {
						
				return false;
			}
		}
		for(int valor:aVisitar) {
			if ( !(getElemento(valor) instanceof CorpoCeleste)) {
			
				return false;	
			}
		}
		return true;
	}
	
	/**
     *Representação textual deste sistema solar 
     *@return String - Representação textual deste sistema solar
     */
	
	public String toString() {
		
		StringBuilder sb=new StringBuilder();
			
		sb.append("Nome: " + super.nome() );
			
		sb.append(System.getProperty("line.separator"));
		
		sb.append("Direcionador: " + this.d.getClass().getName());
		
		sb.append(System.getProperty("line.separator"));
		
		for ( int l=0; l< this.m.length; l++ ) {
			
			for ( int c=0; c< this.m[0].length; c++) {
				
				if(this.m[l][c] != null) {
					if(this.m[l][c] instanceof BuracoNegro ) {
						
						sb.append("B"+this.m[l][c].posicao() + " ");
						
					}else {
						
						sb.append(this.m[l][c].posicao() + " ");
					}
				}
				else {
					
					sb.append("  null  ");
				}
			}
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	 }
}
























