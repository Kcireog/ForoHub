package com.kcire.forohub.controller;

import com.kcire.forohub.domain.topico.DatosRegistroTopico;
import com.kcire.forohub.domain.topico.TopicoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {


    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos) {

//        System.out.println(datos);

        var datosTopico = topicoService.registrar(datos);

        return ResponseEntity.ok(datosTopico);
    }


}
