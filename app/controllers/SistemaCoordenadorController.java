package controllers;

import java.util.*;
import models.*;
import models.dao.*;
import play.*;
import play.mvc.*;
import views.html.*;
import play.db.jpa.Transactional;

public class SistemaCoordenadorController extends Controller {
	
	// INICIO DA DECLARACAO DE VARIAVEIS
	private static GenericDAO dao = new GenericDAO();
	
	// FIM DA DECLARACAO DE VARIAVEIS
	
	private static List<Disciplina> retornaDisciplinasCadastradas(){
		return dao.findAllByClass(Disciplina.class);
	}
	
	@Transactional
	public static Result sistemaCoordenador() {
		AuxiliadorDeHorario auxiliador = new AuxiliadorDeHorario(retornaDisciplinasCadastradas());
		return ok(sistemaCoordenador.render(auxiliador));
    }
	
	@Transactional	
	public static Result listDisciplinas() {
        return ok(listDisciplinas.render(retornaDisciplinasCadastradas()));
    }
	
	// vou mandar pra view apenas aquelas que não estão atualmente no horario
	@Transactional	
	public static Result addDisciplinasAoHorario() {
		AuxiliadorDeHorario auxiliador = new AuxiliadorDeHorario(retornaDisciplinasCadastradas());
        return ok(addDisciplina.render(retornaDisciplinasCadastradas()));
    }
	
	@Transactional	
	public static Result novaDisciplina() {
        return ok(newdisciplina.render("Your new application is ready."));
    }

}

