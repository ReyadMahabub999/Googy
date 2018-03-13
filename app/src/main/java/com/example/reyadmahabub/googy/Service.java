package com.example.reyadmahabub.googy;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ReyadMahabub on 3/12/2018.
 */

public interface Service {
    @GET("posts")
    Call<List<Response>>getResponse();
}
