package com.paloma.MVCMudi.controllers;

import com.paloma.MVCMudi.models.Pedido;
import com.paloma.MVCMudi.models.StatusPedido;
import com.paloma.MVCMudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@RequestMapping("/home")
@Controller
public class HomeController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping()
    public String home(Model model, Principal principal) {
        //principal injeta o nome do usuario logado, é do spring security

        Sort sort = Sort.by("dataDaEntrega").descending();
        //paginação
        PageRequest page = PageRequest.of(0, 10, sort);

        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, page);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }

}
