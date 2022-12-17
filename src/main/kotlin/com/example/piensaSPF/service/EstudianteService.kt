package com.example.piensaSPF.service

import com.example.piensaSPF.model.Estudiante
import com.example.piensaSPF.repository.EstudianteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import org.springframework.data.domain.Pageable


@Service
class EstudianteService {
    @Autowired
    lateinit var estudianteRepository: EstudianteRepository
    fun save (estudiante:Estudiante):Estudiante{
        return estudianteRepository.save(estudiante)
    }
    fun list (pageable: Pageable, estudiante: Estudiante):Page<Estudiante>{
        val matcher = ExampleMatcher.matching()
            .withIgnoreNullValues()
            .withMatcher(("fullname"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return estudianteRepository.findAll(Example.of(estudiante, matcher), pageable)
    }

    fun listById (id: Long?): Estudiante?{
        return  estudianteRepository.findById(id)
    }

    fun update(estudiante:Estudiante):Estudiante{
        try {
            estudianteRepository.findById(estudiante.id)
                ?: throw Exception("ID no existe")
            return  estudianteRepository.save(estudiante)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }

    fun updateName(estudiante:Estudiante): Estudiante {
        try{
            val response = estudianteRepository.findById(estudiante.id)
                ?: throw Exception("ID no existe")
            response.apply {
                nombre=estudiante.nombre
            }
            return estudianteRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun delete (id: Long?):Boolean?{
        estudianteRepository.findById(id) ?:
        throw  Exception()
        estudianteRepository.deleteById(id!!)
        return true
    }
}