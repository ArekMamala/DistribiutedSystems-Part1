//Arkadiusz Mamala
//G00349088 part 2 DS

package com.Api;

//imports
import com.Api.*;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class UserApiApplication extends Application<UserApiConfig> {

	 //main method - throws exception
	public static void main(String[] args) throws Exception {
	        new UserApiApplication().run(args);
	    }
	
	//run method
	@Override
	public void run(UserApiConfig configuration, Environment environment) throws Exception {
	
		final ExampleHealthCheck healthCheck = new ExampleHealthCheck();
		final UserApiResources resource = new UserApiResources();
		environment.healthChecks().register("example", healthCheck);
	    environment.jersey().register(resource);
	}
}
