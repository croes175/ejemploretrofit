package miprimeraapp.com.ejemploretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import miprimeraapp.com.ejemploretrofit.remove.ApiUtils;
import miprimeraapp.com.ejemploretrofit.remove.MyEartQuake;
import miprimeraapp.com.ejemploretrofit.remove.Webservices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
public Button llamdo;
public Webservices webservices;
public static String URL="http://api.geonames.org/earthquakesJSON?north=44.1&south=-0.3012878&east=-79.4&west=-61.0184629&username=javierjordan23";
        public static  String CLASS_TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

webservices=ApiUtils.getDataFields();
llamdo=findViewById(R.id.button);
llamdo.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        webservices.getEartquakeData(URL).enqueue(new Callback<MyEartQuake>() {
            @Override
            public void onResponse(Call<MyEartQuake> call, Response<MyEartQuake> response) {
                if(response.isSuccessful())
                {String response1=new Gson().toJson(response.body());
                    Log.e(CLASS_TAG,"response JSON"+response1);
                    try {
                        JSONObject terremoto=new JSONObject(response1);
                        Log.e(CLASS_TAG,"JSON"+terremoto);
                        JSONArray jsonArray=terremoto.getJSONArray("earthquakes");
                        Log.e(CLASS_TAG,"JSON"+jsonArray);
                        for(int i=0;i<response.body().getEarthquakes().size();i++)
                        {Log.e(CLASS_TAG,"response1111 "+response.body().getEarthquakes().get(i).getDatetime());
                            Log.e(CLASS_TAG,"response1111 "+response.body().getEarthquakes().get(i).getLat());


                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
                else{
                    int code=response.code();
                    Log.e(CLASS_TAG,"code"+code);


                }
            }

            @Override
            public void onFailure(Call<MyEartQuake> call, Throwable t) {
             Log.e(CLASS_TAG,"onFailure"+t.getMessage());
            }
        });
    }
});





    }
    /*  persistencia
    *
    * proyecto que API se puede usar como manipularla
    * retrofit
    * Get started
    * json validator
    * */
}
