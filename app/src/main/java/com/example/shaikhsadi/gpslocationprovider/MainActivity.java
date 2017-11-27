package com.example.shaikhsadi.gpslocationprovider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private LocationManager locationManager;

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;

    public double lat;
    public double longt;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);



        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.INTERNET
            },10);

            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                3000,   // 3 sec
                50, this);

        /********* After registration onLocationChanged method  ********/
        /********* called periodically after each 3 sec ***********/

    }



    @Override
    public void onLocationChanged(Location location) {


        String str = "Latitude: "+location.getLatitude()+" Longitude: "+location.getLongitude();

        lat = location.getLatitude();

        longt = location.getLongitude();

        Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();

        chg(lat,longt);


    }


    public void chg(double lat,double longt)
    {
        double lt,ln;

        lt=lat;
        ln=longt;
        int r=6371;

        double x1=22.998943;
        double y1=89.818809;

        double dLat1 = Math.toRadians(lt-x1);
        double dLon1 = Math.toRadians(ln-y1);

        double a1=Math.sin(dLat1/2)*Math.sin(dLat1/2)+Math.cos(Math.toRadians(lt))*Math.cos(Math.toRadians(x1))*Math.sin(dLon1/2)*Math.sin(dLon1/2);

        double c1 = 2*Math.atan2(Math.sqrt(a1), Math.sqrt(1-a1));

        double d1 = r*c1;

        textView1=(TextView)findViewById(R.id.textView1);

        textView1.setText("Gopalganj hospital is  "+d1+" Km");




        double x2=23.0128;
        double y2=89.833;

        double dLat2 = Math.toRadians(lt-x2);
        double dLon2 = Math.toRadians(ln-y2);

        double a2=Math.sin(dLat2/2)*Math.sin(dLat2/2)+Math.cos(Math.toRadians(lt))*Math.cos(Math.toRadians(x2))*Math.sin(dLon2/2)*Math.sin(dLon2/2);

        double c2 = 2*Math.atan2(Math.sqrt(a2), Math.sqrt(1-a2));

        double d2 = r*c2;

        textView2=(TextView)findViewById(R.id.textView2);

        textView2.setText(" Gopalganj Thana is  "+d2+" Km");




        double x3=23.022233;
        double y3=89.833298;

        double dLat3 = Math.toRadians(lt-x3);
        double dLon3 = Math.toRadians(ln-y3);

        double a3=Math.sin(dLat3/2)*Math.sin(dLat3/2)+Math.cos(Math.toRadians(lt))*Math.cos(Math.toRadians(x3))*Math.sin(dLon3/2)*Math.sin(dLon3/2);

        double c3 = 2*Math.atan2(Math.sqrt(a3), Math.sqrt(1-a3));

        double d3 = r*c3;

        textView3=(TextView)findViewById(R.id.textView3);

        textView3.setText("Gopalganj BUS Terminal is  "+d3+" Km");



        double x4=23.0064;
        double y4=89.8286;

        double dLat4 = Math.toRadians(lt-x4);
        double dLon4 = Math.toRadians(ln-y4);

        double a4=Math.sin(dLat4/2)*Math.sin(dLat4/2)+Math.cos(Math.toRadians(lt))*Math.cos(Math.toRadians(x4))*Math.sin(dLon4/2)*Math.sin(dLon4/2);

        double c4 = 2*Math.atan2(Math.sqrt(a4), Math.sqrt(1-a4));

        double d4 = r*c4;

        textView4=(TextView)findViewById(R.id.textView4);

        textView4.setText(" Gopalganj post office is  "+d4+" Km");





        double x5=23.010255;
        double y5=89.822787;

        double dLat5 = Math.toRadians(lt-x5);
        double dLon5 = Math.toRadians(ln-y5);

        double a5=Math.sin(dLat5/2)*Math.sin(dLat5/2)+Math.cos(Math.toRadians(lt))*Math.cos(Math.toRadians(x5))*Math.sin(dLon5/2)*Math.sin(dLon5/2);

        double c5 = 2*Math.atan2(Math.sqrt(a5), Math.sqrt(1-a5));

        double d5 = r*c5;

        textView5=(TextView)findViewById(R.id.textView5);

        textView5.setText("Gopalganj city Clinic is  "+d5+" Km");

    }


    @Override
    public void onProviderDisabled(String provider) {

        /******** Called when User off Gps *********/
        Intent intent= new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(intent);

        Toast.makeText(getBaseContext(), "Gps turned off ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderEnabled(String provider) {

        /******** Called when User on Gps  *********/


        Toast.makeText(getBaseContext(), "Gps turned on ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }

}