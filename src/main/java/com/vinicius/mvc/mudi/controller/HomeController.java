package com.vinicius.mvc.mudi.controller;

import com.vinicius.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto("Java efetivo: as melhores práticas para a plataforma Java");
        pedido.setUrlProduto("https://www.amazon.com.br/Java-Efetivo-Melhores-Pr%C3%A1ticas-Plataforma/dp/8550804622/ref=sr_1_1?keywords=java+efetivo&qid=1674320692&sprefix=java+%2Caps%2C235&sr=8-1");
        pedido.setDescricao("O Guia Definitivo das Melhores Práticas com Java ― Atualizado para o Java 7, 8 e 9 Desde a publicação anterior de Java Efetivo, após o lançamento da versão 6, o Java mudou radicalmente.");
        pedido.setUrlImagem("https://m.media-amazon.com/images/I/51TLbX9OSnL._SX352_BO1,204,203,200_.jpg");
        List<Pedido> listaDePedidos = new ArrayList<>();
        listaDePedidos.add(pedido);

        model.addAttribute("listaPedidos",listaDePedidos);
        return "home";
    }
}
