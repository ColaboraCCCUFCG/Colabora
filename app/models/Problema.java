package models;

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
	private Disciplina disciplina;
	
	
	// Construtor vazio para o Hibernate criar os objetos
	public Problema (){
		
	}
	
	public Problema (String problema, Disciplina disciplina){
		this.problema = problema;
		this.disciplina = disciplina;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	/*@Override
	public int hashCode() {
		
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Problema other = (Problema) obj;
		if (problema == null) {
			if (other.problema != null)
				return false;
		} else if (!problema.equals(other.problema))
			return false;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		
		return true;
	}	

}
