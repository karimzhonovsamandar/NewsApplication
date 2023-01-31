package com.example.newsapplication.data.api

import com.example.newsapplication.data.api.db.ArticleDao
import com.example.newsapplication.models.Article
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsService: NewsService,
    private val articleDao: ArticleDao
    ) {

    suspend fun getNews(countryCode: String, pageNumber: Int) =
        newsService.getHeadlines(countryCode = countryCode, page = pageNumber)

    suspend fun getSearchNews(query: String, pageNumber: Int) =
        newsService.getEverything(query = query, page = pageNumber)

    fun getFavoriteArticles() = articleDao.getAllArticles()

    suspend fun addToFavorite(article: Article) = articleDao.insert(article = article)
    suspend fun deleteFromFavorite(article: Article) = articleDao.delete(article = article)
}