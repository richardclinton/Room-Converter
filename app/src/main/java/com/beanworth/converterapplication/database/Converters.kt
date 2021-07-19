package com.beanworth.converterapplication.database

import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converters {
    @TypeConverter
    fun fromCompany(company:Company):String{
        val gson = Gson()
        return gson.toJson(company)
    }

    @TypeConverter
    fun company(value:String):Company{
      val listType:Type = object :TypeToken<Company>(){}.type
        return Gson().fromJson(value,listType)
    }

    @TypeConverter
    fun fromProduct(product:Product):String{
        val gson = Gson()
        return gson.toJson(product)
    }
    @TypeConverter
    fun product(value:String):Product{
        val listType:Type = object : TypeToken<Product>(){}.type
        return Gson().fromJson(value,listType)
    }

    @TypeConverter
    fun fromOrder(order:List<Order>):String{
        val gson = Gson()
        return gson.toJson(order)
    }
    @TypeConverter
    fun order(value:String):List<Order>{
        val listType:Type = object : TypeToken<List<Order>>(){}.type
        return Gson().fromJson(value,listType)
    }
}