package com.vinicius.mvc.mudi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.mvc.mudi.dto.RequisicaoNovaOferta;
import com.vinicius.mvc.mudi.model.Oferta;
import com.vinicius.mvc.mudi.model.Pedido;
import com.vinicius.mvc.mudi.reposity.PedidosRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

    @Autowired
    private PedidosRepository pedidosRepository;

    @PostMapping
    public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {
        Optional<Pedido> pedidoBuscado = pedidosRepository.findById(requisicao.getPedidoId());
        if (!pedidoBuscado.isPresent()) {
            return null;
        }
        Pedido pedido = pedidoBuscado.get();

        Oferta nova = requisicao.toOferta();

        nova.setPedido(pedido);
        pedido.getOfertas().add(nova);

        pedidosRepository.save(pedido);

        return nova;
    }
}
