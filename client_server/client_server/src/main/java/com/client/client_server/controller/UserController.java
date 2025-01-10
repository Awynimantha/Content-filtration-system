package com.client.client_server.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/user", produces = "application/json")
//fix
@CrossOrigin
public class UserController{
     
}
