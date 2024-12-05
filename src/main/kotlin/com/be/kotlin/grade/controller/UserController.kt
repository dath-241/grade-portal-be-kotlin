package com.be.kotlin.grade.controller

import com.be.kotlin.grade.dto.Response
import com.be.kotlin.grade.dto.UserDto.UserUpdateRequestDTO
import com.be.kotlin.grade.dto.userDTO.UserRequestDTO
import com.be.kotlin.grade.service.interf.UserInterface
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.nio.file.attribute.UserPrincipal

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserInterface
) {
    @PostMapping("/register")
    fun register(@RequestBody user: UserRequestDTO): ResponseEntity<Response> {
        val response = userService.register(user)
        return ResponseEntity.status(response.statusCode).body(response)
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") userId: Long): ResponseEntity<Response> {
        val response = userService.findUserById(userId)
        return ResponseEntity.status(response.statusCode).body(response)
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    fun getAllUsers(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ): ResponseEntity<Response> {
        val pageable: Pageable = PageRequest.of(page, size)
        val response = userService.findAllUser(pageable)
        return ResponseEntity.status(response.statusCode).body(response)
    }

    @PostMapping("/update/role")
    fun updateRole(@RequestParam role : String,@RequestParam username : String): ResponseEntity<Response>{
        val response = userService.updateRole(role,username)
        return ResponseEntity.status(response.statusCode).body(response)
    }

    @PatchMapping("")
    fun updateInfo(@RequestBody userDTO: UserUpdateRequestDTO): ResponseEntity<Response>{
        val response = userService.updateInfo(userDTO)
        return ResponseEntity.status(response.statusCode).body(response)
    }

    @DeleteMapping("/delete")
    fun delAccount(@RequestParam username: String): ResponseEntity<Response>{
        val response = userService.delUser(username)
        return ResponseEntity.status(response.statusCode).body(response)
    }
}