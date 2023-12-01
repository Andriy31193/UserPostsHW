package edu.itstep.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CounterFragment extends Fragment {
    private Button btnCounter;
    private TextView tvCounter;

    private int count = 0;

    public CounterFragment() {
        super(R.layout.fragment_counter);
        Log.d("LifeCycle", "CounterFragment");

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("LifeCycle", "CounterFragment onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LifeCycle", "CounterFragment onCreate");

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCounter = view.findViewById(R.id.btnCounter);
        tvCounter = view.findViewById(R.id.tvCounter);
        tvCounter.setText(String.valueOf(count));

        btnCounter.setOnClickListener(view1 -> {
            tvCounter.setText(String.valueOf(++count));
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "CounterFragment onDestroy");

    }
}
