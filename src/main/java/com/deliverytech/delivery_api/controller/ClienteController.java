package com.deliverytech.delivery_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.deliverytech.delivery_api.model.Cliente;
import com.deliverytech.delivery_api.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteService service;

    public ClienteController ( ClienteService service){
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente ){
        return ResponseEntity.status(201).body(service.cadastrar(cliente));
    }

    @GetMapping
    public List<Cliente> listarAtivos(){
        return service.listarAtivos();
    }
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}/inativar")
    public void inativar(@PathVariable Long id){

    service.inativar(id);

    }

    @PutMapping("/{id}/atualizar-dados-clientes")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente dados){
        return service.atualizar(id, dados);
    }

}