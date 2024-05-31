package com.apixcloud.courses.spring;

import org.springdoc.core.customizers.OpenApiBuilderCustomizer;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import io.swagger.v3.core.util.OpenAPI31Deserializer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;

@OpenAPIDefinition(
    info = @Info(
        title = "Courses API",
        description = "Our API provides all operations for managment courses, users, roles and permissions",
        termsOfService = "https://apixcloud.com.mx",
        contact = @Contact(
            name = "Ricardo Yañez",
            email = "yanezv.ricardo@gmail.com"
        ),
        license = @License(
            name = "MIT License",
            url = "http://www.opensource.org/licenses/mit-license.php"
        ),
        version = "1.0.0"
    ),
    servers = { 
        @Server(
            description = "DEV-SERVER",
            url = "https://localhost:8080/api"
        ),
        @Server(
            description = "PROD-SERVER",
            url = "https://apixcloud.com.mx/api"
        )
    }, 
    security = @SecurityRequirement(
        name = "Security Token"
    )
)
@SecurityScheme(
        name = "Security Token",
        description = "Access Token for consume my API",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION, 
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer", 
        bearerFormat = "JWT"
)
@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenApiCustomiser customGlobalHeaders() {
        return openApi -> openApi.getPaths().values().forEach(pathItem -> 
            pathItem.readOperations().forEach(operation -> {
                Parameter acceptHeader = new Parameter()
                        .in("header")
                        .schema(new StringSchema()._default("application/json"))
                        .name("accept")
                        .description("Accept header")
                        .required(true);
                operation.addParametersItem(acceptHeader);
            })
        );
    }
}
