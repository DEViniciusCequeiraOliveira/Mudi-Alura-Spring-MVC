package com.vinicius.mvc.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.mvc.mudi.interceptor.InterceptadorDeAcessos;
import com.vinicius.mvc.mudi.interceptor.InterceptadorDeAcessos.Acesso;

@RequestMapping("/api/acessos")
@RestController
public class AcessosRest {

    @GetMapping
    public List<Acesso> getAcessos() {
        return InterceptadorDeAcessos.acessos;
    }

}
