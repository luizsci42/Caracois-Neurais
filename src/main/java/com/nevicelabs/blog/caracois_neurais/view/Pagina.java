package com.nevicelabs.blog.caracois_neurais.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.nevicelabs.blog.caracois_neurais.domain.Postagem;

@ManagedBean
public class Pagina {
	
	@Id @GeneratedValue
	private int id;
	
	@OneToMany(mappedBy="pagina", cascade=CascadeType.ALL)
	private List<Postagem> postsDaPagina;
	
	public void adicionarNaPagina(Postagem post) { postsDaPagina.add(post); }
	
	public int getId() { return this.id; }

	public List<Postagem> getPostsDaPagina() { return postsDaPagina; }

	public Pagina getPaginaPorId(int idDaPagina) { return this; }
	
	// public void setPostsDaPagina(List<Postagem> postsDaPagina) { this.postsDaPagina = postsDaPagina; }

}
