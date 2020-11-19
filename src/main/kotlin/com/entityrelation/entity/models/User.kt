package com.entityrelation.entity.models


import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.jetbrains.annotations.NotNull
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "user_table")
data class User(


        @NotBlank(message="UserName is Required")
        @Min(6,message = "UserName Must Contain 6- 10 Characters")
        @Max(10,message = "UserName Must Contain 6- 10 Characters")
       val username:String,

        @Email(message = "Input a Valid Email")
        @NotBlank(message="UserName is Required")

        val  email:String,

        @NotBlank(message="Password is Required")
        @Min(6,message = "Password must contain more than 6 Characters")
        val password:String,


        @OneToOne(cascade = [CascadeType.ALL],fetch = FetchType.EAGER)
        @JoinColumn(name = "address_id",referencedColumnName = "id")
        @JsonManagedReference
        val address: Address? = null,

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val  id:Long =0,


        @OneToMany(cascade = [CascadeType.ALL],fetch = FetchType.LAZY,mappedBy = "user")
        @JsonBackReference
        val tweets: List<Tweets> = emptyList(),

)
{
  constructor():this("","","")
}