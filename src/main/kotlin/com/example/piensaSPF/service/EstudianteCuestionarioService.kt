package com.example.piensaSPF.service

import com.example.piensaSPF.model.EstudianteCuestionario
import com.example.piensaSPF.repository.CuestionarioRepository
import com.example.piensaSPF.repository.EstudianteCuestionarioRepository
import com.example.piensaSPF.repository.EstudianteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class EstudianteCuestionarioService {
    @Autowired
    lateinit var estudianteCuestionarioRepository: EstudianteCuestionarioRepository
    @Autowired
    lateinit var cuestionarioRepository: CuestionarioRepository
    @Autowired
    lateinit var estudianteRepository: EstudianteRepository

    fun save (estudianteCuestionario:EstudianteCuestionario):EstudianteCuestionario{
        try {
            cuestionarioRepository.findById(estudianteCuestionario.cuestionarioId)
            estudianteRepository.findById(estudianteCuestionario.estudianteId)
                ?: throw Exception("El cuestionario o estudiante no existe")
            return estudianteCuestionarioRepository.save(estudianteCuestionario)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }



    fun list ():List<EstudianteCuestionario>{
        return estudianteCuestionarioRepository.findAll()
    }

    fun update(estudianteCuestionario:EstudianteCuestionario):EstudianteCuestionario{
        try {
            estudianteCuestionarioRepository.findById(estudianteCuestionario.id)
                ?: throw Exception("ID no existe")
            return  estudianteCuestionarioRepository.save(estudianteCuestionario)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }
}