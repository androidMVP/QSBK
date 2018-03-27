package com.mvp.news.domain.usercase.artical

import com.mvp.comm.base.UseCase
import com.mvp.news.modle.Artist

/**
 * Created by Administrator on 2018/3/27 0027.
 */
class GetArticalTask : UseCase<GetArticalTask.RequestValues, GetArticalTask.ResponseValue>() {


    override fun executeUseCase(requestValues: RequestValues?) {
    }


    class RequestValues(val page: String) : UseCase.RequestValues

    class ResponseValue(val task: Artist) : UseCase.ResponseValue

}