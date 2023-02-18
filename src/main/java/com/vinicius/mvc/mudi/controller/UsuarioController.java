package com.vinicius.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vinicius.mvc.mudi.model.Pedido;
import com.vinicius.mvc.mudi.model.StatusPedido;
import com.vinicius.mvc.mudi.reposity.PedidosRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private PedidosRepository pedidosRepository;

    @GetMapping("pedido")
    public String home(Model model, Principal principal) {
        List<Pedido> listaDePedidos = pedidosRepository.findAllByUsuario(principal.getName());
        model.addAttribute("listaPedidos", listaDePedidos);
        return "usuario/home";
    }

    @GetMapping("pedido/{status}")
    public String porStatus(@PathVariable("status") String status, Model model, Principal principal) {
        List<Pedido> listaDePedidos = pedidosRepository.findByStatusAndUsuario(StatusPedido.valueOf(status.toUpperCase()),principal.getName());
        model.addAttribute("listaPedidos", listaDePedidos);
        model.addAttribute("status", status);
        return "usuario/home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:usuario/home";
    }
}