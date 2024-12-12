package com.be.kotlin.grade.controller

import com.be.kotlin.grade.dto.securityDTO.AuthenticateDTO
import com.be.kotlin.grade.dto.securityDTO.IntrospectDTO
import com.be.kotlin.grade.dto.Response
import com.be.kotlin.grade.dto.loginDTO.ForgotPasswordRequest
import com.be.kotlin.grade.dto.loginDTO.OtpVerificationRequest
import com.be.kotlin.grade.dto.loginDTO.ResetPasswordRequest
import com.be.kotlin.grade.service.interf.IAuthenticate
import com.fasterxml.jackson.core.io.JsonEOFException
import java.text.ParseException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthenticateController(
    private val authenticateService: IAuthenticate
) {

    @PostMapping("/login")
    fun authenticate(@RequestBody request: AuthenticateDTO): ResponseEntity<Response> {
        val response = authenticateService.authenticate(request)
        return ResponseEntity.status(response.statusCode).body(response)
    }

    @PostMapping("/introspect")
    @Throws(ParseException::class, JsonEOFException::class)
    fun introspect(@RequestBody request: IntrospectDTO): ResponseEntity<Response> {
        val response = authenticateService.introspect(request)
        return ResponseEntity.status(response.statusCode).body(response)
    }

    @PostMapping("/forgot-password")
    fun forgotPassword(@RequestBody request: ForgotPasswordRequest): ResponseEntity<Response> {
        val response = authenticateService.sendForgotPasswordEmail(request)
        return ResponseEntity.status(response.statusCode).body(response)
    }

    @PostMapping("/verify-otp")
    fun verifyOTP(@RequestBody request: OtpVerificationRequest): ResponseEntity<Response> {
        val response = authenticateService.verifyOTP(request)
        return ResponseEntity.status(response.statusCode).body(response)
    }

    @PostMapping("/reset-password")
    fun resetPassword(@RequestBody request: ResetPasswordRequest): ResponseEntity<Response> {
        val response = authenticateService.resetPassword(request)
        return ResponseEntity.status(response.statusCode).body(response)
    }
}