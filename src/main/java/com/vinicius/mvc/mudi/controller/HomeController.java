package com.vinicius.mvc.mudi.controller;

import com.vinicius.mvc.mudi.model.Pedido;
import com.vinicius.mvc.mudi.model.StatusPedido;
import com.vinicius.mvc.mudi.reposity.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private PedidosRepository pedidosRepository;

    @GetMapping()
    public String home(Model model) {

        Sort sort = Sort.by("dataDaEntrega").ascending();
        PageRequest paginacao = PageRequest.of(0, 1, sort);

        List<Pedido> listaDePedidos = pedidosRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
        model.addAttribute("listaPedidos", listaDePedidos);
        return "home";
    }
}
