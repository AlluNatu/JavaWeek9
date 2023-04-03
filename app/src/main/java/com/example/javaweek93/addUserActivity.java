package com.example.javaweek93;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class addUserActivity extends AppCompatActivity {

    private EditText firstName;

    private EditText lastName;

    private EditText email;

    private CheckBox cbKandi, cbTohtori, cbUima, cbDI;

    private int image;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        firstName = findViewById(R.id.editTextFirsName);
        lastName = findViewById(R.id.editTextLastName);
        email = findViewById(R.id.editTextEmail);
        cbKandi = findViewById(R.id.cbKandi);
        cbTohtori = findViewById(R.id.cbTohtori);
        cbUima = findViewById(R.id.cbUima);
        cbDI = findViewById(R.id.cbDI);

        context = this;
    }


    public void addUser(View view) {
        StringBuilder str = new StringBuilder();
        UserStorage Storage = UserStorage.getInstance();

        RadioGroup rgImage = findViewById(R.id.rvAnimals);
        RadioGroup rgUser = findViewById(R.id.radioUserGroup);


        if (cbKandi.isChecked() || cbUima.isChecked() || cbUima.isChecked() || cbTohtori.isChecked()){

            str.append("Suoritetut tutkinnot:");
        }


        if (cbKandi.isChecked()) {
            str.append("\n-Kandidaatin tutkinto");
        }

        if (cbTohtori.isChecked()){
            str.append("\n-Tohtorin tutkinto");
        }

        if (cbUima.isChecked()){
            str.append("\n-Uimamestarin tutkinto");
        }

        if (cbDI.isChecked()){
            str.append("\n-Diplomi-Insinöörin tutkinto");
        }


        switch (rgImage.getCheckedRadioButtonId()) {
            case R.id.rbCat:
                image = R.drawable.kat;
                break;

            case R.id.rbDoug:
                image = R.drawable.dawg;
                break;

            case R.id.rbHEDGE:
                image = R.drawable.hedgehog;
                break;

            default:
                Toast.makeText(this, "Anna joku kiva kuva itsellesi :).", Toast.LENGTH_LONG).show();
                return;

        }

        switch (rgUser.getCheckedRadioButtonId()) {
            case R.id.rbTite:
                User user1 = new User(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), "Tietotekniikka", image, str.toString());
                Storage.addUser(user1);
                break;
            case R.id.rbTuta:
                User user2 = new User(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), "Tuotantotalous", image, str.toString());
                Storage.addUser(user2);
                break;
            case R.id.rbLate:
                User user3 = new User(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), "Laskennallinen tekniikka", image, str.toString());
                Storage.addUser(user3);
                break;
            case R.id.rbSäte:
                User user4 = new User(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), "Sähkötekniikka", image, str.toString());
                Storage.addUser(user4);
                break;
            default:
                Toast.makeText(this, "Anna joku kiva opiskelulinja :).", Toast.LENGTH_LONG).show();
                break;
        }
        Storage.saveUsers(context);

        }
    }
