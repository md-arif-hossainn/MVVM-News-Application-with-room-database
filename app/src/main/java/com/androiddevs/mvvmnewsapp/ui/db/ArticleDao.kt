package com.androiddevs.mvvmnewsapp.ui.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.androiddevs.mvvmnewsapp.ui.models.NewsResponse

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: NewsResponse.Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<NewsResponse.Article>>

    @Delete
    suspend fun deleteArticle(article: NewsResponse.Article)
}