package models;

import javax.persistence.*;

@Entity
public class Horario {
	@Id
	@SequenceGenerator(name = "HORARIO_SEQUENCE", sequenceName = "HORARIO_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)
	// Usar Id sempre Long
	private Long id;
	
	@Column	
	private int diaDaSemana;
	
	@Column
	private int horarioDeInicioDaAUla;
	
	// Construtor vazio para o Hibernate criar os objetos
	public Horario(){
			
	}
	
	// OS DIAS DA SEMANA
	// segunda-feira eh 2
	// terça eh 3
	// quarta eh 4
	// quinta eh 5
	// sexta eh 6
	
	// OS HORARIOS DE AULA
	// 7,8,10,12,14,16,18,20
	
	
	
	public Horario(int diaDaSemana, int horarioDeInicioDaAula){
		this.diaDaSemana = diaDaSemana;
		this.horarioDeInicioDaAUla = horarioDeInicioDaAula;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(int diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public int getHorarioDeInicioDaAUla() {
		return horarioDeInicioDaAUla;
	}

	public void setHorarioDeInicioDaAUla(int horarioDeInicioDaAUla) {
		this.horarioDeInicioDaAUla = horarioDeInicioDaAUla;
	}
	
	


}
