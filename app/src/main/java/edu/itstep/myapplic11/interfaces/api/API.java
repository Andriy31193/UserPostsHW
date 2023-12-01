package edu.itstep.myapplic11.interfaces.api;


import java.util.List;

import edu.itstep.myapplic11.models.Post;
import edu.itstep.myapplic11.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {

    @GET("posts/{id}")
    Call<Post> getPostById(@Path("id") int id);


    @GET("posts")
    Call<List<Post>> getAll();

    @GET("users/{id}")
    Call<User> getUserById(@Path("id") int id);

}
