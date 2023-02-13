package br.com.igor.Itens.endpointsPort;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm;

public class toma {
    public static void main(String[] args) {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
	  encoders.put("pbkdf2", new Pbkdf2PasswordEncoder
      ("static-salt", 8, 185000, SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256));
	  DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
	  passwordEncoder.setDefaultPasswordEncoderForMatches(new Pbkdf2PasswordEncoder("", 8, 185000, SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256));
	  
	  String result = passwordEncoder.encode("");
	  System.out.println("My hash " + result);
    }
    
}
