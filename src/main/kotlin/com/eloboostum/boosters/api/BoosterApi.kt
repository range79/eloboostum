package com.eloboostum.boosters.api

interface BoosterApi {
    fun acceptRequest(userId: Long): String
    fun declineRequest(userId: Long): String
    fun listRequests(): String
}