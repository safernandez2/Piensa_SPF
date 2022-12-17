package com.example.piensaSPF.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name= "estudiante_cuestionario")
class EstudianteCuestionario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "estudiante_id")
    var estudianteId: Long? = null

    @Column(name = "cuestionario_id")
    var cuestionarioId: Long? = null
}