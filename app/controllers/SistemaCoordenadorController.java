package controllers;

import static play.data.Form.form;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import models.Disciplina;
import models.dao.*;

import play.*;
import play.mvc.*;

import views.html.*;


import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

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
