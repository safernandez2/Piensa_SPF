package com.example.piensaSPF.controller

import com.example.piensaSPF.model.Preguntas
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
@RequestMapping("/preguntas")
class PreguntasController   {
    @Autowired
    lateinit var preguntasService: PreguntasService
    @PostMapping
    fun save (@RequestBody @Valid preguntas:Preguntas):Preguntas{
        return preguntasService.save(preguntas)
    }
    @GetMapping
    fun list ():List<Preguntas>{
        return preguntasService.list()
    }
    @PutMapping
    fun update (@RequestBody @Valid preguntas: Preguntas):ResponseEntity<Preguntas>{
        return ResponseEntity(preguntasService.update(preguntas), HttpStatus.OK)
    }

    @PatchMapping
    fun updatePregunta (@RequestBody @Valid preguntas:Preguntas):ResponseEntity<Preguntas>{
        return ResponseEntity(preguntasService.updatePregunta(preguntas), HttpStatus.OK)
    }
}