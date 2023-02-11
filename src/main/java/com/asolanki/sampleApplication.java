package com.asolanki;

import com.asolanki.health.TemplateHealthCheck;
import com.asolanki.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class sampleApplication extends Application<sampleConfiguration> {

    public static void main(final String[] args) throws Exception {
        new sampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "sample";
    }

    @Override
    public void initialize(final Bootstrap<sampleConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final sampleConfiguration configuration,
                    final Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.jersey().register(resource);
        environment.healthChecks().register("template", healthCheck);
    }

}
