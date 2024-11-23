package br.com.gs.Energy.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(

        info = @Info(contact = @Contact(name = "Igor", email = "rm95003@fiap.com.br", url =
                "http://localhost:8080/login"),
                description = "Projeto desenvolvido para o gerenciamento de energia eolica e paineis solares",
                title = "Global energy MVC",
                version = "1.0",
                license = @License(name = ""),
                termsOfService = "Termos"
        ),
        servers = {
                @Server(description = "Dev Env", url = "http://localhost:8080"),
                @Server(description = "Prod Env", url = "http://fiapblog.com.br")
        }

            
)

@SecurityScheme(
        name="bearedJWT",
        description = "Autenticação básica JWT",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
    
}
