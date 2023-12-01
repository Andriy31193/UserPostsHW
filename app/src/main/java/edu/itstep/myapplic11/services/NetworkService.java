package edu.itstep.myapplic11.services;

import edu.itstep.myapplic11.interfaces.api.API;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService networkService;
    private final API api;

    private NetworkService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(API.class);
    }

    public static NetworkService getInstance() {
        if (networkService == null)
            networkService = new NetworkService();

        return networkService;
    }

    public API getApi() {
        return api;
    }
}