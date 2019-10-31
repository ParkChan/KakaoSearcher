package com.example.kakaosearcher.common

interface BindableAdapter<T> {
    fun setData(items: List<T>?)
}