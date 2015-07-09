package controllers;

import java.util.List;

import models.*;
import models.dao.*;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;


public class Application extends Controller {
    private static final GenericDAO DAO = new GenericDAO();


    @Transactional
    public static Result login() {
    	return ok(login.render("Your new application is ready."));
    }

	private static List<Usuario> retornaUsuariosCadastrados(){
		return DAO.findAllByClass(Usuario.class);
	}
    
    public static Result contato() {
        return ok(contato.render("Your new application is ready."));
    }    
  
	
	public static Result newdisciplina() {
        return ok(newdisciplina.render("Your new application is ready."));
    }

	public static Result listDisciplinas() {
        return ok(listDisciplinas.render("Your new application is ready."));
    }
}


