package com.example.piensaSPF.repository

import com.example.piensaSPF.model.Preguntas
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PreguntasRepository: JpaRepository<Preguntas, Long?> {
    fun findById(id: Long?): Preguntas?
}