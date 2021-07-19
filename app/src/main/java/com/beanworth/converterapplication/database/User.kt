package com.beanworth.converterapplication.database

import android.widget.ImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val company_id:Company,
    val order:List<Order>
)

data class Company(val id:Int,val name:String)

data class Product(val id:Int,val name: String,val image:String)
data class Order(val id: Int,val name: String,val  reference:String, val product_id:Product,)
