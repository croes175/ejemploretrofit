package miprimeraapp.com.ejemploretrofit.remove;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Webservices {
    @GET
Call<MyEartQuake> getEartquakeData(@Url String url);


}
