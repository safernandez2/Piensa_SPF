package com.example.piensaSPF.service

import com.example.piensaSPF.model.Clase
import com.example.piensaSPF.repository.ClaseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class ClaseService {
    @Autowired
    lateinit var claseRepository: ClaseRepository
    fun save (clase:Clase):Clase{
        return claseRepository.save(clase)
    }
    fun list ():List<Clase>{
        return claseRepository.findAll()
    }
    fun update(clase:Clase):Clase{
        try {
            claseRepository.findById(clase.id)
                ?: throw Exception("ID no existe")
            return  claseRepository.save(clase)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }

    }

    fun updateDuraciom(clase:Clase): Clase {
        try{
            val response = claseRepository.findById(clase.id)
                ?: throw Exception("ID no existe")
            response.apply {
                duracion=clase.duracion
            }
            return claseRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}