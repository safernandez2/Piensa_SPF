package com.example.piensaSPF.controller

import com.example.piensaSPF.model.ClaseCuestionario
import com.example.piensaSPF.model.EstudianteCuestionario
import com.example.piensaSPF.model.Preguntas
import com.example.piensaSPF.service.ClaseCuestionarioService
import com.example.piensaSPF.service.EstudianteCuestionarioService
import com.example.piensaSPF.service.PreguntasService
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
@RequestMapping("/clase_cuestionario")
class ClaseCuestionarioController   {
    @Autowired
    lateinit var claseCuestionarioService: ClaseCuestionarioService
    @PostMapping
    fun save (@RequestBody @Valid claseCuestionario:ClaseCuestionario):ClaseCuestionario{
        return claseCuestionarioService.save(claseCuestionario)
    }
    @GetMapping
    fun list ():List<ClaseCuestionario>{
        return claseCuestionarioService.list()
    }
    @PutMapping
    fun update (@RequestBody @Valid claseCuestionario: ClaseCuestionario):ResponseEntity<ClaseCuestionario>{
        return ResponseEntity(claseCuestionarioService.update(claseCuestionario), HttpStatus.OK)
    }
}