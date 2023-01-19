import java.util.List;

/**
 *Este interface define caracteristicas de um sistema solar tais como
 *o seu nome, possibilidade de ser visitado, quanto elementos contem e 
 *o buraco negro mais proximo
 * @author PCO 59, Marcos Leit�o 55852, Rafael Ribeiro 56958, Gabriel Fonseca 57155
 * @date Dezembro 2021
 */

public interface SistemaSolar {
	
	/**
     * Devolve o nome do sistema solar
     */
	
	String nome();
	
	/**
     * Devolve o valor booleano consoante a possibilidade de visitar
     * todos os elementos do sistema solar correspondentes aos
     * n�meros de ordem contidos na lista aVisitar
     * @param aVisitar - Lista que cont�m os numeros de ordem dos elementos que
     * do sistema solar
     */
	
	boolean podeVisitar(List<Integer> aVisitar);
	
	/**
     * Devolve o n�mero de elementos que este
     * sistema solar define;
     */
	
	int quantosElementos();
	
	/**
     *Devolve o corpo celeste deste sistema solar correspondente
     *ao n�mero de ordem n
     *@param n - Numero de elementos do sistema solar
     *@requires n > 0
     */
	
	CorpoCeleste getElemento(int n);
	
	/**
     *Devolve o buraco negro deste sistema solar que se encontra
     *mais perto do corpo celeste c
     *@param c - Corpo Celeste que pretende verificar qual o buraco negro mais proximo
     *@requires n>0
     */
	
	BuracoNegro buracoNegroMaisPerto(CorpoCeleste c);
}
