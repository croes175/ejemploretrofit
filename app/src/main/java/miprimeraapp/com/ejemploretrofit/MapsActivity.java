package miprimeraapp.com.ejemploretrofit;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import miprimeraapp.com.ejemploretrofit.remove.Earthquake;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Bundle q;
   public LatLng sydney;
    private static ArrayList<String>p,p1;
    private static ArrayList<String>p2;
    private List<Earthquake> ListObjetos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
         q=getIntent().getExtras();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Log.e(MapsActivity.class.getSimpleName(),"Llegamos"+q.getDouble("lat"));

        Toast.makeText(getApplicationContext(),"llegamos al mapa",Toast.LENGTH_LONG).show();
        if(q.get("codigo").equals("primero")){
        // Add a marker in Sydney and move the camera
         sydney = new LatLng(q.getDouble("lat"), q.getDouble("Long"));
        mMap.addMarker(new MarkerOptions().position(sydney).title(q.getString("name")));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }


        if(q.get("codigo").equals("segundo")){
p=q.getStringArrayList("r1");
p1=q.getStringArrayList("r2");
p2=q.getStringArrayList("r3");
for(int k=0;k<p.size();++k)
{ sydney = new LatLng(Double.parseDouble(p.get(k)),Double.parseDouble(p1.get(k)));
    Toast.makeText(getApplicationContext(),p.get(k)+" y "+p1.get(k),Toast.LENGTH_LONG).show();
    mMap.addMarker(new MarkerOptions().position(sydney).title(p2.get(k)));






}


        }

    }
}
