
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
				
				//USUARIOS
				Usuario u1 = new Usuario("isabelly.cavalcante@ccc.ufcg.edu.br", "123", true);
				DAO.persist(u1);
				DAO.flush();
				Usuario u2 = new Usuario("gleyser.bonfim.guimaraes@ccc.ufcg.edu.br", "123", true);
				DAO.persist(u2);
				DAO.flush();
				Usuario u3 = new Usuario("dandara.navarro@ccc.ufcg.edu.br", "123", true);
				DAO.persist(u3);
				DAO.flush();
				Usuario u4 = new Usuario("uian.gorgonio@ccc.ufcg.edu.br", "123", true);
				DAO.persist(u4);
				DAO.flush();
				Usuario u5 = new Usuario("rayff.queiroga@ccc.ufcg.edu.br", "123", true);
				DAO.persist(u5);
				DAO.flush();
				Usuario u6 = new Usuario("francisco.neto@computacao.ufcg.edu.br", "1234", false);
				DAO.persist(u6);
				DAO.flush();
				Usuario u7 = new Usuario("lbmarinho@computacao.ufcg.edu.br", "1234", false);
				DAO.persist(u7);
				DAO.flush();
				
				//HORARIOS
				/*Segunda*/
				/*Horario Segunda7h = new Horario(DiaDaSemana.SEGUNDA, 7);
				Horario Segunda8h = new Horario(DiaDaSemana.SEGUNDA, 8);
				Horario Segunda10h = new Horario(DiaDaSemana.SEGUNDA, 10);
				Horario Segunda12h = new Horario(DiaDaSemana.SEGUNDA, 12);
				Horario Segunda14h = new Horario(DiaDaSemana.SEGUNDA, 14);
				Horario Segunda16h = new Horario(DiaDaSemana.SEGUNDA, 16);
				Horario Segunda18h = new Horario(DiaDaSemana.SEGUNDA, 18);
				Horario Segunda20h = new Horario(DiaDaSemana.SEGUNDA, 20);
				Terça
				Horario Terca7h = new Horario(DiaDaSemana.TERCA, 7);
				Horario Terca8h = new Horario(DiaDaSemana.TERCA, 8);
				Horario Terca10h = new Horario(DiaDaSemana.TERCA, 10);
				Horario Terca12h = new Horario(DiaDaSemana.TERCA, 12);
				Horario Terca14h = new Horario(DiaDaSemana.TERCA, 14);
				Horario Terca16h = new Horario(DiaDaSemana.TERCA, 16);
				Horario Terca18h = new Horario(DiaDaSemana.TERCA, 18);
				Horario Terca20h = new Horario(DiaDaSemana.TERCA, 20);
				Quarta
				Horario Quarta7h = new Horario(DiaDaSemana.QUARTA, 7);
				Horario Quarta8h = new Horario(DiaDaSemana.QUARTA, 8);
				Horario Quarta10h = new Horario(DiaDaSemana.QUARTA, 10);
				Horario Quarta12h = new Horario(DiaDaSemana.QUARTA, 12);
				Horario Quarta14h = new Horario(DiaDaSemana.QUARTA, 14);
				Horario Quarta16h = new Horario(DiaDaSemana.QUARTA, 16);
				Horario Quarta18h = new Horario(DiaDaSemana.QUARTA, 18);
				Horario Quarta20h = new Horario(DiaDaSemana.QUARTA, 20);
				Quinta
				Horario Quinta7h = new Horario(DiaDaSemana.QUINTA, 7);
				Horario Quinta8h = new Horario(DiaDaSemana.QUINTA, 8);
				Horario Quinta10h = new Horario(DiaDaSemana.QUINTA, 10);
				Horario Quinta12h = new Horario(DiaDaSemana.QUINTA, 12);
				Horario Quinta14h = new Horario(DiaDaSemana.QUINTA, 14);
				Horario Quinta16h = new Horario(DiaDaSemana.QUINTA, 16);
				Horario Quinta18h = new Horario(DiaDaSemana.QUINTA, 18);
				Horario Quinta20h = new Horario(DiaDaSemana.QUINTA, 20);
				Sexta
				Horario Sexta7h = new Horario(DiaDaSemana.SEXTA, 7);
				Horario Sexta8h = new Horario(DiaDaSemana.SEXTA, 8);
				Horario Sexta10h = new Horario(DiaDaSemana.SEXTA, 10);
				Horario Sexta12h = new Horario(DiaDaSemana.SEXTA, 12);
				Horario Sexta14h = new Horario(DiaDaSemana.SEXTA, 14);
				Horario Sexta16h = new Horario(DiaDaSemana.SEXTA, 16);
				Horario Sexta18h = new Horario(DiaDaSemana.SEXTA, 18);
				Horario Sexta20h = new Horario(DiaDaSemana.SEXTA, 20);
					
				// Eh aqui que vamos adicionar as disciplinas, todas elas!
				
				// comecando pelas disciplinas da TERCA de 8h
*/				
				Disciplina linear = new Disciplina("ALGEBRA LINEAR I", "Jose Luiz", "CAA102", "linear", 4, "1109049");
				linear.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 14));
				linear.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 16));
				linear.mostrarNoHorario();
				DAO.persist(linear);
				DAO.flush();

				Disciplina eda = new Disciplina("ESTRUTURA DE DADOS E ALGORITMOS", "Campelo", "CD105", "eda", 4, "1411172");
				eda.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 8));
				eda.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 10));
				eda.mostrarNoHorario();
				DAO.persist(eda);
				DAO.flush();

				Disciplina moderna = new Disciplina("FUNDAMENTOS DE FÍSICA MODERNA", "Igo", "CAA104", "moderna", 4, "1108090");
				moderna.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 16));
				moderna.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 14));
				moderna.mostrarNoHorario();
				DAO.persist(moderna);
				DAO.flush();

				Disciplina ginf = new Disciplina("GERÊNCIA DA INFORMAÇÃO", "Carlos Eduardo", "CAA401", "ginf", 4, "1411176");
				ginf.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 10));
				ginf.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 8));
				ginf.mostrarNoHorario();
				DAO.persist(ginf);
				DAO.flush();

				Disciplina leda = new Disciplina("LAB.DE ESTRUTURA DE DADOS E ALGORITMOS", "Adalberto", "LCC2", "leda", 4, "1411179");
				leda.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 8));
				leda.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 10));
				leda.mostrarNoHorario();
				DAO.persist(leda);
				DAO.flush();

				Disciplina prob = new Disciplina("PROBABILIDADE E ESTATISTICA", "Alexsandro", "CAA401", "prob", 4, "1114107");
				prob.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 10));
				prob.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 8));
				prob.mostrarNoHorario();
				DAO.persist(prob);
				DAO.flush();

				Disciplina tct1 = new Disciplina("TEORIA DA COMPUTAÇÃO", "Kyller", "CAA401", "tc-t1", 4, "1411171");
				tct1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 16));
				tct1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 14));
				tct1.mostrarNoHorario();
				DAO.persist(tct1);
				DAO.flush();
				
				Disciplina si2 = new Disciplina("Sistemas da Informação II", "Franklin", "CD105", "SI2", 4, "1411195");
				si2.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 8));
				si2.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 10));
				si2.mostrarNoHorario();
				DAO.persist(si2);
				DAO.flush();
				
				Disciplina oac = new Disciplina("Organização e Arquiteturas de Computadores", "Joseana", "CAA404", "OAC", 4, "1411175");
				oac.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 8));
				oac.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 10));
				oac.mostrarNoHorario();
				DAO.persist(oac);
				DAO.flush();
				
				Disciplina vetorial = new Disciplina("Álgebra vetorial e Geometria Analítica", "Ivaldo", "CAA104", "Vetorial", 4, "1109035");
				vetorial.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 8));
				vetorial.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 10));
				vetorial.mostrarNoHorario();
				DAO.persist(vetorial);
				DAO.flush();
				
				Disciplina calculo1 = new Disciplina("Cálculo Diferencial e Integral", "Alcionio", "CAA102", "calculo1", 4, "1109103");
				calculo1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 14));
				calculo1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 16));
				calculo1.mostrarNoHorario();
				DAO.persist(calculo1);
				DAO.flush();
				
				Disciplina ic = new Disciplina("Introdução a Computação", "Joseana", "CAA405", "ic", 4, "1411174");
				ic.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 8));
				ic.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 10));
				ic.mostrarNoHorario();
				DAO.persist(ic);
				DAO.flush();
				
				Disciplina lp1 = new Disciplina("LABORATÓRIO DE PROGRAMAÇÃO I", "Dalton", "LCC1", "lp1", 4, "1411180");
				lp1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 10));
				lp1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 8));
				lp1.mostrarNoHorario();
				DAO.persist(lp1);
				DAO.flush();
				
				Disciplina lpt = new Disciplina("LEITURA E PRODUCAO DE TEXTOS", "Maria", "BD202", "lpt", 4, "1307151");
				lpt.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 14));
				lpt.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 16));
				lpt.mostrarNoHorario();
				DAO.persist(lpt);
				DAO.flush();
				
				Disciplina p1 = new Disciplina("PROGRAMAÇÃO I", "Jorge", "CD106", "p1", 4, "1411167");
				p1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 8));
				p1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 10));
				p1.mostrarNoHorario();
				DAO.persist(p1);
				DAO.flush();
				
				
				Disciplina calculo2 = new Disciplina("CALCULO DIFERENCIAL E INTEGRAL II", "Amauri", "CAA102", "calculo2", 4, "1109053");
				calculo2.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 8));
				calculo2.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 10));
				// esta comentado para poder aparecer essa disciplina na tela de adicionar disciplinas
				//calculo2.mostrarNoHorario();
				DAO.persist(calculo2);
				DAO.flush();
				
				Disciplina fisicaClassica = new Disciplina("FUNDAMENTOS DE FÍSICA CLÁSSICA", "Alexandre", "CAA403", "fisicaClassica", 4, "1108089");
				fisicaClassica.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 16));
				fisicaClassica.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 16));
				fisicaClassica.mostrarNoHorario();
				DAO.persist(fisicaClassica);
				DAO.flush();
				
				Disciplina lp1t3 = new Disciplina("LABORATÓRIO DE PROGRAMAÇÃO II", "Neto", "LCC1", "lp1-t3", 4, "1411181");
				lp1t3.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 8));
				lp1t3.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 10));
				lp1t3.mostrarNoHorario();
				DAO.persist(lp1t3);
				DAO.flush();
				
				Disciplina matdisct1 = new Disciplina("MATEMÁTICA DISCRETA", "Leandro", "CAA304", "matdisc-t1", 4, "1109113");
				matdisct1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEGUNDA, 10));
				matdisct1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 8));
				matdisct1.mostrarNoHorario();
				DAO.persist(matdisct1);
				DAO.flush();

				Disciplina p2t1 = new Disciplina("PROGRAMAÇÃO II", "Gustavo", "RE10", "p2-t1", 4, "1411168");
				p2t1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUARTA, 8));
				p2t1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.SEXTA, 10));
				p2t1.mostrarNoHorario();
				DAO.persist(p2t1);
				DAO.flush();

				Disciplina grafost1 = new Disciplina("TEORIA DOS GRAFOS", "Patricia", "CD105", "grafos-t1", 2, "1411170");
				grafost1.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 10));
				grafost1.mostrarNoHorario();
				DAO.persist(grafost1);
				DAO.flush();
				
				Disciplina metci = new Disciplina("METODOLOGIA CIENTÍFICA", "Jacques", "DSC", "metci", 4, "1305218");
				metci.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.TERCA, 14));
				metci.addNosHorariosDaDisciplina(new Horario(DiaDaSemana.QUINTA, 16));
				metci.mostrarNoHorario();
				DAO.persist(metci);
				DAO.flush();

				
			}
		});
	}
}

