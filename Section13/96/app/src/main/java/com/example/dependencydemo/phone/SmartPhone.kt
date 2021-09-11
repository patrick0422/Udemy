package com.example.dependencydemo.phone

import javax.inject.Inject


fun main() {

}

class SmartPhone @Inject constructor(
    val battery: Battery,
    val memoryCard: MemoryCard,
    val simCard: SIMCard) {

}

class Battery @Inject constructor(){

}

class MemoryCard @Inject constructor(){

}

class SIMCard @Inject constructor(serviceProvider: ServiceProvider){

}

class ServiceProvider @Inject constructor(){

}