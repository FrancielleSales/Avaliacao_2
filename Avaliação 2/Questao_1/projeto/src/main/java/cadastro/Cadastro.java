package cadastro;

import java.math.BigDecimal;
import java.util.Scanner;
import javax.persistence.EntityManager;
import dao.ProdutoDao;
import produto.Produto;
import util.JPAUtil;

public class Cadastro {
	
	private static EntityManager em = JPAUtil.getEntityManager();
	private static ProdutoDao dao = new ProdutoDao(em);
	private static Produto [] prod = {null, null, null};
	
	// Função com os produtos a serem cadastrados
	private static void cadastrarProdutos() {
		prod[0] = new Produto();
		prod[0].setNome("Celular Galaxy Premium X");
		prod[0].setDescricao("Celular Samsung Galaxy Premium X new generation");
		prod[0].setQuantidade(938);
		prod[0].setPreco(new BigDecimal("2384.18"));
		
		prod[1] = new Produto();
		prod[1].setNome("Notebook Galaxy Premium X");
		prod[1].setDescricao("Notebook Samsung Galaxy Premium X new generation");
		prod[1].setQuantidade(488);
		prod[1].setPreco(new BigDecimal("4375.09"));
		
		prod[2] = new Produto();
		prod[2].setNome("Monitor Premium X 24 polegadas");
		prod[2].setDescricao("Monitor Samsung Premium X new generation 24 polegadas");
		prod[2].setQuantidade(395);
		prod[2].setPreco(new BigDecimal("1375.45"));
		
		for(int i = 0; i < 3; i++) {
			dao.cadastrar(prod[i]);
		}
	}
	
	public static void main(String[] args) {
				
		// Inicializando o scanner
		Scanner scanner = new Scanner(System.in);
		      
        while(true) {

		// Mostra o menu
		System.out.println("Digite a opcao desejada: \n");
		System.out.println("	0 - Finalizar a aplicacao");
		System.out.println("	1 - Cadastrar produtos");
		System.out.println("	2 - Atualizar produto");
		System.out.println("	3 - Excluir produto\n");
		System.out.print("Opcao: ");
		String opcao = scanner.nextLine();
		
		// Funcionamento do menu        
	        switch(opcao) {
	        	case "0":
	        		System.out.println("\nAplicacao finalizada!");
	        		scanner.close();
	        		System.exit(0);
	        		break;
	        	case "1":
	        		cadastrarProdutos();
	        		System.out.println("\nProdutos cadastrados!\n");
	        		break;
	        	case "2":
	        		if (prod[0] != null) {
		        		prod[0].setQuantidade(10);
		        		
		        		if (dao.atualizar(prod[0]) != null) {
			        		System.out.println("\nProduto atualizado!\n");
		        		} else {
		        			System.out.println("Falha ao tentar atualizar\n");
		        		}
	        		} else {
	        			System.out.println("\nNao foi executado o cadastro dos produtos\n");
	        		}
	        		break;
	        	case "3":	        		
	        		if (dao.excluir(prod[1])) {
	        			System.out.println("\nProduto excluido!\n");
	        		} else {
	        			System.out.println("Falha ao tentar excluir\n");
	        		}
	        		break;
	            default:
	                System.out.println("\nOpcao invalida!\n");	                
	        }
        }	
	}
}
