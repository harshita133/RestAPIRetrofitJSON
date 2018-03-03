package com.developer.harshi.restapiretrofitjson.api;

import com.developer.harshi.restapiretrofitjson.Models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Harshi on 6/29/2017.
 */

public interface UsersAPI {

    @GET("/users")
    Call<ArrayList<User>> getUsers ();
}

