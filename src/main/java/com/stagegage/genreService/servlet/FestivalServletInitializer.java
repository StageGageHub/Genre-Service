package com.stagegage.genreService.servlet;

import com.stagegage.genreService.Main;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Scott on 7/19/14.
 *
 * @author Scott Hendrickson
 */
@EnableAutoConfiguration
@ComponentScan
public class FestivalServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }
}
