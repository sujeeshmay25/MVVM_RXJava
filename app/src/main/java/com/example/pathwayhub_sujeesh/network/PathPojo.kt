package com.example.pathwayhub_sujeesh.network

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

//@Entity(tableName = "response")
data class PathPojo (val response: Response):Serializable{

    data class Response(val docs: ArrayList<Doc>,
                        val maxScore: Double,
                        val numFound: Int,
                        val start: Int){
        @Entity(tableName = "doc")
        data class Doc(
                       @SerializedName("abstract")
                       val abstract: ArrayList<String>,
                       @SerializedName("article_type")
                       val article_type: String,
                       @SerializedName("author_display")
                       val author_display: ArrayList<String>,
                       @SerializedName("eissn")
                       val eissn: String,
                       @SerializedName("id")
                       val id: String,
                       @SerializedName("journal")
                       val journal: String,
                       @SerializedName("publication_date")
                       val publication_date: String,
                       @SerializedName("score")
                       val score: Double,
                       @SerializedName("title_display")
                       val title_display: String
        ):Serializable
    }
}