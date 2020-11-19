package com.entityrelation.entity.controller

import com.entityrelation.entity.models.Address
import com.entityrelation.entity.models.User
import com.entityrelation.entity.repository.AddressRepo
import com.entityrelation.entity.repository.UserRepo
import com.entityrelation.entity.validation.Register
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid

@RestController

class UserController {

    @Autowired
    lateinit var userRepo:UserRepo

    @Autowired
    lateinit var addrepo:AddressRepo

    @PostMapping("/register",
    consumes = [MediaType.ALL_VALUE],produces = [MediaType.APPLICATION_JSON_VALUE]
            )
    fun registerUser(@RequestBody @Valid register:Register,finalR: BindingResult): ResponseEntity<String> {
       if(finalR.hasErrors()){
           return ResponseEntity.badRequest().body("Bad Credentials")
       }
      val newUser=User(register.username,register.email,register.password,Address(register.country,register.city,register.estate))

        userRepo.save(newUser)
        return ResponseEntity.accepted().body("User Registered Successfully")




    }
   @GetMapping("/all",produces = [MediaType.APPLICATION_JSON_VALUE],consumes =[MediaType.ALL_VALUE]
   )
   fun showme():MutableList<User>{

       return userRepo.findAll()
   }


}