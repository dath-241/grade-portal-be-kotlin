package com.be.kotlin.grade.service.interf

import com.be.kotlin.grade.dto.studyDTO.StudyDTO
import com.be.kotlin.grade.dto.Response
import org.springframework.web.bind.annotation.RequestBody

interface StudyInterface {
    fun addStudyStudent(studyDTO: StudyDTO): Response
    fun deleteStudyStudent(studyIdD: Long): Response
    fun getStudyById(studyIdD: Long): Response
}
