package com.example.piensaSPF.controller

import com.example.piensaSPF.model.Cuestionario
import com.example.piensaSPF.model.Estudiante
import com.example.piensaSPF.service.CuestionarioService
import com.example.piensaSPF.service.EstudianteService
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
@RequestMapping("/cuestionario")
class CuestionarioController   {
    @Autowired
    lateinit var cuestionarioService: CuestionarioService
    @PostMapping
    fun save (@RequestBody @Valid cuestionario:Cuestionario):Cuestionario{
        return cuestionarioService.save(cuestionario)
    }
    @GetMapping
    fun list ():List<Cuestionario>{
        return cuestionarioService.list()
    }
    @PutMapping
    fun update (@RequestBody @Valid cuestionario: Cuestionario):ResponseEntity<Cuestionario>{
        return ResponseEntity(cuestionarioService.update(cuestionario), HttpStatus.OK)
    }

    @PatchMapping
    fun updateCalificacion (@RequestBody @Valid cuestionario:Cuestionario):ResponseEntity<Cuestionario>{
        return ResponseEntity(cuestionarioService.updateCalificacion(cuestionario), HttpStatus.OK)
    }
}