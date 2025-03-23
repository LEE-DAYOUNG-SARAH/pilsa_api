package store.pilsaapp.pilsa_api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { requests ->
                requests
                    // Swagger 관련 엔드포인트는 인증 없이 접근 허용
                    .requestMatchers(
                        "/swagger-ui/**",
                        "/v3/api-docs/**"
                    )
                    .permitAll()
                    // 그 외의 모든 요청은 인증 필요
                    .anyRequest()
                    .authenticated()
            }
            .httpBasic(withDefaults())
            .formLogin(withDefaults())

        return http.build()
    }
}