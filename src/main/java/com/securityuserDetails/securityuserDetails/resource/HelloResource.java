package com.securityuserDetails.securityuserDetails.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class HelloResource {

    @GetMapping("/hello")
    public String hello(){
        return "Hi Welcome ! !";
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    //that was called spring pre authorization
    @GetMapping("/secured/hello")
    public String securedHello(){
        return "Hi Welcome to security! !";
    }

}
