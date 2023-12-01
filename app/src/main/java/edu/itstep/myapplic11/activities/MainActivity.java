package edu.itstep.myapplic11.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import edu.itstep.myapplic11.interfaces.api.API;
import edu.itstep.myapplic11.models.Post;
import edu.itstep.myapplic11.R;
import edu.itstep.myapplic11.fragments.slider.utils.SlideUtils;
import edu.itstep.myapplic11.fragments.slider.Slide;
import edu.itstep.myapplic11.fragments.slider.SlideAdapter;
import edu.itstep.myapplic11.fragments.slider.ZoomOutPageTransformer;
import edu.itstep.myapplic11.models.User;
import edu.itstep.myapplic11.services.NetworkService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private API api;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        api = NetworkService.getInstance().getApi();

        api.getAll().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    List<Post> posts = response.body();
                    renderSlides(posts);
                } else {
                    Log.e("API", "Failed to retrieve user data. Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("API Call", "Failed to retrieve user data", t);
            }
        });

    }
    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }

    }
    private void renderSlides(List<Post> posts)
    {
        viewPager = findViewById(R.id.viewPager);
        List<Slide> slides = SlideUtils.fetchPosts(posts);
        SlideAdapter adapter = new SlideAdapter(this, slides, this::showUserInfo);
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(new ZoomOutPageTransformer());
    }
    private void showUserInfo(Slide slide) {
        int userId = slide.getPost().getUserId();




        api.getUserById(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();

                Intent intent = new Intent(MainActivity.this, UserInfoActivity.class);
                intent.putExtra("userName", user.getName());
                intent.putExtra("userPhone", user.getPhone());
                intent.putExtra("userEmail", user.getEmail());
                intent.putExtra("userCity", user.getAddress().getCity());
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
            }
        });
    }
}
