package com.mvp.news.domain.usercase.artical

import com.mvp.comm.base.UseCase
import com.mvp.comm.executor.PostExecutionThread
import com.mvp.comm.network.Result
import com.mvp.news.modle.Artist
import com.mvp.news.repository.ArticalRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/27 0027.
 */
class GetArticalListTask @Inject constructor(val articalRepository: ArticalRepository, postExecutionThread: PostExecutionThread) : UseCase<List<Artist>, GetArticalListTask.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(requestValues: Params?): Observable<Result<List<Artist>>> {

        return articalRepository.getArticalList(requestValues?.ategory, requestValues?.count, requestValues?.page)
    }


    class Params(val ategory: String?, val count: Int, val page: Int)

}