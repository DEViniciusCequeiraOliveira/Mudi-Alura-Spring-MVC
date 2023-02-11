package com.vinicius.mvc.mudi.controller;

import com.vinicius.mvc.mudi.model.Pedido;
import com.vinicius.mvc.mudi.model.StatusPedido;
import com.vinicius.mvc.mudi.reposity.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private PedidosRepository pedidosRepository;

    @GetMapping()
    public String home(Model model) {
        List<Pedido> listaDePedidos = pedidosRepository.findAll();
        model.addAttribute("listaPedidos",listaDePedidos);
        return "home";
    }

    @GetMapping("/{status}")
    public String porStatus(@PathVariable("status") String status, Model model) {
        List<Pedido> listaDePedidos = pedidosRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
        model.addAttribute("listaPedidos",listaDePedidos);
        model.addAttribute("status",status);
        return "home";
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
}
