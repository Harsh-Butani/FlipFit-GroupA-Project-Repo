package com.flipkart.application;
import com.flipkart.controller.AdminController;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.core.Configuration;

public class GymFlipFitApplication extends Application<Configuration>
{
	@Override
	public void run(Configuration configuration, Environment environment) throws Exception {
		environment.jersey().register(new AdminController());
	}
	public static void main ( String[] args ) throws Exception
	{
		new GymFlipFitApplication().run(args);
	}
}