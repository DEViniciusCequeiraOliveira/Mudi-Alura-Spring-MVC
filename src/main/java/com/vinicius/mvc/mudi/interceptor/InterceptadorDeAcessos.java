package com.vinicius.mvc.mudi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InterceptadorDeAcessos implements HandlerInterceptor {

    public static List<Acesso> acessos = new ArrayList<Acesso>();

    public static class Acesso {
        private String path;
        private LocalDateTime data;
        private Duration duracao;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public LocalDateTime getData() {
            return data;
        }

        public void setData(LocalDateTime data) {
            this.data = data;
        }

        public Duration getDuracao() {
            return duracao;
        }

        public void setDuracao(Duration duracao) {
            this.duracao = duracao;
        }

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Acesso acesso = new Acesso();
        acesso.path = request.getRequestURI();
        acesso.data = LocalDateTime.now();

        request.setAttribute("acesso", acesso);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @org.springframework.lang.Nullable Exception ex) throws Exception {

        Acesso acesso = (Acesso) request.getAttribute("acesso");
        acesso.duracao = Duration.between(acesso.data, LocalDateTime.now());
        acessos.add(acesso);
    }

}
