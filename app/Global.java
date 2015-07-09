import models.*;
import play.*;

import models.dao.GenericDAO;
import play.db.jpa.JPA;

public class Global extends GlobalSettings {
	private static GenericDAO DAO = new GenericDAO();

	@Override
	public void onStart(Application app) {
		Logger.info("Aplicação inicializada...");

		JPA.withTransaction(new play.libs.F.Callback0() {
			@Override
			public void invoke() throws Throwable {
				// Eh aqui que vamos adicionar as disciplinas, todas elas!
				
				// comecando pelas disciplinas da segunda de 8h
				Horario Segunda8h = new Horario(2, 8);
				Horario Quarta10h = new Horario(4, 10);
				Disciplina si2 = new Disciplina("Sistemas da Informação II", "Franklin", "CD105", "SI2");
				si2.addNosHorariosDaDisciplina(Segunda8h);
				si2.addNosHorariosDaDisciplina(Quarta10h);
				si2.mostrarNoHorario();
				DAO.persist(si2);
				DAO.flush();
				
				Horario Terca10h = new Horario(3, 10);
				Horario Sexta8h = new Horario(6, 8);
				Disciplina oac = new Disciplina("Organização e Arquiteturas de Computadores", "Joseana", "CAA404", "OAC");
				oac.addNosHorariosDaDisciplina(Sexta8h);
				oac.addNosHorariosDaDisciplina(Terca10h);
				oac.mostrarNoHorario();
				DAO.persist(oac);
				DAO.flush();
				
				
			}
		});
	}
}

