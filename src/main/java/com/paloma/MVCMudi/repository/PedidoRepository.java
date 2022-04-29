package com.paloma.MVCMudi.repository;

import com.paloma.MVCMudi.models.Pedido;
import com.paloma.MVCMudi.models.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatus(StatusPedido status);
}
