package com.ly.supermvp.server.api;

import com.ly.supermvp.common.BizInterface;
import com.ly.supermvp.model.entity.NewsResponse;
import com.ly.supermvp.model.entity.ShowApiResponse;
import com.ly.supermvp.model.entity.ShowApiWeather;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.Query;
import rx.Observable;

/**
 * <Pre>
 *     易源api
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 *          <p/>
 *          Create by 2016/1/27 15:22
 */
public interface ShowApi {
    @GET(BizInterface.NEWS_URL)
    @Headers("apikey: " + BizInterface.API_KEY)
    Call<NewsResponse> getNewsList(@Header("Cache-Control") String cacheControl,
                                   @Query("page") int page,
                                   @Query("channelId") String channelId,//新闻频道id，必须精确匹配
                                   @Query("channelName") String channelName);//新闻频道名称，可模糊匹配

    /**
     * 天气预报响应
     * @param area 地区名称，比如北京
     * @param needMoreDay 是否需要返回7天数据中的后4天。1为返回，0为不返回。
     * @param needIndex 是否需要返回指数数据，比如穿衣指数、紫外线指数等。1为返回，0为不返回。
     * @param needAlarm 是否需要天气预警。1为需要，0为不需要。
     * @param need3HourForcast 是否需要当天每3小时1次的天气预报列表。1为需要，0为不需要。
     * @return
     */
    @GET(BizInterface.WEATHER_URL)
    @Headers("apikey: " + BizInterface.API_KEY)
    Observable<ShowApiResponse<ShowApiWeather>> getWeather(@Header("Cache-Control") String cacheControl,
                                                           @Query("area") String area,
                                                           @Query("needMoreDay") String needMoreDay,
                                                           @Query("needMoreDay") String needIndex,
                                                           @Query("needMoreDay") String needAlarm,
                                                           @Query("needMoreDay") String need3HourForcast);
}
