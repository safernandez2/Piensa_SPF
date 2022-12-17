package com.example.piensaSPF.repository

import com.example.piensaSPF.model.EstudianteCuestionario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EstudianteCuestionarioRepository: JpaRepository<EstudianteCuestionario, Long?> {
    fun findById(id: Long?): EstudianteCuestionario?
}