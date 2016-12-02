import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.libs.Yaml;

import java.util.List;

import com.avaje.ebean.Ebean;

import models.User;

@SuppressWarnings("deprecation")
public class Bootstrap extends GlobalSettings {

	@Override
	public void onStart(Application app) {
		// Check if the database is empty
		Logger.info("##Debut Bootstrap");
		if (User.count() == 0) {
			List<Object> l = (List<Object>) Yaml.load("/public/ydata.yml");
			Logger.info("" + l.size());
			Ebean.save(l);
		}

		Logger.info("##Fin Bootstrap");
	}
}
