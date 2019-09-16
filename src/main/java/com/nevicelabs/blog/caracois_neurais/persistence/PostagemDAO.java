package com.nevicelabs.blog.caracois_neurais.persistence;

import org.primefaces.model.LazyDataModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import com.nevicelabs.blog.caracois_neurais.util.JPAUtil;
import com.nevicelabs.blog.caracois_neurais.domain.Postagem;
import com.nevicelabs.blog.caracois_neurais.business.QueryDataModel;

public class PostagemDAO {

	private EntityManager gerenciador = JPAUtil.getEntityManager();
	private List<Postagem> postagens;
	private LazyDataModel<Postagem> postagensLazyDataModel;

	public void adicionar(Postagem post) {
		gerenciador.getTransaction().begin();
		gerenciador.persist(post);
		gerenciador.getTransaction().commit();
		gerenciador.close();
	}

	public void excluir(Postagem post) {
	    EntityTransaction tx = gerenciador.getTransaction();
	    tx.begin();
	    post = gerenciador.merge(post);
	    gerenciador.remove(post);
	    tx.commit();
	    gerenciador.close();
    }

	public Postagem getPostagem(int id) {
		Postagem post = gerenciador.find(Postagem.class, id);
		return post;
	}

	@SuppressWarnings("unchecked")
	public List<Postagem> getPostagens() {
		if (postagens == null) {
			Query q = gerenciador.createQuery("select p from Postagem p");
			// Query q = gerenciador.createQuery("select p from Postagem p", Postagem.class);
			postagens = new ArrayList<Postagem>();
			postagens = q.getResultList();
			// gerenciador.close();
		}
		return postagens;
	}

    /**
	 * Método para paginação real
	 * @return As postagens referentes à página
     */
	 public LazyDataModel<Postagem> getPostagensLazyDataModel() {
		if (postagensLazyDataModel == null) {
			String jpql = "select p from Postagem p";
			String count = "select count(p.id) from Postagem p";
			postagensLazyDataModel = new QueryDataModel<Postagem>(jpql, count);
		}
		return postagensLazyDataModel;
	}
}