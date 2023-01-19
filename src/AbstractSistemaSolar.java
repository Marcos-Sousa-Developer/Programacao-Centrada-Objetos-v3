import java.util.List;

/**
 * Classe abstrata que define o que � comum a v�rios sistemas solares
 * @author PCO 59, Marcos Leit�o 55852, Rafael Ribeiro 56958, Gabriel Fonseca 57155
 * @date Dezembro 2021
 */

public abstract class AbstractSistemaSolar implements SistemaSolar {
	
	/**
     * Nome do sistema solar 
     */
	
	private String nome;
	
	/**
     * Inicializa um novo objeto com o nome nome
     *@param nome - Nome do sistema solar
     */
	
	public AbstractSistemaSolar(String nome) {
		 
		this.nome=nome;
	 
	 }

	/**
     * Define o nome do sistema solar
     * @return Nome do sistema solar
     */
	
	public String nome() {
		
		return this.nome;
	}

	/**
     * Devolve o valor o booleano consoante se todos os inteiros contidos na
     * lista aVisitar s�o maiores que zero e menores ou
     * iguais a quantosElementos()
     * @param aVisitar - Lista de inteiros a verificar 
     * @return Valor booleano consoante as condi��es dadas
     */
	
	public boolean podeVisitar(List<Integer> aVisitar) {
		
		for(int valor:aVisitar) {
			
			if (valor<=0 || valor>quantosElementos()) {
				
				return false;
			}
		}
		return true;
	}
	
	/**
     * Devolve a representa��o textual correspondente ao nome do sistema solar
     * @return Representa��o textual do nome do sistema solar 
     */

	public String toString () {
		
		StringBuilder sb=new StringBuilder();
		
		sb.append("Sistema Solar: ");
		
		return sb.toString() + this.nome;

	}
	
}
