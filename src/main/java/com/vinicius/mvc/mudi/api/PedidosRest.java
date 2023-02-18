package com.vinicius.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.mvc.mudi.model.Pedido;
import com.vinicius.mvc.mudi.model.StatusPedido;
import com.vinicius.mvc.mudi.reposity.PedidosRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

    @Autowired
    public PedidosRepository pedidosRepository;

    @GetMapping("aguardando")
    public List<Pedido> getPeidosAguardandoOfertas() {
        Sort sort = Sort.by("id").descending();
        PageRequest paginacao = PageRequest.of(0, 10, sort);

        return pedidosRepository.findByStatus(StatusPedido.AGUARDANDO, paginacao);
    }
}
