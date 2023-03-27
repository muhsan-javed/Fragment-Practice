package com.muhsanjaved.fragment_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String TAG ="FRAGMENT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button show = findViewById(R.id.button);
        Button remove = findViewById(R.id.button2);
        Button sendDataToFragment = findViewById(R.id.button3);
        EditText firstName = findViewById(R.id.editTextTextPersonName);
        EditText lastName = findViewById(R.id.editTextTextPersonLastName);
        EditText editTextAge = findViewById(R.id.editTextTextPersonAge);


        sendDataToFragment.setOnClickListener(view -> {
            HelloFragment fragment = new HelloFragment();
            String fName = firstName.getText().toString();
            String lName = lastName.getText().toString();
            int age = Integer.parseInt(editTextAge.getText().toString());

            Person person = new Person(fName, lName,age);

            Bundle bundle = new Bundle();
            bundle.putParcelable("key", person);

            fragment.setArguments(bundle);

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();

            /*    String sendData = editText.getText().toString();

//            Bundle bundle = new Bundle();
//            bundle.putString("key", sendData);
//
//            HelloFragment fragment = new HelloFragment();
//
//            fragment.setArguments(bundle); // Send Data from Activity to Fragment
            HelloFragment fragment = new HelloFragment();

            fragment.setData(sendData);

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();*/

        });

        Log.d(TAG, "onCreate : Fragment");
//        FragmentManager manager = getSupportFragmentManager();
//        manager.beginTransaction()
//                .add(R.id.fragment_container, helloFragment)
//                .commit();

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelloFragment helloFragment =new HelloFragment();

                getSupportFragmentManager()
                        .beginTransaction()
//                        .add(R.id.fragment_container, helloFragment, "fragmentTag")
                        .add(R.id.fragment_container, helloFragment)
                        .commit();

            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelloFragment fragment = (HelloFragment) getSupportFragmentManager()
//                        .findFragmentByTag("fragmentTag")
                        .findFragmentById(R.id.fragment_container);

                if (fragment != null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .remove(fragment)
                            .commit();
                }


            }
        });

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.d(TAG, "onAttachFragment : Fragment");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart : Fragment");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume : Fragment");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop : Fragment");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy : Fragment");
    }
}