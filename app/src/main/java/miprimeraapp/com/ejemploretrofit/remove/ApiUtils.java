package miprimeraapp.com.ejemploretrofit.remove;



public class ApiUtils {
    public static final String BASE_URL="http://api.geonames.org/";
    public static final String BASE_URL_AQ="http://qa.api.geonames.org/";
    public static Webservices getDataFields()
    {
        return RetrofitClient.getClient(BASE_URL).create(Webservices.class);


    }
    public static Webservices getDataFieldsQA()
    {
        return RetrofitClient.getClient(BASE_URL_AQ).create(Webservices.class);


    }
}
