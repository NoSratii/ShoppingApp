package com.androiddev.data.utils.pagination

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}