package controllers;

import java.util.*;
import models.*;
import models.dao.*;
import play.*;
import play.mvc.*;
import views.html.*;
import play.db.jpa.Transactional;
import play.data.Form;
import static play.data.Form.form;


public class SistemaAlunoController extends Controller {
	
	// INICIO DA DECLARACAO DE VARIAVEIS
	private static GenericDAO dao = new GenericDAO();
	private static Form<Disciplina> form = Form.form(Disciplina.class);
	private static Form<Problema> formProblema = Form.form(Problema.class);
	// FIM DA DECLARACAO DE VARIAVEIS
	
	private static List<Disciplina> retornaDisciplinasCadastradas(){
		return dao.findAllByClass(Disciplina.class);
	}	
	
	private static List<Usuario> retornaUsuariosCadastradas(){
		return dao.findAllByClass(Usuario.class);
	}
	
	private static List<IntencaoDeMatricula> retornaIndicacoesCadastradas(){
		return dao.findAllByClass(IntencaoDeMatricula.class);
	}
	
	private static Usuario retornaUsuario(String email){
		List<Usuario> todosUsuarios = dao.findAllByClass(Usuario.class);
		for (Usuario u : todosUsuarios){
			if (u.getEmail().equals(email)){
				return u;
			}
		}
		return null;
	}
	
	@Transactional
	public static Result indicarIntencaoDeMatricula(Long id, String email){
		List<IntencaoDeMatricula> intencoes = retornaIndicacoesCadastradas();
		for (IntencaoDeMatricula intencao: intencoes){
			if (intencao.getEmailDoUsuario().equals(email)){
				intencao.addDisciplina(SistemaCoordenadorController.retornaDisciplina(id));
				dao.merge(intencao);
				dao.flush();
				List<Disciplina> disciplinasCadastradas2 = retornaDisciplinasCadastradas();
				disciplinasCadastradas2.removeAll(intencao.getDisciplinas());
				return ok(listDisciplinasAluno.render(disciplinasCadastradas2, intencao.getDisciplinas(), email));
				
			}
		}
		IntencaoDeMatricula intencao2 = new IntencaoDeMatricula(email);
		intencao2.addDisciplina(SistemaCoordenadorController.retornaDisciplina(id));
		dao.persist(intencao2);
		dao.flush();
		List<Disciplina> disciplinasCadastradas = retornaDisciplinasCadastradas();
		disciplinasCadastradas.removeAll(intencao2.getDisciplinas());
		return ok(listDisciplinasAluno.render(disciplinasCadastradas, intencao2.getDisciplinas(), email));
	}
	
	@Transactional
	public static Result removerIntencaoDeMatricula(Long id, String email){
		List<IntencaoDeMatricula> intencoes = retornaIndicacoesCadastradas();
		for (IntencaoDeMatricula intencao: intencoes){
			if (intencao.getEmailDoUsuario().equals(email)){
				intencao.removeDisciplina(SistemaCoordenadorController.retornaDisciplina(id));
				dao.merge(intencao);
				dao.flush();
				List<Disciplina> disciplinasCadastradas2 = retornaDisciplinasCadastradas();
				disciplinasCadastradas2.removeAll(intencao.getDisciplinas());
				return ok(listDisciplinasAluno.render(disciplinasCadastradas2, intencao.getDisciplinas(), email));
				
			}
		}
		IntencaoDeMatricula intencao2 = new IntencaoDeMatricula(email);
		intencao2.addDisciplina(SistemaCoordenadorController.retornaDisciplina(id));
		dao.persist(intencao2);
		dao.flush();
		List<Disciplina> disciplinasCadastradas = retornaDisciplinasCadastradas();
		disciplinasCadastradas.removeAll(intencao2.getDisciplinas());
		return ok(listDisciplinasAluno.render(disciplinasCadastradas, intencao2.getDisciplinas(), email));
	}
	
	@Transactional
	public static Result irParaTelaDeIntencaoDeMatricula(String email){
		List<IntencaoDeMatricula> intencoes = retornaIndicacoesCadastradas();
		IntencaoDeMatricula intencao2 = new IntencaoDeMatricula(email);
		for (IntencaoDeMatricula intencao: intencoes){
			if (intencao.getEmailDoUsuario().equals(email)){
				intencao2 = intencao;
				
			}
		}
		List<Disciplina> disciplinasCadastradas = retornaDisciplinasCadastradas();
		disciplinasCadastradas.removeAll(intencao2.getDisciplinas());
		return ok(listDisciplinasAluno.render(disciplinasCadastradas, intencao2.getDisciplinas(), email));
	}
	
	@Transactional
	public static Result indicarProblema(Long id, String email){
		Form<Problema> formPreenchido = formProblema.bindFromRequest();

		Disciplina disc = SistemaCoordenadorController.retornaDisciplina(id);
		Usuario user = retornaUsuario(email);

		if (formPreenchido.hasErrors()) {
			flash("error", "Aconteceu um erro na indicação do problema!");
			return Application.sistemaAluno(email);
		} else {
			String problemaString = form().bindFromRequest().get("problema");
			if (problemaString.length() == 0) {
				flash("error", "Você não digitou nenhum problema!");
				return Application.sistemaAluno(email);
			}

			Problema problema = new Problema(problemaString, disc.getNome(), user.getEmail());			


			dao.persist(problema);

			dao.flush();


			flash("success", "Indicação de problema salvo com sucesso!");
			return Application.sistemaAluno(email);


		}
		
	}

	
	
}

