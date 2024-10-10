package com.sigap.SIGAP.authentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
/*@PreAuthorize("dennyAll()")*/
public class TestAuthController {

  /*  @GetMapping("/hello")
    @PreAuthorize("permitAll")
    public String hello(){
        return"Hello World";
    }

    @GetMapping("/hello-secured")
    @PreAuthorize("hasAuthority('READ')")
    public String helloSecured(){
        return"Hello World Secured";
    }
    @GetMapping("/hello-secured2")
    @PreAuthorize("hasAuthority('CREATE')")
    public String helloSecured2(){
        return"Hello World Secured2";
    }*/

    @GetMapping("/get")
    public String helloGet(){
        return "Hello World - GET";
    }

    @PostMapping("/post")
    public String helloPost(){
        return "Hello World - POST";
    }

    @PutMapping("/put")
    public String helloPut(){
        return "Hello World - PUT";
    }

    @DeleteMapping("/delete")
    public String helloDelete(){
        return "Hello World - DELETE";
    }

    @PatchMapping("/patch")
    public String helloPatch(){
        return "Hello World - PATCH";
    }
}