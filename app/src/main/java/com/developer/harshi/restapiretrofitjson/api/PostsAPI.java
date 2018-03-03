package com.developer.harshi.restapiretrofitjson.api;

import com.developer.harshi.restapiretrofitjson.Models.Comment;
import com.developer.harshi.restapiretrofitjson.Models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Harshi on 6/29/2017.
 */

public interface PostsAPI {
    @GET("/posts")
    Call<ArrayList<Post>> getPosts ();

    @GET("/posts/{id}")
    Call<Post> getPostById (
            @Path("id") int id
    );

    @GET("/posts")
    Call<ArrayList<Post>> getPostsByUserId (
            @Query("userId") int userId
    );

    interface CommentsAPI {

        @GET("/posts/{postId}/comments")
        Call<ArrayList<Comment>> getCommentsOfPostId (
                @Path("postId") int postId
        );

    }
}
