package com.vinicius.mvc.mudi.reposity;

import com.vinicius.mvc.mudi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedido, Long> {
}
