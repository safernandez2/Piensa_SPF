package com.example.piensaSPF.controller

import com.example.piensaSPF.model.EstudianteCuestionario
import com.example.piensaSPF.model.Preguntas
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
@RequestMapping("/estudiante_cuestionario")
class EstudianteCuestionarioController   {
    @Autowired
    lateinit var estudianteCuestionarioService: EstudianteCuestionarioService
    @PostMapping
    fun save (@RequestBody @Valid estudianteCuestionario:EstudianteCuestionario):EstudianteCuestionario{
        return estudianteCuestionarioService.save(estudianteCuestionario)
    }
    @GetMapping
    fun list ():List<EstudianteCuestionario>{
        return estudianteCuestionarioService.list()
    }
    @PutMapping
    fun update (@RequestBody @Valid estudianteCuestionario: EstudianteCuestionario):ResponseEntity<EstudianteCuestionario>{
        return ResponseEntity(estudianteCuestionarioService.update(estudianteCuestionario), HttpStatus.OK)
    }
}