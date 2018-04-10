package nevicelabs.blog;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="posts")
public class Postagem {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at", updatable=false)
	private Date criadoEm;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at", updatable=false)
	private Date atualizadoEm;
	
	@Column(name="title", length=255, nullable=false)
	private String titulo;
	
	@Column(name="content", nullable=false)
	private String conteudo;
	
	@Column(name="user_id", nullable=false)
	private int usuarioId = 1;
	
	// @ManyToOne(cascade=CascadeType.ALL)
	// private Pagina pagina;
	
	// Criamos uma tabela com strings que ser�o utilizados como tags
	// @ElementCollection @Column(length=20)
	// private List<String> tags;

	public Postagem() {
		// pagina = new Pagina();
		// pagina.adicionarNaPagina(this);
	}
	
	public Integer getId() { return id; }
	
	public void setId(int id) { this.id = id; }
	
	/* Utilizamos a anotação Lob para indicar que o método pode
	 * retornar um objeto grande (Large OBject).
	 * Utilizamos a anotação Basic para garantir o Lazy Loading.
	 */
	@Lob @Basic(fetch=FetchType.LAZY)
	public String getConteudo() { return conteudo; }
	
	public void setConteudo(String conteudo) { this.conteudo = conteudo; }
	
	public String getTitulo() { return titulo; }
	
	public void setTitulo(String titulo) { this.titulo = titulo; }
	
	public Date getCriadoEm() { return criadoEm; }
	
	public void setCriadoEm(Date criadoEm) { this.criadoEm = criadoEm; }
	
	public Date getAtualizadoEm() { return atualizadoEm; }
	
	public void setAtualizadoEm(Date atualizadoEm) { this.atualizadoEm = atualizadoEm; }
	
	public int getUsuarioId() { return usuarioId; }
	
	public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
	
	// public Pagina getPagina() { return pagina; }

	// public void setPagina(Pagina pagina) { 	this.pagina = pagina; }

}
