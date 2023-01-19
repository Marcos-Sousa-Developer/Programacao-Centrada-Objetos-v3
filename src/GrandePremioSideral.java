import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Representam grandes pr�mios siderais que se realizam sobre um dado sistema solar
 *e em que v�rios viajantes v�o fazendo jogadas
 * @author PCO 59, Marcos Leit�o 55852, Rafael Ribeiro 56958, Gabriel Fonseca 57155
 * @date Dezembro 2021 
 */

public class GrandePremioSideral {
	
	int PONTOS_BURACO_NEGRO = Integer.MAX_VALUE;
	
	int TAXA_RISCO = 5;
	
	/**
     *Lista com os viajantes a participar no grande pr�mio
     */
	
	private List<Viajante> jogs; 
	
	/**
     *Sistema solar onde se realizar� o grande pr�mio
     */
	
	private SistemaSolar ss;
	
	/**
     *Map em que as chaves s�o os nomes dos viajantes e os valores s�o os viajantes
     */
	
	private Map<String,Viajante> viajantes;
	
	/**
     *Pr�mio base do grande pr�mio
     */
	
	private int premioBase;
	
	/**
     *Inicializa um novo grande pr�mio a realizar no sistema solar ss, com os 
     *viajantes contidos em jogs e um pr�mio base igual a premioBase
     *@param ss - Sistema solar onde se realizar� o grande pr�mio
     *@param jogs - Lista com os viajantes a participar no grande pr�mio
     *@param premioBase - Pr�mio base do grande pr�mio 
     *@requires premioBase > 0
     */
	
	public GrandePremioSideral(SistemaSolar ss, List<Viajante>jogs, int premioBase) {
		
		this.ss=ss;
		
		this.jogs=jogs;
		
		this.viajantes = new HashMap<String,Viajante>();
		
		for ( Viajante viajante : jogs) {
			
			this.viajantes.put(viajante.nome(), viajante);
			
		}
		
		this.premioBase=premioBase;
	}
	
	/**
     *Devolve o pr�mio base definido para este grande pr�mio
     *@return Pr�mio base definido para este grande pr�mio
     */
	
	int premioBase() {
	
		return this.premioBase;
		
	}
	
	/**
     *Regista as jogadas dos v�rios viajantes que participam no grande pr�mio 
     *@param jogadas - Lista com as v�rias jogadas dos viajantes
     */
	
	void fazJogada(List<Par<String,Integer>> jogadas) {
		
		for ( Par<String,Integer> jogada:jogadas ) {
		
			CorpoCeleste c = this.ss.getElemento(jogada.segundo()); 
			
			Viajante v = this.viajantes.get(jogada.primeiro()); 
			
			if ( c!=null ) {	
				
				boolean podeViajar = v.podeViajar(c.posicao()); 
				
				if(podeViajar) { 
										
					if(v.posicaoGlobal() != c.posicao()) {
						
						v.mudaPosicaoGlobal(c.posicao());  
						
						if(c instanceof BuracoNegro) {
							
							v.registaPontos( - PONTOS_BURACO_NEGRO);
							
						}
						
						else if(c instanceof CorpoCeleste && !(c instanceof BuracoNegro)) {
							
							BuracoNegro bnMaisPerto = this.ss.buracoNegroMaisPerto(c); 
							
							double distanciaMinima = bnMaisPerto.distanciaMinimaSeguranca(c); 
							
							
							double distanciaCorpo = c.distancia(bnMaisPerto);
							
							
							if(distanciaCorpo < distanciaMinima) {
								
								v.registaPontos(this.premioBase() * TAXA_RISCO); 
							}
							
							else {
								
								v.registaPontos(this.premioBase());
							}
						}
					}
					else {
						
						double perdePontos = - (v.pontuacao() * 0.2); 
						
						v.registaPontos( (int) perdePontos);		
					}
				} 
				else {
					
					double perdePontos = - (v.pontuacao() * 0.2); 
					
					v.registaPontos( (int) perdePontos); 
				}
			}
			
			else {
				
				v.registaPontos( (int) (v.pontuacao() / 2) );
			}
		}
	}
   
	/**
     *Devolve os nomes dos viajantes que obtiveram a maior pontua��o
     *@return String - Nomes dos viajantes que obtiveram a maior pontua��o
     */
	
	List<String> vencedores() {
		
		int pontuacaoMaxima = 0;
		
		List<String> maioresPontuacoes= new ArrayList<String>();
		
		for ( Viajante viajante : this.jogs) {
			
			if ( viajante.pontuacao() >= pontuacaoMaxima) {
				
				pontuacaoMaxima = viajante.pontuacao();
			}
		} 
		for ( Viajante viajante : this.jogs) {
			
				if ( viajante.pontuacao() == pontuacaoMaxima) {
				
				maioresPontuacoes.add(viajante.nome());
			}
		}
		return maioresPontuacoes;
	}
	
	/**
     *Representa��o textual do grande pr�mio
     *@return String - Representa��o textual do grande pr�mio
     */
	
	public String toString() {
		
		StringBuilder sb=new StringBuilder();
		
		sb.append("============ GRANDE PREMIO ============");
		
		sb.append(System.getProperty("line.separator"));
		
		sb.append("Premio base: " + this.premioBase);
		
		sb.append(System.getProperty("line.separator")); 
		
		sb.append("Sistema Solar: " );
		
		sb.append(System.getProperty("line.separator"));
		
		sb.append(this.ss.toString()); 
		
		sb.append(System.getProperty("line.separator"));
		
		sb.append("Viajantes: ");
		
		sb.append(System.getProperty("line.separator"));
		
		for(Map.Entry<String,Viajante> viajante: this.viajantes.entrySet()) { 
			
			sb.append(viajante.getValue());
				
		} 
		
		return sb.toString();	
	}
}
