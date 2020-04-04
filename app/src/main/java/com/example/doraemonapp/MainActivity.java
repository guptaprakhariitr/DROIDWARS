package com.example.doraemonapp;
import java.util.Random;
import com.example.doraemonapp.ui.Bookmarks;
import android.Manifest;
import android.app.Activity;

import android.content.pm.PackageManager;

import android.location.Location;

import android.os.Bundle;

import com.example.doraemonapp.ui.APIclient;
import com.example.doraemonapp.ui.APIclient_place;
import com.example.doraemonapp.ui.APIinterface;
import com.example.doraemonapp.ui.APIinterface_place;
import com.example.doraemonapp.ui.APIinterface_random;
import com.google.android.gms.location.FusedLocationProviderClient;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import android.view.inputmethod.InputMethodManager;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.doraemonapp.ui.Data;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
import android.telephony.SmsManager;

import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

public class MainActivity extends AppCompatActivity {



    DatabaseReference databaseBookmark;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public void fetchData(View view) {
        APIinterface apiInterface;
        Toast.makeText(MainActivity.this, "WORKING", Toast.LENGTH_SHORT).show();
        apiInterface = APIclient.getClient().create(APIinterface.class);

        Call<Data> call = apiInterface.getHistoryData();
        call.enqueue(new Callback<Data>() {
                         @Override
                         public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {

                             if (response.code() == 200) {
                                 if (response.body() != null) {
                                     TextView text1;
                                     text1 = findViewById(R.id.text_dashboard);

                                     Data data = response.body();
                                     Random ra = new Random();
                                     int r = ra.nextInt(10);

                                     text1.setText((data.getdate()) + "\n YEAR:" + (data.getdata().getEvents().get(r).getyear()) + "\n" + (data.getdata().getEvents().get(r).gettext()));
                                     Toast.makeText(MainActivity.this, "SUCCESSFUL", Toast.LENGTH_SHORT).show();
                                 }
                             } else {
                                 Toast.makeText(MainActivity.this, "UNSUCCESSFUL", Toast.LENGTH_SHORT).show();
                             }
                         }

                         @Override
                         public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {
                             Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                         }
                     }
        );
    }

