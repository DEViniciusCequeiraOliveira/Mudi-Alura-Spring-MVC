package com.vinicius.mvc.mudi.controller;

import com.vinicius.mvc.mudi.model.Pedido;
import com.vinicius.mvc.mudi.reposity.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PedidosRepository pedidosRepository;

    @GetMapping("/home")
    public String home(Model model) {
        List<Pedido> listaDePedidos = pedidosRepository.findAll();
        model.addAttribute("listaPedidos",listaDePedidos);
        return "home";
    }
}
