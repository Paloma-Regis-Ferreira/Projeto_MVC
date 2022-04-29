package com.paloma.MVCMudi.controllers;

import com.paloma.MVCMudi.models.Pedido;
import com.paloma.MVCMudi.models.RequisicaoNovoPedido;
import com.paloma.MVCMudi.models.StatusPedido;
import com.paloma.MVCMudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/formulario")
    public String formulario(RequisicaoNovoPedido requisicao){
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {

        if(result.hasErrors()) {
            return "pedido/formulario";
        }

        Pedido pedido = requisicao.toPedido();
        pedidoRepository.save(pedido);

        return "redirect:/home";
    }
}
