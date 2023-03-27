package com.muhsanjaved.fragment_practice;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HelloFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class HelloFragment extends Fragment {
    public static final String TAG ="FRAGMENT";
    private String message;

    public HelloFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach : Fragment");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate : Fragment");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_hello, container, false);

      /*  Bundle bundleGetData = getArguments();

        if (bundleGetData != null){
            String message = bundleGetData.getString("key");
            TextView textView = view.findViewById(R.id.showData);
            textView.setText(message);
        }*/

//        TextView textView = view.findViewById(R.id.showData);
//        textView.setText(message);

        TextView showText = view.findViewById(R.id.showData);
        Bundle bundle = getArguments();

        if (bundle != null){
            Person person = bundle.getParcelable("key");

            showText.setText(person.getfName() + "\n");
            showText.append(person.getlName() + "\n");
            showText.append(String.valueOf(person.getAge()));

        }

       return view;
    }

    public void setData(String message){
        this.message = message;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreate : Fragment");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart : Fragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume : Fragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause : Fragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop : Fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView : Fragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy : Fragment");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach : Fragment");
    }
}