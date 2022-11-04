package com.ciru.roomdemo.db

class SubscriberRepository(private val dao:SubscriberDAO) {
    val subscriber = dao.getAllSubscribers()

    suspend fun update(subscriber: Subscriber){
        dao.updateSubscriber(subscriber)
    }

    suspend fun delete(subscriber: Subscriber){
        dao.deletesubscriber(subscriber)
    }

    suspend fun insert(subscriber: Subscriber){
        dao.insertSubscriber(subscriber)
    }

    suspend fun deleteAll_(){
        dao.deleteAll()
    }
}