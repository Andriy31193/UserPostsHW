package edu.itstep.myapplic11.fragments.slider.utils;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.itstep.myapplic11.fragments.slider.Slide;
import edu.itstep.myapplic11.models.Post;

public class SlideUtils {
    public static List<Slide> fetchPosts(List<Post> posts) {
        List<Slide> slides = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            slides.add(
                    new Slide(post.getTitle(),
                            post.getBody(),
                            Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)),
                            post
                    ));
        }

        return slides;

    }

}
