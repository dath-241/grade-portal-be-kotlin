package com.be.kotlin.grade.service.interf

import com.be.kotlin.grade.dto.Response
import com.be.kotlin.grade.dto.SubjectDTO
import org.springframework.web.bind.annotation.RequestBody

interface SubjectInterface {
    fun addSubject(subject: SubjectDTO): Response
}