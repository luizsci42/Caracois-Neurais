package nevicelabs.blog;

import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class PostagemBean {
	
	private Postagem postagem = new Postagem();
	private PostagemDAO dao = new PostagemDAO();
	// private LazyDataModel<Postagem> postagensLazyDataModel;
	
	public void salvar(Postagem novaPostagem) { dao.adicionar(novaPostagem); }
	
	public Postagem exibirPostagem(int id) { return dao.getPostagem(id); }
	
	public List<Postagem> getPostagens() { return dao.getPostagens(); }

	public Postagem getPostagem() {	return this.postagem; }

	public void setPostagem(Postagem post) { this.postagem = post; }
	
	public PostagemDAO getPostagemDAO() { return this.dao; }
	
	public void setPostagemDAO(PostagemDAO dao) { this.dao = dao; }
	
	/*
	public LazyDataModel<Postagem> getPostagensLazyModel() {
		if(postagensLazyDataModel == null) {
			String jpql = "SELECT p FROM Postagem p";
			String count = "SELECT count(p.id) from Postagem p";
			postagensLazyDataModel = new QueryDataModel<Postagem>(jpql, count);
		}
		return postagensLazyDataModel;
	}
	*/

}