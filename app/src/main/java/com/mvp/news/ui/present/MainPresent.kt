package com.mvp.news.ui.present

import com.mvp.news.domain.usercase.artical.GetArticalCategoryTask
import com.mvp.news.modle.Category
import com.mvp.news.ui.view.MainView
import javax.inject.Inject

/**
 * Created by Administrator on 2017/8/25 0025.
 */


class MainPresent @Inject constructor(val articalCategoryTask: GetArticalCategoryTask,val mainView: MainView) {




    fun reqeustCategoryList() = articalCategoryTask.getArticalCategory()


}