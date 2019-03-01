package miprimeraapp.com.ejemploretrofit.remove;

public class Datos {
public String Datetime;
public double longi;
public double lat;
public Datos(double longi , double lat,String Datetime)
{this.Datetime=Datetime;
this.lat=lat;
this.longi=longi;




}

public double getLat()
{return  lat;}

public  double getLongi()
{return  longi;}
public  String getDatetime()
{return Datetime;


}

}
