package com.example.javaweek93;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class addUserActivity extends AppCompatActivity {

    private EditText firstName;

    private EditText lastName;

    private EditText email;

    private int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        firstName = findViewById(R.id.editTextFirsName);
        lastName = findViewById(R.id.editTextLastName);
        email = findViewById(R.id.editTextEmail);
    }


    public void addUser(View view) {
        UserStorage Storage = UserStorage.getInstance();

        RadioGroup rgImage = findViewById(R.id.rvAnimals);
        RadioGroup rgUser = findViewById(R.id.radioUserGroup);

        switch (rgImage.getCheckedRadioButtonId()) {
            case R.id.rbCat:
                image = R.drawable.cute_grey_cat_cartoon_260nw_1044708187;
                break;

            case R.id.rbDoug:
                image = R.drawable.vector_illustration_cartoon_dog_260nw_131012516;
                break;

            case R.id.rbHEDGE:
                image = R.drawable.istockphoto_930758362_1024x1024;
                break;

            default:
                Toast.makeText(this, "Anna joku kiva kuva itsellesi :).", Toast.LENGTH_LONG).show();
                return;

        }

        switch (rgUser.getCheckedRadioButtonId()) {
            case R.id.rbTite:
                User user1 = new User(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), "Tietotekniikka", image);
                Storage.addUser(user1);
                break;
            case R.id.rbTuta:
                User user2 = new User(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), "Tuotantotalous", image);
                Storage.addUser(user2);
                break;
            case R.id.rbLate:
                User user3 = new User(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), "Laskennallinen tekniikka", image);
                Storage.addUser(user3);
                break;
            case R.id.rbSäte:
                User user4 = new User(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), "Sähkötekniikka", image);
                Storage.addUser(user4);
                break;
            default:
                Toast.makeText(this, "Anna joku kiva opiskelulinja :).", Toast.LENGTH_LONG).show();
                break;
        }


        }
    }
