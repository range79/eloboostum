package com.eloboostum.services.dto

import jakarta.validation.constraints.NotNull


data class ServiceRequest(
    @NotNull
    var name:String,
    var description:String? = null,
    var coverImageURL:String? = null,
)
