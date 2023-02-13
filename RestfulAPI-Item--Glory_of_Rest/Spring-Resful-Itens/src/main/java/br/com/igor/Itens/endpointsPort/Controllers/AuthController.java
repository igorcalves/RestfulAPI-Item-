package br.com.igor.Itens.endpointsPort.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 import br.com.igor.Itens.endpointsPort.Services.AuthServices;
 import br.com.igor.Itens.endpointsPort.dataVO.security.AccountCredentialsVO;
 import io.swagger.v3.oas.annotations.Operation;
 import io.swagger.v3.oas.annotations.parameters.RequestBody;
 import io.swagger.v3.oas.annotations.tags.Tag;

 @Tag(name = "Authentication EndPoint")
@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    AuthServices services;

    @SuppressWarnings("rawtypes")
    @Operation(summary = "Authenticate a user and return a token")
    @PostMapping("signin")
    public ResponseEntity signin(@RequestBody AccountCredentialsVO data){
        if (checkIFParamIsNotNull(data)) return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
        
        var token = services.signin(data);
        if (token == null)return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
        return token;
    }

    private boolean checkIFParamIsNotNull(AccountCredentialsVO data) {
        return data == null || data.getUsername() == null || data.getUsername().isBlank() 
		|| data.getPassword() == null || data.getPassword().isBlank();
	}
}

