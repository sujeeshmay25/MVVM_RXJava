package com.example.pathwayhub_sujeesh.network

import io.reactivex.Observable
import retrofit2.http.GET

interface RetroService {

    @GET("search?q=title:DNA")
    fun getList():Observable<PathPojo>
}