package com.customer.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Hidden
@RestController
public class DocsRedirection {

    @GetMapping("/")
    public String redirectToDocs(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html?url=/v3/api-docs");
        return "";
    }
}
