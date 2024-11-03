package com.example.newspaper.reposorities

import com.example.newspaper.api.RetrofitInstance
import com.example.newspaper.db.ArticleDatabase

class NewsRepository(
    val db : ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

}