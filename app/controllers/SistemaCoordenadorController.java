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
		return ok(sistemaCoordenador.render(retornaDisciplinasCadastradas()));
    }
	
	@Transactional	
	public static Result listDisciplinas() {
        return ok(listDisciplinas.render(retornaDisciplinasCadastradas()));
    }
}