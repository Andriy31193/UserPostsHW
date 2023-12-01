package edu.itstep.dynamic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnCounter;
    private Button btnGreeting;

    private CounterFragment counterFragment;
    private GreetingFragment greetingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterFragment = new CounterFragment();
        greetingFragment = new GreetingFragment();

        btnCounter = findViewById(R.id.btnCounter);
        btnGreeting = findViewById(R.id.btnGreeting);

        btnCounter.setOnClickListener(v -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer, counterFragment)
                    .commit();
        });

        btnGreeting.setOnClickListener(v -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer, greetingFragment)
                    .commit();
        });
    }
}