package com.example.firstaplication.data.dao

interface CRUD<T> {
    fun create(item: T)
    fun read(): T
    fun update(item: T)
    fun delete(id: Int)
}