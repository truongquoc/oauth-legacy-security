//package com.example.oauthlegacysecurity.security;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//
//@Configuration
//@EnableAuthorizationServer
//public class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {
//    private final AuthenticationManager authenticationManager;
//    private final PasswordEncoder passwordEncoder;
//    private final UserService UserService;
//
//
//    @Value("${jwt.clientId:glee-o-meter}")
//    private String clientId;
//
//    @Value("${jwt.client-secret:secret}")
//    private String clientSecret;
//
//    @Value("${jwt.signing-key:123}")
//    private String jwtSigningKey;
//
//    @Value("${jwt.accessTokenValidititySeconds:43200}") // 12 hours
//    private int accessTokenValiditySeconds;
//
//    @Value("${jwt.authorizedGrantTypes:password,authorization_code,refresh_token}")
//    private String[] authorizedGrantTypes;
//
//    @Value("${jwt.refreshTokenValiditySeconds:2592000}") // 30 days
//    private int refreshTokenValiditySeconds;
//
//
//
//    public OAuthConfiguration(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, com.example.oauthlegacysecurity.security.UserService userService) {
//        this.authenticationManager = authenticationManager;
//        this.passwordEncoder = passwordEncoder;
//        UserService = userService;
//    }
//
//
//    @Override
//    public void configure(org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient(clientId)
//                .secret(passwordEncoder.encode(clientSecret))
//                .authorizedGrantTypes(authorizedGrantTypes)
//                .scopes("read", "write")
//                .accessTokenValiditySeconds(accessTokenValiditySeconds)
//                .refreshTokenValiditySeconds(refreshTokenValiditySeconds);
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.accessTokenConverter(new JwtAccessTokenConverter())
//                .userDetailsService(UserService)
//                .authenticationManager(authenticationManager);
//    }
//}
