package com.example.javaweek93;

import static android.provider.Telephony.Mms.Part.FILENAME;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class UserStorage implements Serializable {

    private ArrayList<User> users = new ArrayList<>();

    private static UserStorage storage = null;

    private UserStorage(){
    }

    public static UserStorage getInstance(){
        if (storage == null){
            storage = new UserStorage();
        }
        return storage;
    }


    public void addUser(User user){
        users.add(user);
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public void saveUsers(Context context){
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            userWriter.writeObject(users);
            userWriter.close();
        } catch (IOException e) {
            System.out.println("Kirjoittaminen Ei onnistunut");
        }
    }
    public void loadUser(Context context) {
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("users.data"));
            users = (ArrayList<User>) userReader.readObject();
            userReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lukeminen Ei onnistunut");
        } catch (IOException e) {
            System.out.println("Lukeminen Ei onnistunut");
        } catch (ClassNotFoundException e) {
            System.out.println("Lukeminen Ei onnistunut");
        }

    }
}
