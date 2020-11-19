package com.entityrelation.entity.validation

import org.springframework.stereotype.Component
import javax.validation.Valid
import javax.validation.constraints.*

class Register (

        @field:NotBlank(message = "UserName is required")
        @field:Size(message = "6-10 characters",min = 6,max = 10)
        val username:String,


       @field:NotBlank(message="Password is Required")
        @field:Size(message = "6-10 characters", min = 6,max =  10)
        val password:String,


        @field:Email(message = "Input a Valid Email")
        @field:NotBlank(message="UserName is Required")
        val email:String,


        @field:NotBlank(message="Country is Not defined")
        val country:String,


        @field:NotBlank(message="Country is Not defined")
        val city:String,


        @field:NotBlank(message="Country is Not defined")
        val estate:String,

        )
{
    private constructor():this("","","","","","")
}