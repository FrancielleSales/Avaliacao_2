package dao;

import javax.persistence.EntityManager;

import produto.Produto;

public class ProdutoDao {
	private EntityManager em = null;
	
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	// Método para cadastrar um produto
	public void cadastrar(Produto produto) {
		this.em.getTransaction().begin();
		this.em.persist(produto);
		this.em.getTransaction().commit();
	}
	
	// Método para atualizar um produto
	public Produto atualizar(Produto produto) {
		try {
			this.em.getTransaction().begin();
			produto = this.em.merge(produto);
			this.em.getTransaction().commit();
			return produto;
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			this.em.getTransaction().rollback();
			return null;
		}
	}
	
	// Método para excluir um produto
	public boolean excluir(Produto produto) {
		try {
			this.em.getTransaction().begin();
			this.em.remove(produto);
			this.em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		    this.em.getTransaction().rollback();
			return false;
		}
	}
}
