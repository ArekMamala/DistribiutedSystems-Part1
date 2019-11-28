package com.Api;

import com.Api.*;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class UserApiApplication extends Application<UserApiConfig> {

	 
	public static void main(String[] args) throws Exception {
	        new UserApiApplication().run(args);
	    }
	
	
	@Override
	public void run(UserApiConfig configuration, Environment environment) throws Exception {
	
		final ExampleHealthCheck healthCheck = new ExampleHealthCheck();
		final UserApiResources resource = new UserApiResources();
		environment.healthChecks().register("example", healthCheck);
	    environment.jersey().register(resource);
	}
}
