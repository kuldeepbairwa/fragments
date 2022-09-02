package com.kuldeep.fragmentsbroadcastetc;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class fragment1 extends Fragment {


    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment1, container, false);


        Button button = view.findViewById(R.id.btn_f1);
        EditText editText = view.findViewById(R.id.et_f1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Bundle result = new Bundle();
                result.putString("df1", editText.getText().toString());
                getParentFragmentManager().setFragmentResult("dataFrom1", result);
                editText.setText("");


                Toast.makeText(getContext(), "data sent to fragment 2!", Toast.LENGTH_SHORT).show();

            }
        });


        getParentFragmentManager().setFragmentResultListener("dataFrom2", fragment1.this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data = result.getString("df2");
                TextView textView = view.findViewById(R.id.tv_desc_f1);
                textView.setText(data);

            }
        });

        return view;
    }
}