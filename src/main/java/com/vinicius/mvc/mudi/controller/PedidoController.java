package com.vinicius.mvc.mudi.controller;

import com.vinicius.mvc.mudi.dto.RequisicaoNovoPedido;
import com.vinicius.mvc.mudi.model.Pedido;
import com.vinicius.mvc.mudi.reposity.PedidosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidosRepository pedidosRepository;

    @GetMapping("formulario")
    public String  formulario(RequisicaoNovoPedido requisicao) {

        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
        if (result.hasErrors()) {
            return "pedido/formulario";
        }
        Pedido pedido = requisicao.toPedido();

        pedidosRepository.save(pedido);
        return "pedido/formulario";
    }
}
