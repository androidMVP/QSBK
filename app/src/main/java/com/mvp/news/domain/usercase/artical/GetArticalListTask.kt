package com.mvp.news.domain.usercase.artical

import com.mvp.comm.base.UseCase
import com.mvp.news.modle.Artist
import com.mvp.news.repository.ArticalRepository
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/27 0027.
 */
class GetArticalListTask : UseCase<GetArticalListTask.RequestValues, GetArticalListTask.ResponseValue>() {
    @Inject
    lateinit var articalDataRepository: ArticalRepository

    override fun executeUseCase(requestValues: RequestValues?) {
        articalDataRepository.getArticalList(requestValues)
    }


    class RequestValues(val category: String, val count: Int,val page: Int) : UseCase.RequestValues

    class ResponseValue(val task: Artist) : UseCase.ResponseValue

}