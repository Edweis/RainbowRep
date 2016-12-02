package controllers;

import play.Logger;
import play.libs.Yaml;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import com.avaje.ebean.Ebean;

import models.Project;
import models.Task;
import models.User;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class Application extends Controller {

	/**
	 * An action that renders an HTML page with a welcome message. The
	 * configuration in the <code>routes</code> file means that this method will
	 * be called when the application receives a <code>GET</code> request with a
	 * path of <code>/</code>.
	 */
	public Result index() {
		if (User.count() == 0) {
			List<Object> l = (List<Object>) Yaml.load("/public/ydata.yml");
			Logger.info("" + l.size());
			for (Object o : l) {
				Ebean.save(o);
			}
		}

		return ok(views.html.index.render(Project.find.all(), Task.find.all()));
	}

}
