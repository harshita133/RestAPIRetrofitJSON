package com.developer.harshi.restapiretrofitjson.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.developer.harshi.restapiretrofitjson.Models.User;

import java.util.ArrayList;

import com.developer.harshi.restapiretrofitjson.Models.User;
import com.developer.harshi.restapiretrofitjson.R;
import com.developer.harshi.restapiretrofitjson.interfaces.onItemClickListener;

import java.util.ArrayList;

/**
 * Created by championswimmer on 29/06/17.
 */

public class UserAdapter
        extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    public static final String TAG = "UA";

    private Context context;
    private ArrayList<User> users;
    private onItemClickListener oicl;
    private onItemClickListener onItemClickListener;

    public void setOnItemClickListener(onItemClickListener oicl ) {
        this.onItemClickListener = oicl;
    }

    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    public void updateUsers(ArrayList<User> newUserList) {
        this.users = newUserList;
        notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li =
                (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_user, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        final User thisUser = users.get(position);

        holder.tvUserUsername.setText(thisUser.getUsername());
        holder.tvUserName.setText(thisUser.getName());
        holder.tvUserPhone.setText(thisUser.getPhone());
        holder.tvUserEmail.setText(thisUser.getEmail());
        holder.thisView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.OnItemClick(thisUser.getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView tvUserUsername, tvUserName, tvUserPhone, tvUserEmail;
        View thisView;
        Button btnshowComments,btnshowPosts;

        public UserViewHolder(View itemView) {
            super(itemView);
            thisView = itemView;
            tvUserEmail = (TextView) itemView.findViewById(R.id.tvUserEmail);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            tvUserPhone = (TextView) itemView.findViewById(R.id.tvUserPhone);
            tvUserUsername = (TextView) itemView.findViewById(R.id.tvUserUsername);
            btnshowComments = (Button) itemView.findViewById(R.id.tvUserShowComments);
            btnshowPosts = (Button) itemView.findViewById(R.id.tvUserShowPost);
        }
    }
}