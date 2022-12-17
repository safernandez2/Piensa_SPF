package com.example.piensaSPF.service

import com.example.piensaSPF.model.Estudiante
import com.example.piensaSPF.model.Preguntas
import com.example.piensaSPF.repository.CuestionarioRepository
import com.example.piensaSPF.repository.EstudianteRepository
import com.example.piensaSPF.repository.PreguntasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class PreguntasService {
    @Autowired
    lateinit var preguntasRepository: PreguntasRepository
    @Autowired
    lateinit var cuestionarioRepository: CuestionarioRepository

    fun save (preguntas:Preguntas):Preguntas{
        try {
            cuestionarioRepository.findById(preguntas.cuestionarioId)
                ?: throw Exception("Cuestionario no existe")
            return preguntasRepository.save(preguntas)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }



    fun list ():List<Preguntas>{
        return preguntasRepository.findAll()
    }
    fun update(preguntas:Preguntas):Preguntas{
        try {
            preguntasRepository.findById(preguntas.id)
                ?: throw Exception("ID no existe")
            return  preguntasRepository.save(preguntas)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }

    fun updatePregunta(preguntas:Preguntas): Preguntas {
        try{
            val response = preguntasRepository.findById(preguntas.id)
                ?: throw Exception("ID no existe")
            response.apply {
                pregunta=preguntas.pregunta
            }
            return preguntasRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}