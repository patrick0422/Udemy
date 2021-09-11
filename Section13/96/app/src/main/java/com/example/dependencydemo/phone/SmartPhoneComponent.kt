package com.example.dependencydemo.phone

import dagger.Component


@Component
interface SmartPhoneComponent {
    fun getSmartPhone() : SmartPhone
}