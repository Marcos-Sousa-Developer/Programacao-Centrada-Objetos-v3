import java.util.List;
import java.util.ArrayList;

/**
 *Subclasse de AbstractSistemaSolar, cujas inst�ncias representam sistemas solares
 *em que os corpos celestes est�o organizados linearmente, sem apresentarem buracos
 *negros nem espa�os null
 * @author PCO 59, Marcos Leit�o 55852, Rafael Ribeiro 56958, Gabriel Fonseca 57155
 * @date Dezembro 2021 
 */

public class Sistema1DSeguro extends AbstractSistemaSolar {
	
	/**
     *Matriz de corpos celestes m
     */
	
	private CorpoCeleste[][] m;
	
	/**
     *Direcionador referenciando uma das suas inst�ncias
     */
	
	private Direcionador d; 
	
	/**
     * Lista linear de corpos celestes sem buracos negros nem null
     */
	
	private List<CorpoCeleste> mFiltrado;
	
	/**
     * Recebe um array bidimensional e filtra os valores apenas para corpos celestes,
     * descartando os buracos negros e os valores a null
     *@param m - Matriz de corpos celestes
     *@return Lista linear apenas com corpos celestes
     *@requires Cada array de m tem de ter o mesmo n�mero de elementos
     */
	
	private List<CorpoCeleste> filtraCorpoCeleste(CorpoCeleste[][] m) {  
		
		List<CorpoCeleste> newM = new ArrayList<CorpoCeleste>();
		
		for ( CorpoCeleste[] arrayCorpos : this.m ) {
			
			for ( CorpoCeleste corpo : arrayCorpos ) {
				
				if (corpo instanceof CorpoCeleste && !(corpo instanceof BuracoNegro)) {
					
					newM.add(corpo);
					
				}
			}
		}
		
		return newM;
	}
	
	/**
     *Inicializa um novo objeto com nome nome, tendo por base um sistema 2D a matriz
     *m e um direcionador LinhaALinha
     *@param nome - Nome do objeto
     *@param m - Matriz de corpos celestes
     *@requires Cada array de m tem de ter o mesmo n�mero de elementos
     */
	
	public Sistema1DSeguro(String nome, CorpoCeleste[][] m) {
		
		super(nome);
		
		this.m=m; 
		
		this.d = new LinhaALinha();
		
		this.mFiltrado = filtraCorpoCeleste(this.m);
		
	}

	/**
     *Devolve o n�mero de elementos da lista de corpos celestes deste sistema 
     *@return N�mero de elementos da lista de corpos celestes deste sistema
     */
	
	public int quantosElementos() {  
		
		return this.mFiltrado.size();
	}

	/**
     *Devolve o (n-1)-�simo corpo celeste da lista deste sistema solar
     *@param n - N�mero do corpo celeste a verificar na lista deste sistema solar
     *@return Corpo celeste correspondente ao indice n na lista deste sistema solar
     *@requires n > 0
     */
	
	public CorpoCeleste getElemento(int n) {
		
		if(n > this.mFiltrado.size()) {
			
			n = n%this.mFiltrado.size();	
		}
		
		return this.mFiltrado.get(n-1);
	}

	/**
     *Devolve o buraco negro do sistema 2D associado que se encontra mais perto do 
     *corpo celeste c 
     *@param c - Corpo celeste ao qual se ir� verificar o buraco negro mais pr�ximo
     *@return Buraco negro mais pr�ximo
     */
	
	public BuracoNegro buracoNegroMaisPerto(CorpoCeleste c) {

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
     *Representa��o textual do sistema solar 
     *@return String - Representa��o textual deste sistema solar
     */
	
	public String toString() {
		
		StringBuilder sb=new StringBuilder();
		
		sb.append("Nome: " + super.nome() );
			
		sb.append(System.getProperty("line.separator"));
		
		sb.append("Planetas:");
		
		sb.append(System.getProperty("line.separator"));
		
		for ( CorpoCeleste corpo : this.mFiltrado ) {
										
					sb.append(corpo.posicao() + "  ");
			
		}
		return sb.toString();
	}
}




