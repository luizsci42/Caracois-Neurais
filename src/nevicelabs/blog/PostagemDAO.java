package nevicelabs.blog;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class PostagemDAO {

	private EntityManager gerenciador = JPAUtil.getEntityManager();
	private List<Postagem> postagens;

	public void adicionar(Postagem post) {
		gerenciador.getTransaction().begin();
		gerenciador.persist(post);
		gerenciador.getTransaction().commit();
		gerenciador.close();
	}

	@SuppressWarnings("unchecked")
	public List<Postagem> getPostagens() {

		if (postagens == null) {
			Query q = gerenciador.createQuery("select p from Postagem p", Postagem.class);
			postagens = new ArrayList<Postagem>();
			postagens = q.getResultList();
			gerenciador.close();
		}

		return postagens;
	}
	
	// Método para paginação
	 public List<Postagem> getPostagens(int numPagina) {
		if (postagens == null) {
			TypedQuery<Postagem> q = gerenciador.createQuery("select p from Postagem p", Postagem.class);
			postagens = new ArrayList<Postagem>();
			int tamanhoPagina = 10;
			q.setMaxResults(tamanhoPagina);
			postagens = q.setFirstResult(numPagina * tamanhoPagina).getResultList();
			gerenciador.close();
		}

		return postagens;
	}
	
	public Postagem getPostagem(int id) {
		Postagem post = gerenciador.find(Postagem.class, id);
		return post;
	}
}