package com.entityrelation.entity.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name="address_table")
data class Address (
        @NotBlank(message="Country is Not defined")
        val country:String,

        @NotBlank(message="Country is Not defined")
        val city:String,

        @NotBlank(message="Country is Not defined")
        val estate:String,

        @OneToOne(mappedBy = "address",cascade = [CascadeType.ALL])
        @JsonBackReference
        val user: User? = null,

        @Id @GeneratedValue(strategy=GenerationType.AUTO)
        val id:Long=-1
)
{
private constructor():this("","","")
}