package com.be.kotlin.grade.dto

import com.be.kotlin.grade.dto.studentDTO.StudentDTO
import com.be.kotlin.grade.dto.userDTO.UserRequestDTO

data class RegisterDTO (
    val userDTO: UserRequestDTO,
    val studentDTO: StudentDTO
)