    public void fetchData2(View view) {
        Toast.makeText(MainActivity.this, "WORKING", Toast.LENGTH_SHORT).show();
        APIinterface_random apiInterface2;
        Random ra = new Random();
        int day = ra.nextInt(28) + 1;
        int month = ra.nextInt(12) + 1;
        apiInterface2 = APIclient.getClient().create(APIinterface_random.class);

        Call<Data> call2 = apiInterface2.getRandomHistory(month, day);
        call2.enqueue(new Callback<Data>() {
                          @Override
                          public void onResponse(@NonNull Call<Data> call, @NonNull Response<Data> response) {
                              if (response.code() == 200) {
                                  if (response.body() != null) {
                                      TextView text1;
                                      text1 = findViewById(R.id.text_dashboard);
                                      Data data = response.body();
                                      Random ra2 = new Random();
                                      int r = ra2.nextInt(10);


                                      text1.setText((data.getdate()) + "\n YEAR:" + String.valueOf(data.getdata().getEvents().get(r).getyear()) + "\n" + String.valueOf(data.getdata().getEvents().get(r).gettext()));
                                      Toast.makeText(MainActivity.this, "SUCCESSFUL", Toast.LENGTH_SHORT).show();

                                  }
                              } else {
                                  Toast.makeText(MainActivity.this, "UNSUCCESSFUL", Toast.LENGTH_SHORT).show();
                              }
                          }

                          @Override
                          public void onFailure(@NonNull Call<Data> call, @NonNull Throwable t) {
                              Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                          }
                      }
        );
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    public void fetchLocationData(View view) {
        EditText mEdit;
        mEdit = findViewById(R.id.text_notifications);
        Toast.makeText(MainActivity.this, "WORKING", Toast.LENGTH_SHORT).show();
        APIinterface_place RetrofitImageAPI;

        RetrofitImageAPI = APIclient_place.getClient().create(APIinterface_place.class);
        Call<com.example.doraemonapp.ui.anywheredoor.Data> call = RetrofitImageAPI.getLocationData("query", "2", "pageimages|pageterms", (mEdit.getText().toString()), "json");
        call.enqueue(new Callback<com.example.doraemonapp.ui.anywheredoor.Data>() {
            @Override
            public void onResponse(@NonNull Call<com.example.doraemonapp.ui.anywheredoor.Data> call, @NonNull Response<com.example.doraemonapp.ui.anywheredoor.Data> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        TextView text1 = findViewById(R.id.location_description);
                        ImageView image = findViewById(R.id.image_place);

                        com.example.doraemonapp.ui.anywheredoor.Data data = response.body();
                        try {
                            text1.setText((data.getquery().getPages().get(0).getTitle()) + "\n" + (data.getquery().getPages().get(0).getTerms().getDescription().get(0)));
                            Log.d("see", String.valueOf(data.getquery().getPages().get(0).getTerms().getDescription().get(0)));
                            Picasso.get().load(String.valueOf(data.getquery().getPages().get(0).getThumbnail().getSource())).into(image);
                            Toast.makeText(MainActivity.this, "SUCCESSFUL", Toast.LENGTH_SHORT).show();
                        } catch (NullPointerException n) {
                            Toast.makeText(MainActivity.this, "DATA NOT PRESENT", Toast.LENGTH_SHORT).show();
                        }
                        hideSoftKeyboard(MainActivity.this);
                    }
                } else {
                    Toast.makeText(MainActivity.this, "UNSUCCESSFUL", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<com.example.doraemonapp.ui.anywheredoor.Data> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void GETLocation(View view) {


        Toast.makeText(MainActivity.this, "WORKING", Toast.LENGTH_SHORT).show();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 400
            );
        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS}, 400
                );
                Toast.makeText(MainActivity.this, "TURN ON GPS", Toast.LENGTH_SHORT).show();
            } else {
                final FusedLocationProviderClient locationClient = getFusedLocationProviderClient(this);
                locationClient.getLastLocation()
                        .addOnSuccessListener(new OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location) {

                                // GPS location can be null if GPS is switched off
                                if (location != null) {
                                    SmsManager sms = SmsManager.getDefault();
                                    String phoneNumber = "PUT_YOUR_MOBILE_NO";
                                    String lat = String.valueOf(location.getLatitude());
                                    String lng = String.valueOf(location.getLongitude());
                                    String message = "http://maps.google.com/?q=" + lat + "," + lng;
                                    String message2 = "HELP ME==> CLICK THE LINK TO GET TO ME";
                                    sms.sendTextMessage(phoneNumber, null, message, null, null);
                                    sms.sendTextMessage(phoneNumber, null, message2, null, null);
                                    Toast.makeText(MainActivity.this, "SENT", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "GPS OFF OR NO LAST LOCATION( Catched location)", Toast.LENGTH_SHORT).show();

                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "FAILED REQUEST", Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        }
    }

    public void Bookmark(View v) {

        databaseBookmark = FirebaseDatabase.getInstance().getReference("FACTS");
        TextView text = findViewById(R.id.text_dashboard);
        View vo=getLayoutInflater().inflate(R.layout.fragment_dashboard,null);
        listView = vo.findViewById(R.id.listbookmark);
        final String Databook=text.getText().toString();
        if(!TextUtils.isEmpty(Databook)){
           final String id=databaseBookmark.push().getKey();
            Bookmarks bookmarks=new Bookmarks(Databook,id);
            databaseBookmark.child(id).setValue(bookmarks);
            Toast.makeText(this, "SAVED TO DATABASE", Toast.LENGTH_LONG).show();
        }

       else {
            Toast.makeText(this, "NO FACT TO BOOKMARK", Toast.LENGTH_LONG).show();
        }

    }



}
