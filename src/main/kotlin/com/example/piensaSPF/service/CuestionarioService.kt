package com.example.piensaSPF.service

import com.example.piensaSPF.model.Cuestionario
import com.example.piensaSPF.model.Estudiante
import com.example.piensaSPF.repository.CuestionarioRepository
import com.example.piensaSPF.repository.EstudianteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class CuestionarioService {
    @Autowired
    lateinit var cuestionarioRepository: CuestionarioRepository
    fun save (cuestionario:Cuestionario):Cuestionario{
        return cuestionarioRepository.save(cuestionario)
    }
    fun list ():List<Cuestionario>{
        return cuestionarioRepository.findAll()
    }
    fun update(cuestionario:Cuestionario):Cuestionario{
        try {
            cuestionarioRepository.findById(cuestionario.id)
                ?: throw Exception("ID no existe")
            return  cuestionarioRepository.save(cuestionario)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }

    fun updateCalificacion(cuestionario:Cuestionario): Cuestionario {
        try{
            val response = cuestionarioRepository.findById(cuestionario.id)
                ?: throw Exception("ID no existe")
            response.apply {
                calificacion=cuestionario.calificacion
            }
            return cuestionarioRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}