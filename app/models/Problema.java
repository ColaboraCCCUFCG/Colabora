package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
public class Problema{
	// Gerador de Sequencia para o Id
	// Todo Id tem que ter o GeneratedValue a não ser que ele seja setado
	@Id
	@SequenceGenerator(name = "PROBLEMA_SEQUENCE", sequenceName = "PROBLEMA_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)

	private Long id;
	
	@Column
	private String problema;
	
	@Column
	private String disciplina;
	
	@Column
	private String emailDoUsuario;
	
	
	// Construtor vazio para o Hibernate criar os objetos
	public Problema (){
		
	}
	
	public Problema (String problema, String disciplina, String usuario){
		this.problema = problema;
		this.disciplina = disciplina;
		this.emailDoUsuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getEmailDoUsuario() {
		return emailDoUsuario;
	}

	public void setEmailDoUsuario(String emailDoUsuario) {
		this.emailDoUsuario = emailDoUsuario;
	}

	

	
	
	
	
	

}
