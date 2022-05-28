package com.application.apitestingapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RetrofitAPI apiInterface;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        apiInterface = ApiIntence.getRetrofit().create(RetrofitAPI.class);

        apiInterface.getPost().enqueue(new Callback<List<ApiModels>>() {
            @Override
            public void onResponse(Call<List<ApiModels>> call, Response<List<ApiModels>> response) {

                if(response.body().size() > 0){

                    List<ApiModels> modelsPojo = response.body();
                    Adapter adapter=new Adapter(modelsPojo, MainActivity.this);
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);

                    Toast.makeText(MainActivity.this, "List is not Empty", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "List is Empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ApiModels>> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
               // Log.e("myerror",t.getLocalizedMessage());
            }
        });
    }
}