package com.ciru.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Dao
import com.ciru.roomdemo.databinding.ActivityMainBinding
import com.ciru.roomdemo.db.SubscriberDatabase
import com.ciru.roomdemo.db.SubscriberRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: SubscriberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dao = SubscriberDatabase.getInstance(application).subscriberDAO
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        viewModel = ViewModelProvider(this,factory)[SubscriberViewModel::class.java]
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this

        displaySubscriberList()
    }

    private fun displaySubscriberList() {
        viewModel.subscribers.observe(this, Observer {
            Log.i("My Tag", it.toString())
        })
    }
}