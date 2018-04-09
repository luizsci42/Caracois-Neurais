package nevicelabs.blog;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class PostagemBean {
	
	private Postagem postagem = new Postagem();
	private PostagemDAO dao = new PostagemDAO();
	
	public void salvar(Postagem novaPostagem) { dao.adicionar(novaPostagem); }

	public void excluir(Postagem postagem) { dao.excluir(postagem); }

	public List<Postagem> getPostagens() { return dao.getPostagens(); }

	public List<Postagem> getPostagensLazyDataModel() { return dao.getPostagensLazyDataModel(); }

	public Postagem getPostagem(int id) { return dao.getPostagem(id); }

	public void setPostagem(Postagem post) { this.postagem = post; }

	// TODO: Remover getter e setters do PostagemDAO. São inúteis
	public PostagemDAO getPostagemDAO() { return this.dao; }
	
	public void setPostagemDAO(PostagemDAO dao) { this.dao = dao; }

}