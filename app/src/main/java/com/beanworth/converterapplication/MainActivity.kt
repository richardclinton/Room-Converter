package com.beanworth.converterapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.beanworth.converterapplication.database.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var database: MyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val  orders = arrayListOf<Order>()
        val company = Company(1,"BeanWorth")
        val product = Product(1,"burger","astringimage")
        val order1 = Order(1,"S-2001","S201",product)
        val order2 = Order(2,"S-2002","s2009",product)
        orders.add(order1)
        orders.add(order2)
        database = MyDatabase.getInstance(this)
        CoroutineScope(Dispatchers.IO).launch {
            database.userDao.save(User(1,"clinton",company,orders))
        }
    }
}