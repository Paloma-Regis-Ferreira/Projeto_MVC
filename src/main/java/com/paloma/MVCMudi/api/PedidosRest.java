package com.paloma.MVCMudi.api;

import com.paloma.MVCMudi.models.Pedido;
import com.paloma.MVCMudi.models.StatusPedido;
import com.paloma.MVCMudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/aguardando")
    public List<Pedido> getPedidosAguardandoOfertas(){
        Sort sort = Sort.by("id").descending();
        PageRequest page = PageRequest.of(0, 10, sort);
        return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, page);
    }
}
