package store.pilsaapp.pilsa_api.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("PilsaApp API Documentation")
                    .version("v0.0.1")
                    .description("This is the API documentation for PilsaApp.")
            )
    }
}