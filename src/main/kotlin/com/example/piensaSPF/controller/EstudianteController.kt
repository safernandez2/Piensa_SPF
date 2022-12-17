package com.example.piensaSPF.controller

import com.example.piensaSPF.model.Estudiante
import com.example.piensaSPF.service.EstudianteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.data.domain.Pageable
import javax.validation.Valid

@RestController
@RequestMapping("/estudiante")
class EstudianteController   {
    @Autowired
    lateinit var estudianteService: EstudianteService
    @PostMapping
    fun save (@RequestBody @Valid estudiante:Estudiante):Estudiante{
        return estudianteService.save(estudiante)
    }
    @GetMapping
    fun list (estudiante: Estudiante, pageable: Pageable):ResponseEntity<*>{
        val response = estudianteService.list(pageable, estudiante)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable ("id") id: Long): ResponseEntity<Estudiante>{
        return ResponseEntity(estudianteService.listById(id), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody @Valid estudiante: Estudiante):ResponseEntity<Estudiante>{
        return ResponseEntity(estudianteService.update(estudiante), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody @Valid estudiante:Estudiante):ResponseEntity<Estudiante>{
        return ResponseEntity(estudianteService.updateName(estudiante), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return estudianteService.delete(id)
    }
}