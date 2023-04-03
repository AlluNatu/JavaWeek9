package com.example.javaweek93;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context context;
    private ArrayList<User> users = new ArrayList<>();

    public UserListAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;

        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return user.getLastName().compareToIgnoreCase(t1.getLastName());
            }
        });
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.FirstName.setText(users.get(position).getFirstName());
        holder.LastName.setText(users.get(position).getLastName());
        holder.Email.setText(users.get(position).getEmail());
        holder.degreeProgram.setText(users.get(position).getDegreeProgram());
        holder.userImage.setImageResource(users.get(position).getImage());
        holder.Accomplishment.setText(users.get(position).getAccomplishment());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
