package dao;

import javax.persistence.EntityManager;

import filmes.Filmes;

public class FilmesDao {
	private EntityManager em = null;
	
	public FilmesDao(EntityManager em) {
		this.em = em;
	}
	
	// Método para cadastrar um produto
	public void cadastrar(Filmes filmes) {
		this.em.getTransaction().begin();
		this.em.persist(filmes);
		this.em.getTransaction().commit();
	}

	// Método para buscar elementos da tabela do BD
	public Filmes buscar(int id) {
		try {
			return em.find(Filmes.class, id);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
}
