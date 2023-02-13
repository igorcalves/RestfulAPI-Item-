package br.com.igor.Itens.endpointsPort.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.igor.Itens.endpointsPort.Repositories.UserRepository;
import br.com.igor.Itens.endpointsPort.Security.JwtTokenProvider;
import br.com.igor.Itens.endpointsPort.dataVO.security.AccountCredentialsVO;
import br.com.igor.Itens.endpointsPort.dataVO.security.TokenVO;

 @Service
 public class AuthServices {
     
     @Autowired
     private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;
    
    @SuppressWarnings("rawtypes")
    public ResponseEntity signin (AccountCredentialsVO data){
        try {
            var username = data.getUsername();

            var password = data.getPassword();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            
            var user = repository.findByUserName(username);
            var tokenResponse = new TokenVO();
            if(user != null){
                tokenResponse = tokenProvider.createAcessToken(username,user.getRoles());
            }else{
                throw new UsernameNotFoundException("Username " + username + "not found!");
            }

            return ResponseEntity.ok(tokenResponse);
       

        } catch (Exception e) {
            throw new BadCredentialsException("invalid username/password supplied");
        }
    }
}
