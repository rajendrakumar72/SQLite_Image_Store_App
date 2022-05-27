package com.mrkumar.sqlitedbstoreapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.mrkumar.sqlitedbstoreapp.adpter.HeroesAdapter;
import com.mrkumar.sqlitedbstoreapp.database.DatabaseHelper;
import com.mrkumar.sqlitedbstoreapp.model.ResponseApi;
import com.mrkumar.sqlitedbstoreapp.model.ResponseApiItem;
import com.mrkumar.sqlitedbstoreapp.network.NetworkApiInterface;
import com.mrkumar.sqlitedbstoreapp.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    NetworkApiInterface apiInterface;
    DatabaseHelper databaseHelper;
    RecyclerView recyclerView;
    HeroesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv_design);

        databaseHelper = new DatabaseHelper(this);


    apiInterface= RetrofitClient.getClient().create(NetworkApiInterface.class);
        Call<List<ResponseApiItem>> call=apiInterface.getDataFromApi();

        call.enqueue(new Callback<List<ResponseApiItem>>() {
            @Override
            public void onResponse(Call<List<ResponseApiItem>> call, Response<List<ResponseApiItem>> response) {
                Log.d("TAG", "code: "+response.code());
                if (response.code()==200) {
//                   databaseHelper.insert(response.body());
                    Log.d("TAG", "stored: "+ databaseHelper.insert(response.body()));
               }
            }

            @Override
            public void onFailure(Call<List<ResponseApiItem>> call, Throwable t) {
                Log.e("TAG", "onFailure: "+t.getLocalizedMessage());
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new HeroesAdapter(databaseHelper.getAllHeros(),this);
        recyclerView.setAdapter(adapter);

//        Log.d("TAG", "getDataFromDb: "+.get(0).getBio());
}
}