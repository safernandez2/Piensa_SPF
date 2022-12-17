package com.example.piensaSPF.controller

import com.example.piensaSPF.model.Clase
import com.example.piensaSPF.service.ClaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/clase")
class ClaseController   {
    @Autowired
    lateinit var claseService: ClaseService
    @PostMapping
    fun save (@RequestBody @Valid clase:Clase):Clase{
        return claseService.save(clase)
    }
    @GetMapping
    fun list ():List<Clase>{
        return claseService.list()
    }
    @PutMapping
    fun update (@RequestBody @Valid clase: Clase):ResponseEntity<Clase>{
        return ResponseEntity(claseService.update(clase), HttpStatus.OK)
    }

    @PatchMapping
    fun updateDuracion (@RequestBody @Valid clase:Clase):ResponseEntity<Clase>{
        return ResponseEntity(claseService.updateDuraciom(clase), HttpStatus.OK)
    }
}