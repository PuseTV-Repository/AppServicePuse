/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ApiAppv2.Controllers;

import com.example.ApiAppv2.Controllers.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Consultar la base de datos para verificar el usuario y contraseña
        String query = "SELECT COUNT(*) FROM USUARIO WHERE vc_usuario = ? AND vc_contraseña = ?";
        int count = jdbcTemplate.queryForObject(query, Integer.class, username, password);

        if (count > 0) {
            return new ApiResponse(true, "Inicio de sesión exitoso");
        } else {
            return new ApiResponse(false, "Credenciales inválidas");
        }
    }

    public static class LoginRequest {

        private String username;
        private String password;

        // Constructor, getters y setters
        public LoginRequest() {
        }

        public LoginRequest(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // Getters y setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
