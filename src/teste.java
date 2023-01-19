import java.util.ArrayList;
import java.util.List;

public class teste {
	
	public static void main(String[] args) {
		
		
		CorpoCeleste[][] result = new CorpoCeleste[4][5];
		
		Ponto3D posicao = new Ponto3D(0,0,6);
		
		CorpoCeleste c = null; 
		
		double massa = 3.0;
		posicao = new Ponto3D(0,0,6);
		c = new CorpoCeleste(massa, posicao);
		result[0][0] = c;
		
		
		massa = 4.0;
		posicao = new Ponto3D(0,1,13);
		c = new CorpoCeleste(massa, posicao);
		result[0][1] = c;
		
		massa = 3.0;
		posicao = new Ponto3D(0,2,4);
		c = new CorpoCeleste(massa, posicao);
		result[0][2] = c;
		
		massa = 4.0;
		posicao = new Ponto3D(0,3,26);
		c = new CorpoCeleste(massa, posicao);
		result[0][3] = c;
		
		result[0][4] = null;
		
		result[1][0] = null;
		result[1][1] = null;
		result[1][2] = null;
		result[1][3] = null;
		result[1][4] = null;
		
		massa = 4.0;
		posicao = new Ponto3D(2,0,13);
		c = new CorpoCeleste(massa, posicao);
		result[2][0] = c;
		
		massa = 4.0;
		posicao = new Ponto3D(2,1,13);
		c = new CorpoCeleste(massa, posicao);
		result[2][1] = c;
		
		result[2][2] = null;
		
		massa = 3.0;
		posicao = new Ponto3D(2,3,22);
		c = new CorpoCeleste(massa, posicao);
		result[2][3] = c;
		
		massa = 3.0;
		posicao = new Ponto3D(2,4,22);
		c = new CorpoCeleste(massa, posicao);
		result[2][4] = c;
		
		massa = 2.0;
		posicao = new Ponto3D(3,0,13);
		c = new BuracoNegro(massa, posicao);
		result[3][0] = c;
		
		massa = 1.0;
		posicao = new Ponto3D(3,1,26);
		c = new CorpoCeleste(massa, posicao);
		result[3][1] = c;
		
		result[3][2] = null;
		result[3][3] = null;
		result[3][4] = null;

		
	

//-----------TESTE A CLASSE CORPO CELESTE------------------------\\ 
		
		//TESTE A DISTANCIA
		
		//double valor = result[0][3].distancia(result[0][2]); 
		
		//System.out.println(valor); 
		
		//TESTE AO EQUALS 
		
		//caso null
		//System.out.println(result[3][1].equals(result[3][2])); 
		
		//caso instância de Corpo Celeste 
		//System.out.println(result[3][0].equals(result[3][1])); 
		
		
		// caso mesmo massa 
		//System.out.println(result[2][3].equals(result[2][4])); 
		
		//verificar massas
		//System.out.println(result[2][0].equals(result[2][1])); 
		
//-----------TESTE AO BURACO NEGRO------------------------\\
		
		//System.out.println(((BuracoNegro) result[3][0]).distanciaMinimaSeguranca(result[3][1]));

//-----------TESTE AO SISTEMA2D ------------------------\\
		Direcionador d = new LinhaALinha();
		Sistema2D sistema = new Sistema2D("Orion", result, d);
		List<Integer> aVisitar = new ArrayList<Integer>();
		aVisitar.add(2);
		aVisitar.add(1);
		aVisitar.add(2);
		aVisitar.add(3);
		aVisitar.add(10);
		aVisitar.add(11);
		
		//teste ao quantos Elementos 
		//System.out.println(sistema.quantosElementos()); 
		
		//teste ao getElemento 
		//System.out.println((sistema.getElemento(1).posicao())); 
		
		//teste buracoNegroMaisPerto 
		//System.out.println(sistema.buracoNegroMaisPerto(result[3][1]).posicao());
		
		//testes ao podeVisitar
		//System.out.println(sistema.toString()); 
		
//-----------TESTE AO SISTEMA1D SEGURO ------------------------\\	
		Sistema1DSeguro sistemaSeguro = new Sistema1DSeguro("Orion", result);
		
		//System.out.println(sistemaSeguro.toString());

//-----------TESTE LAGARTA HORIZONTAL ------------------------\\ 
		
		Direcionador d1 = new LagartaHorizontal();  
		
		d1.defineUniverso(result);
		
		//System.out.println(d1.nEsimoElemento(22).posicao());

//-----------TESTE LAGARTA VERTICAL ------------------------\\
		
		Direcionador d2 = new LagartaVertical();  
		
		d2.defineUniverso(result);
		
		d2.nEsimoElemento(44);
		
//-----------TESTE AO GRANDE PRÉMIO ------------------------\\
		sistema = new Sistema2D("Orion", result, d);
		
		Ponto3D inicioGP = sistemaSeguro.getElemento(3).posicao();
		Viajante v1 = new Viajante("Gabripai", inicioGP, 50);
		
		inicioGP = sistemaSeguro.getElemento(2).posicao();
		Viajante v2 = new Viajante("Rafastyle", inicioGP, 50);
		
		inicioGP = sistemaSeguro.getElemento(1).posicao();
		Viajante v3 = new Viajante("MarquitosGang", inicioGP, 50);
		
		
		List<Viajante> jogs = new ArrayList<Viajante>();
		jogs.add(v1);
		jogs.add(v2);
		jogs.add(v3);
		
		
		GrandePremioSideral gp = new GrandePremioSideral(sistema, jogs, 2000);
		
		List<Par<String,Integer>> jogadas = new ArrayList<Par<String,Integer>>();
		
		jogadas.add(new Par<String,Integer>("Gabripai",3));
		
		jogadas.add(new Par<String,Integer>("Rafastyle",21)); 
		
		jogadas.add(new Par<String,Integer>("MarquitosGang",17)); 
		
		
		gp.fazJogada(jogadas); 
		
		gp.vencedores();
		
		System.out.println(gp.toString());
		
		
	}

}
