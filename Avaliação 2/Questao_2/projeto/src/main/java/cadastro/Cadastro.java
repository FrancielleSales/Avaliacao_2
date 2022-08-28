package cadastro;

import java.util.Scanner;
import javax.persistence.EntityManager;
import dao.FilmesDao;
import filmes.Filmes;
import util.JPAUtil;

public class Cadastro {
	
	private static EntityManager em = JPAUtil.getEntityManager();
	private static FilmesDao dao = new FilmesDao(em);
	private static final int TAMANHO_BD = 20;
	
	private static void cadastrarFilmes() {
		
		for (int i = 1; i <= TAMANHO_BD; i++) {
			Filmes f = new Filmes();
			f.setNome("Filme " + i);
			f.setDescricao("Descricao do filme " + i);
			f.setAno(1980 + i);
			dao.cadastrar(f);
		}
	}
		
	public static void main(String[] args) {
		
		// Cadastrando os filmes
		// cadastrarFilmes();
				
		// Inicializando o scanner
		Scanner scanner = new Scanner(System.in);
		
		// Recebe a quantidade de filmes que o usuário quer filtrar
		System.out.print("Digite a quantidade de filmes que voce deseja filtrar: ");
		int quantidadeFilmes = scanner.nextInt();
		
		// Valida a entrada do usuário para quantidade de filmes
		if (quantidadeFilmes < 1 || quantidadeFilmes > TAMANHO_BD) {
			System.out.print("A quantidade digitada eh invalida!");
			System.exit(1);
		}
		
		// Recebe o número da página que o usuário quer acessar
		System.out.print("Digite a pagina que voce deseja acessar: ");
		int quantidadePaginas = scanner.nextInt();
		scanner.close();
		
		// Valida a entrada do usuário para quantidade de páginas
		if (quantidadePaginas < 1 || quantidadePaginas > TAMANHO_BD) {
			System.out.print("A quantidade digitada eh invalida!");
			System.exit(1);
		}
		
		// Calculo do primeiro id
		int primeiroId = (((quantidadePaginas - 1) * quantidadeFilmes) + 1);		
		
		// Calculo do último id
		int ultimoId = quantidadeFilmes * quantidadePaginas;
		
		// Verifica se o último id é válido
		if (ultimoId > TAMANHO_BD) {
			System.out.print("A pagina contem menos filmes que o solicitado.\n");
			ultimoId = TAMANHO_BD;
		}
		
		// Para verificar se está dentro do limite de filmes existentes no BD
		Filmes filme = null;
			
		for (int i = primeiroId; i <= ultimoId; i++) {
			filme = dao.buscar(i);
			System.out.println(filme.getNome());
		}
			
		System.out.println("Programa finalizado");
		
	}
}
