package com.example.piensaSPF.repository

import com.example.piensaSPF.model.Clase
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClaseRepository: JpaRepository<Clase, Long?> {
    fun findById(id: Long?): Clase?
}