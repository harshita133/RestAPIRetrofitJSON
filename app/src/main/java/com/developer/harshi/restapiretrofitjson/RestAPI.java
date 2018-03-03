package com.developer.harshi.restapiretrofitjson;

import com.developer.harshi.restapiretrofitjson.Models.Post;
import com.developer.harshi.restapiretrofitjson.api.CommentsApi;
import com.developer.harshi.restapiretrofitjson.api.PostsAPI;
import com.developer.harshi.restapiretrofitjson.api.UsersAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Harshi on 6/29/2017.
 */

public class RestAPI {

    private static Retrofit apiInstance;

    private Retrofit retrofitInstance;
    private PostsAPI postsAPI;
    private UsersAPI usersAPI;
    private CommentsApi commentsAPI;

    private RestAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();

        postsAPI = retrofitInstance.create(PostsAPI.class);
        usersAPI = retrofitInstance.create(UsersAPI.class);
        commentsAPI = retrofitInstance.create(CommentsApi.class);
    }

    public PostsAPI getPostsAPI() {
        return postsAPI;
    }

    public UsersAPI getUsersAPI() {
        return usersAPI;
    }

    public CommentsApi getCommentsAPI() {
        return commentsAPI;
    }

    public static Retrofit getInstance(){
        if (apiInstance == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(
                            GsonConverterFactory.create()
                    )
                    .build();
        }
        return apiInstance;

//    public static  RestAPI getInstance(){
//        if (apiInstance == null){
//            apiInstance = new RestAPI();
//        }
//        return apiInstance;
//    }
}}
