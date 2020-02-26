package com.example.giveabook;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    //convenient approach, lets be boss on it
    @GET("trigger")
    Call<Post> getPosts(@Query("shortid") String shortid,
                              @Query("pin") String pin,
                              @Query("app") String app
    );
}
