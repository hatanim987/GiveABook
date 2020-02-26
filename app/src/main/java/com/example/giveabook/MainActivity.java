package com.example.giveabook;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";

    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult=findViewById(R.id.text_view_result);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://dheo.com/ops/qr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi=retrofit.create(JsonPlaceHolderApi.class);
        Call<Post> call=jsonPlaceHolderApi.getPosts("yrpfSmeRHn","340489","1");

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                //Log.e(TAG,"OnResponse: "+response.toString());
                //Log.e(TAG,"Response Data: "+response.body().toString());
                textViewResult.setText(response.body().getM().getData().getDelivery_start_step()+response.body().getM().getData().getIs_cancelled()+
                        response.body().getM().getData().getDelivery_inprogress_step());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e(TAG,"Onfailer something went wrong"+t.getMessage());
                textViewResult.setText(t.getMessage());
            }
        });

    }


}
