package edu.itstep.myapplic11.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import edu.itstep.myapplic11.R;

public class UserInfoActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        TextView tvUserName = findViewById(R.id.tvUserName);
        TextView tvUserPhone = findViewById(R.id.tvUserPhone);
        TextView tvUserEmail = findViewById(R.id.tvUserEmail);
        TextView tvUserCity = findViewById(R.id.tvUserCity);

        // Retrieve user information from the intent
        String userName = getIntent().getStringExtra("userName");
        String userPhone = getIntent().getStringExtra("userPhone");
        String userEmail = getIntent().getStringExtra("userEmail");
        String userCity = getIntent().getStringExtra("userCity");

        // Display user information
        tvUserName.setText(getString(R.string.user_name) + userName);
        tvUserPhone.setText(getString(R.string.user_phone) + userPhone);
        tvUserEmail.setText(getString(R.string.user_e_mail) + userEmail);
        tvUserCity.setText(getString(R.string.user_city) + userCity);
    }
}
