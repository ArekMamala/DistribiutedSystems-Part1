//Arkadiusz Mamala
//G00349088 part 2 DS

package com.Api;

import com.codahale.metrics.health.HealthCheck;

public class ExampleHealthCheck extends HealthCheck {
	
	@Override
	protected Result check() throws Exception {
        return Result.healthy();
	}
}


