package com.vinicius.mvc.mudi.reposity;

import com.vinicius.mvc.mudi.model.Pedido;
import com.vinicius.mvc.mudi.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidosRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatus(StatusPedido status);
}
