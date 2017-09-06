package spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/newPerson").setViewName("newPerson");
        registry.addViewController("/newKnowledge").setViewName("newKnowledge");
        registry.addViewController("/listKnowledges").setViewName("listKnowledges");
        registry.addViewController("/listPeople").setViewName("listPeople");
    }

}
