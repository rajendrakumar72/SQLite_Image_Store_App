package com.mrkumar.sqlitedbstoreapp.network;

import com.mrkumar.sqlitedbstoreapp.model.ResponseApi;
import com.mrkumar.sqlitedbstoreapp.model.ResponseApiItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkApiInterface {
    // https://simplifiedcoding.net/demos/marvel/
    @GET("marvel/")
    Call<List<ResponseApiItem>>getDataFromApi();
}
