package com.example.piensaSPF.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotBlank


@Entity
@Table(name= "preguntas")
class Preguntas {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var pregunta: String? = null
    @NotBlank
    var respuesta: String? = null
    @Column(name="cuestionario_id")
    var cuestionarioId: Long? = null
}