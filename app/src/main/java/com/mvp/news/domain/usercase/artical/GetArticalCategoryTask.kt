package com.mvp.news.domain.usercase.artical

import com.mvp.comm.base.UseCase
import com.mvp.comm.executor.PostExecutionThread
import com.mvp.comm.network.Result
import com.mvp.news.modle.Artist
import com.mvp.news.modle.Category
import com.mvp.news.repository.ArticalRepository
import io.reactivex.Observable
import java.util.ArrayList
import javax.inject.Inject

/**
 * @author MVP
 * created: 2018/6/4
 * desc:
 */

class GetArticalCategoryTask @Inject constructor(val articalRepository: ArticalRepository) {

    fun getArticalCategory(): ArrayList<Category> {

        return articalRepository.getArticalCategory()
    }

}




