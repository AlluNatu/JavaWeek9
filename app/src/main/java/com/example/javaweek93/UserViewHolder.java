package com.example.javaweek93;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView userImage;
    TextView FirstName, LastName, Email, degreeProgram;


    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        userImage = itemView.findViewById(R.id.userImageView);
        FirstName = itemView.findViewById(R.id.textFirstName);
        LastName = itemView.findViewById(R.id.textLastName);
        Email = itemView.findViewById(R.id.textEmail);
        degreeProgram = itemView.findViewById(R.id.textDP);
    }
}
