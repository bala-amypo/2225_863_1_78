@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        .authorizeHttpRequests(auth -> auth
            // allow auth endpoints
            .requestMatchers("/auth/**").permitAll()

            // allow swagger
            .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()

            // 🔥 THIS IS THE IMPORTANT LINE
            .requestMatchers("/api/**").permitAll()

            .anyRequest().authenticated()
        )
        .addFilterBefore(
            jwtAuthenticationFilter,
            UsernamePasswordAuthenticationFilter.class
        );

    return http.build();
}
