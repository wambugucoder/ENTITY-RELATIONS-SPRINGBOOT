package com.entityrelation.entity.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Tweets(


        @Column(nullable = false)
        var tweet:String,


        @ManyToOne(fetch=FetchType.EAGER)
        @JoinColumn(name="user_id",referencedColumnName = "id")
        @JsonManagedReference
        val user:User?=null,

        @Column(nullable = false)
        val  createdAt:LocalDateTime=LocalDateTime.now(),


        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id:Long=-1,

)
{
        private constructor():this("")
}