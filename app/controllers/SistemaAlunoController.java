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
	// FIM DA DECLARACAO DE VARIAVEIS
	
	private static List<Disciplina> retornaDisciplinasCadastradas(){
		return dao.findAllByClass(Disciplina.class);
	}	
	
	@Transactional
	public static Result indicarIntencaoDeMatricula(Long id){
		
		return ok(listDisciplinasAluno.render(retornaDisciplinasCadastradas()));
	}
	
	@Transactional
	public static Result irParaTelaDeIntencaoDeMatricula(){
		
		return ok(listDisciplinasAluno.render(retornaDisciplinasCadastradas()));
	}
	
	
	
	
}

