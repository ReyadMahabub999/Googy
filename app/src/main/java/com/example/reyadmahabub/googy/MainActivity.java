package com.example.reyadmahabub.googy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    public Service service;
    public List<Response>responses;
    public ResponseAdapter adapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        recyclerView=findViewById( R.id.showTitleRV );


        Retrofit retrofit=new Retrofit.Builder().baseUrl( BASE_URL ).addConverterFactory( GsonConverterFactory.create() )
                .build();

       service= retrofit.create( Service.class );
       Call<List<Response>>call=service.getResponse();
       call.enqueue( new Callback<List<Response>>() {
           @Override
           public void onResponse(Call<List<Response>> call, retrofit2.Response<List<Response>> response) {
               if (response.code()==200){
                  responses= response.body();

                   Log.e("MainActivity",responses.get( 1 ).getTitle());
                   Toast.makeText( MainActivity.this, "Welcome", Toast.LENGTH_SHORT ).show();
               }
               adapter=new ResponseAdapter( MainActivity.this,responses );
               LinearLayoutManager llm=new LinearLayoutManager( MainActivity.this );
               llm.setOrientation( LinearLayoutManager.VERTICAL );
               recyclerView.setLayoutManager( llm );
               recyclerView.setAdapter( adapter );


           }

           @Override
           public void onFailure(Call<List<Response>> call, Throwable t) {

           }
       } );
    }
}
