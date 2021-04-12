package com.example.signupformfragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

public class MainActivity extends FragmentActivity {

    public String email;
    public String name;
    public String birthday;
    public String gender;
    public String school;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Navigation.findNavController(this,R.id.form_nav_graph)
                .setGraph(R.navigation.form_nav_graph);
    }

}
