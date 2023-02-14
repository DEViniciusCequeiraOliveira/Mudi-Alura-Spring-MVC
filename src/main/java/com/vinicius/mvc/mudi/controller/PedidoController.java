package com.vinicius.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vinicius.mvc.mudi.dto.RequisicaoNovoPedido;
import com.vinicius.mvc.mudi.model.Pedido;
import com.vinicius.mvc.mudi.model.User;
import com.vinicius.mvc.mudi.reposity.PedidosRepository;
import com.vinicius.mvc.mudi.reposity.UserRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidosRepository pedidosRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicao) {

        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
        if (result.hasErrors()) {
            return "pedido/formulario";
        }

        Pedido pedido = requisicao.toPedido();

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);

        pedido.setUser(user);
        pedidosRepository.save(pedido);
        return "redirect:/home";
    }
}
