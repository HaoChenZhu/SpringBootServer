package es.nebrija.SpringBootServer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Sets;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

@Configuration
public class SpringFoxConfig {

    private static final String SWAGGER_LICENSE_VERSION = "1.0.0";
    private static final String SWAGGER_LICENSE_URL = "https://www.nebrija.com/";
    private static final String SWAGGER_LICENSE = "Aviso Legal";
    private static final String SWAGGER_TITLE = "SERVICIO PRODUCTOS API";
    private static final String SWAGGER_SUBTITLE = "SERVIDOR PRODUCTOS APLICATTION";
    private static final String CONTROLLER_BASE_PACKAGE = "es.nebrija.SpringBootServer";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(SWAGGER_TITLE).description(SWAGGER_SUBTITLE).license(SWAGGER_LICENSE)
                .licenseUrl(SWAGGER_LICENSE_URL).termsOfServiceUrl("").version(SWAGGER_LICENSE_VERSION).build();
    }

    @Bean
    public Docket swaggerSpringfoxDocket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName(SWAGGER_TITLE).protocols(Sets.newHashSet("http"))
                .select().apis(RequestHandlerSelectors.basePackage(CONTROLLER_BASE_PACKAGE))
                .paths(PathSelectors.ant("/**")).build().apiInfo(apiInfo());
    }

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder().docExpansion(DocExpansion.NONE).operationsSorter(OperationsSorter.ALPHA)
                .defaultModelRendering(ModelRendering.EXAMPLE).tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS).build();
    }
}