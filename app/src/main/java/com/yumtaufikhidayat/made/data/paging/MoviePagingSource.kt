package com.yumtaufikhidayat.made.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yumtaufikhidayat.made.data.remote.ApiService
import com.yumtaufikhidayat.made.model.main.MovieMainResult
import com.yumtaufikhidayat.made.utils.Constant
import retrofit2.HttpException
import java.lang.Exception

class MoviePagingSource(
    private val apiService: ApiService
) : PagingSource<Int, MovieMainResult>() {
    override fun getRefreshKey(state: PagingState<Int, MovieMainResult>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieMainResult> {
        return try {
            val currentPage = params.key ?: Constant.STARTING_PAGE_INDEX
            val response = apiService.getMovieNowPlaying(currentPage)
            val data = response.body()?.results
            val nextKey = if (data.isNullOrEmpty()) {
                null
            } else {
                currentPage + (params.loadSize / Constant.LOAD_MAX_PER_PAGE)
            }
            LoadResult.Page(
                data = data ?: emptyList(),
                prevKey = if (currentPage == Constant.STARTING_PAGE_INDEX) null else currentPage - 1,
                nextKey = nextKey?.plus(1)
            )
        } catch (httpEx: HttpException) {
            LoadResult.Error(httpEx)
        } catch (ex: Exception) {
            LoadResult.Error(ex)
        }
    }
}