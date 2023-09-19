package com.flipkart.application;
import com.flipkart.controller.AdminController;
import com.flipkart.controller.CustomerController;
import com.flipkart.controller.GymOwnerController;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.core.Configuration;

public class GymFlipFitApplication extends Application<Configuration>
{
	@Override
	public void run(Configuration configuration, Environment environment) throws Exception {
		environment.jersey().register(new AdminController());
		environment.jersey().register(new GymOwnerController());
		environment.jersey().register(new CustomerController());
	}
	public static void main ( String[] args ) throws Exception
	{
		new GymFlipFitApplication().run(args);
	}
}