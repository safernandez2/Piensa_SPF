package com.example.piensaSPF.repository

import com.example.piensaSPF.model.Cuestionario
import com.example.piensaSPF.model.Estudiante
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CuestionarioRepository: JpaRepository<Cuestionario, Long?> {
    fun findById(id: Long?): Cuestionario?
}