package spark.java.heroku.example.SparkJavaHerokuExample;

import static spark.Spark.get;
import static spark.SparkBase.port;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(final String[] args) {
		port(getHerokuAssignedPort());
		get("/", (req, res) -> "Hello Heroku World");
	}

	static int getHerokuAssignedPort() {
		final ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get("PORT") != null) {
			return Integer.parseInt(processBuilder.environment().get("PORT"));
		}
		return 4567; // return default port if heroku-port isn't set (i.e. on localhost)
	}
}
