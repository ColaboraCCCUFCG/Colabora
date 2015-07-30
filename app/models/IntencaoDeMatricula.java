package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class IntencaoDeMatricula{
	// Gerador de Sequencia para o Id
	// Todo Id tem que ter o GeneratedValue a não ser que ele seja setado
	@Id
	@SequenceGenerator(name = "MATRICULA_SEQUENCE", sequenceName = "MATRICULA_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)

	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn
	private List<Disciplina> disciplinas;
	
	@JoinColumn
	private String emailDoUsuario;
	
	
	// Construtor vazio para o Hibernate criar os objetos
	public IntencaoDeMatricula (){
		
	}
	
	public IntencaoDeMatricula (String emailDoUsuario){		
		this.disciplinas = new ArrayList<Disciplina>();
		this.emailDoUsuario = emailDoUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getEmailDoUsuario() {
		return emailDoUsuario;
	}

	public void setEmailDoUsuario(String emailDoUsuario) {
		this.emailDoUsuario = emailDoUsuario;
	}

	
	
	
	

}
