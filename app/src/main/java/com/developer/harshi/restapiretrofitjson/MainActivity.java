package com.developer.harshi.restapiretrofitjson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.developer.harshi.restapiretrofitjson.Models.User;
import com.developer.harshi.restapiretrofitjson.adapters.UserAdapter;
import com.developer.harshi.restapiretrofitjson.api.CommentsApi;
import com.developer.harshi.restapiretrofitjson.api.PostsAPI;
import com.developer.harshi.restapiretrofitjson.api.UsersAPI;
import com.developer.harshi.restapiretrofitjson.interfaces.onItemClickListener;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "USERS";

    RecyclerView rvUserList;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvUserList = (RecyclerView) findViewById(R.id.rvUserList);
        rvUserList.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(this, new ArrayList<User>());
        rvUserList.setAdapter(userAdapter);
        userAdapter.setOnItemClickListener(new onItemClickListener() {
            @Override
            public void OnItemClick(int itemId) {
                Intent postActIntent = new Intent(MainActivity.this,
                        PostsActivity.class);

                postActIntent.putExtra("userId", itemId);
                startActivity(postActIntent);
            }
        });

        ((Button) findViewById(R.id.btnAllPosts)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(
                                MainActivity.this,
                                PostsActivity.class
                        ));
                    }
                }
        );

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();


        final UsersAPI usersAPI = retrofit.create(UsersAPI.class);
//          final UsersAPI usersAPI = RestAPI.getInstance().create(UsersAPI.class);


        usersAPI.getUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call,
                                   Response<ArrayList<User>> response) {
                userAdapter.updateUsers(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });

    }



}