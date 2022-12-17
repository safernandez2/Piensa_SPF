package com.example.piensaSPF.repository

import com.example.piensaSPF.model.ClaseCuestionario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClaseCuestionarioRepository: JpaRepository<ClaseCuestionario, Long?> {
    fun findById(id: Long?): ClaseCuestionario?
}