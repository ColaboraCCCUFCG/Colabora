package controllers;

import models.Anuncio;
import models.dao.GenericDAO;
import play.Logger;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.util.List;

public class Application extends Controller {
    private static final GenericDAO DAO = new GenericDAO();
    private static Form<Anuncio> form = Form.form(Anuncio.class);

    @Transactional
    public static Result login() {
    	return ok(login.render("Your new application is ready."));
    }

  /*  @Transactional
    public static Result anuncios() {
        //List<Anuncio> resultado = DAO.findAllByClass(Anuncio.class);

        return ok(main.render("teste"));
    }
*/
    /*@Transactional
    public static Result novoAnuncio() {
        Form<Anuncio> formPreenchido = form.bindFromRequest();

        if (formPreenchido.hasErrors()) {
            List<Anuncio> resultado = DAO.findAllByClass(Anuncio.class);

            return badRequest(index.render(resultado));
        } else {
            Anuncio newAnuncio = formPreenchido.get();
            Logger.debug(formPreenchido.data().toString());

            DAO.persist(newAnuncio);
            DAO.flush();

            return anuncios();
        }
    }*/
    
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


