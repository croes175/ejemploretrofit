package miprimeraapp.com.ejemploretrofit;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import miprimeraapp.com.ejemploretrofit.models.Adapters;
import miprimeraapp.com.ejemploretrofit.remove.ApiUtils;
import miprimeraapp.com.ejemploretrofit.remove.Datos;
import miprimeraapp.com.ejemploretrofit.remove.Earthquake;
import miprimeraapp.com.ejemploretrofit.remove.MyEartQuake;
import miprimeraapp.com.ejemploretrofit.remove.Webservices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/* hola a todos prueba1*/
public class MainActivity extends AppCompatActivity {
    public ListView listView;
public Button llamdo;
    public  ArrayList<String>p,p1;
    public ArrayList<String>p2;
public Webservices webservices;
    public static List<Earthquake> DatosList;
    public Adapters adapters;
public static String URL="http://api.geonames.org/earthquakesJSON?north=44.1&south=-0.3012878&east=-79.4&west=-61.0184629&username=javierjordan23";
        public static  String CLASS_TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
listView=findViewById(R.id.list_item1);
webservices=ApiUtils.getDataFields();
DatosList=new ArrayList<Earthquake>();
llamdo=findViewById(R.id.button);
p1=new ArrayList<String>();
        p2=new ArrayList<String>();
        p=new ArrayList<String>();
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

    p.add(response.body().getEarthquakes().get(i).getLng().toString());
    p1.add(response.body().getEarthquakes().get(i).getLat().toString());
    p2.add(response.body().getEarthquakes().get(i).getDatetime());



                        }

                        DatosList=response.body().getEarthquakes();
                        MainActivity.DatosList=response.body().getEarthquakes();
                        adapters=new Adapters(MainActivity.this,DatosList) ;
                        listView.setAdapter(adapters);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Toast.makeText(getApplicationContext(),DatosList.get(position).getDatetime(),Toast.LENGTH_LONG).show();


                                Intent i=new Intent(MainActivity.this,MapsActivity.class);
                                i.putExtra("lat",DatosList.get(position).getLat());
                                i.putExtra("long",DatosList.get(position).getLng());
                                i.putExtra("name",DatosList.get(position).getDatetime());
i.putExtra("codigo","primero");


                                startActivity(i);


                            }

                        });
                        llamdo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent i=new Intent(MainActivity.this,MapsActivity.class);
                             i.putExtra("r1",p);
                             i.putExtra("r2",p1);
                             i.putExtra("r3",p2);
                                i.putExtra("codigo","segundo");
                                startActivity(i);
                            }
                        });




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
    public void click(View view)
    { Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("ListaObjetos", (ArrayList<? extends Parcelable>) DatosList);
        Intent i=new Intent(MainActivity.this,MapsActivity.class);
        i.putExtras(bundle);
        i.putExtra("codigo","segundo");
        startActivity(i);




    }






    }
    /*  persistencia
    *
    * proyecto que API se puede usar como manipularla
    * retrofit
    * Get started
    * json validator
    * */

