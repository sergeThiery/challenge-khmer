package com.challenge.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
//@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter{
//	  public static final String[] WEB_JAR_RESOURCE_PATTERNS = {"css/", "images/", "lib/", "swagger-ui.js"};
//	  public static final String WEB_JAR_RESOURCE_LOCATION = "classpath:META-INF/resources/";
//	  public static final String WEB_JAR_VIEW_RESOLVER_PREFIX = "classpath:/resources/";
//	  public static final String WEB_JAR_VIEW_RESOLVER_SUFFIX = ".jsp";
//	
//	 @Override
//	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	        registry.addResourceHandler(WEB_JAR_RESOURCE_PATTERNS)
//	                .addResourceLocations(WEB_JAR_RESOURCE_LOCATION).setCachePeriod(0);
//	    }
//
//	    @Bean
//	    public InternalResourceViewResolver getInternalResourceViewResolver() {
//	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//	        resolver.setPrefix(WEB_JAR_VIEW_RESOLVER_PREFIX);
//	        resolver.setSuffix(WEB_JAR_VIEW_RESOLVER_SUFFIX);
//	        return resolver;
//	    }
//
//	    @Override
//	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//	        configurer.enable();
//	    }
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	    registry.addResourceHandler("swagger-ui.html")
//	            .addResourceLocations("classpath:/META-INF/resources/");
//
//	    registry.addResourceHandler("/webjars/**")
//	            .addResourceLocations("classpath:/META-INF/resources/webjars/");
//	}
//	
//	@Bean
//	  public Docket petApi() {
//	    return new Docket(DocumentationType.SWAGGER_2)
//	        .select()
//	          .apis(RequestHandlerSelectors.any())
//	          .paths(PathSelectors.any())
//	          .build()
//	        .pathMapping("/")
//	        .directModelSubstitute(LocalDate.class,
//	            String.class)
//	        .genericModelSubstitutes(ResponseEntity.class);
//	  }

}