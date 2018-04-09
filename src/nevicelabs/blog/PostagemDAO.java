package nevicelabs.blog;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PostagemDAO {

	private EntityManager gerenciador = JPAUtil.getEntityManager();
	private List<Postagem> postagens;
	private List<Postagem> postagensLazyDataModel;

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
			Query q = gerenciador.createQuery("select p from Postagem p", Postagem.class);
			postagens = new ArrayList<Postagem>();
			postagens = q.getResultList();
			// gerenciador.close();
		}
		return postagens;
	}

    /**
	 * Método para paginação real
	 * @param numPagina O número da página a ser consultada
	 * @return As postagens referentes à página
     */
	 public List<Postagem> getPostagensLazyDataModel() {
		if (postagensLazyDataModel == null) {
			String jpql = "select p from Postagem p";
			String count = "select count(p.id) from Postagem p";
			postagensLazyDataModel = (List<Postagem>) new QueryDataModel<Postagem>(jpql, count);
		}
		return postagensLazyDataModel;
	}
}