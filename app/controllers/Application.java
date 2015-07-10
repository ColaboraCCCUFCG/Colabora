package controllers;

import java.util.*;

import models.*;
import models.dao.*;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;


public class Application extends Controller {
    private static final GenericDAO DAO = new GenericDAO();
    private static Form<Usuario> form = Form.form(Usuario.class);
    
    @Transactional
    public static Result login() {
    	List<Usuario> todosUsuarios = DAO.findAllByClass(Usuario.class);
    	Form<Usuario> formPreenchido = form.bindFromRequest();
    	
    	if (formPreenchido.hasErrors()) {
            return badRequest(login.render("Error"));
        } else {
            Usuario login = formPreenchido.get();
            
            for (Usuario usuario : todosUsuarios) {
    			if (usuario.getEmail().equals(login.getEmail()) && usuario.getSenha().equals(login.getSenha())){
    				if (!usuario.getIsAluno()){
    					return SistemaCoordenadorController.sistemaCoordenador();
    				}
    			}
    		}
        }
    	
    	return ok(login.render("Your new application is ready."));
    }

    public static Result contato() {
        return ok(contato.render("Your new application is ready."));
    }    
  
	
	public static Result newdisciplina() {
        return ok(newdisciplina.render("Your new application is ready."));
    }

}


