package com.paloma.MVCMudi.controllers;

import com.paloma.MVCMudi.models.Pedido;
import com.paloma.MVCMudi.models.RequisicaoNovoPedido;
import com.paloma.MVCMudi.models.StatusPedido;
import com.paloma.MVCMudi.models.User;
import com.paloma.MVCMudi.repository.PedidoRepository;
import com.paloma.MVCMudi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/formulario")
    public String formulario(RequisicaoNovoPedido requisicao){
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {

        if(result.hasErrors()) {
            return "pedido/formulario";
        }
        //associando usuario logado a um novo pedido
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);

        Pedido pedido = requisicao.toPedido();
        pedido.setUser(user);
        pedidoRepository.save(pedido);

        return "redirect:/home";
    }
}
