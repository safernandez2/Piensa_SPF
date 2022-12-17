package com.example.piensaSPF.service

import com.example.piensaSPF.model.ClaseCuestionario
import com.example.piensaSPF.repository.CuestionarioRepository
import com.example.piensaSPF.repository.ClaseCuestionarioRepository
import com.example.piensaSPF.repository.ClaseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class ClaseCuestionarioService {
    @Autowired
    lateinit var claseCuestionarioRepository: ClaseCuestionarioRepository
    @Autowired
    lateinit var cuestionarioRepository: CuestionarioRepository
    @Autowired
    lateinit var claseRepository: ClaseRepository

    fun save (claseCuestionario:ClaseCuestionario):ClaseCuestionario{
        try {
            cuestionarioRepository.findById(claseCuestionario.cuestionarioId)
            claseRepository.findById(claseCuestionario.claseId)
                ?: throw Exception("El cuestionario o clase no existe")
            return claseCuestionarioRepository.save(claseCuestionario)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }



    fun list ():List<ClaseCuestionario>{
        return claseCuestionarioRepository.findAll()
    }

    fun update(claseCuestionario:ClaseCuestionario):ClaseCuestionario{
        try {
            claseCuestionarioRepository.findById(claseCuestionario.id)
                ?: throw Exception("ID no existe")
            return  claseCuestionarioRepository.save(claseCuestionario)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }
}