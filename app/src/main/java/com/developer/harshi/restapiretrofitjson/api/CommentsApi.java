package com.developer.harshi.restapiretrofitjson.api;

import com.developer.harshi.restapiretrofitjson.Models.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Harshi on 6/29/2017.
 */

public interface CommentsApi {
    @GET("/comments")
    Call<ArrayList<Comment>> getComments ();

    @GET("/comments")
    Call<ArrayList<Comment>> getCommentsByPostId (
            @Query("postId") int postId
    );
}
