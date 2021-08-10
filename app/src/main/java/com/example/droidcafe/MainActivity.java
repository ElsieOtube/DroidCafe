package com.example.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.droidcafe.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private String mOrderMessage;
    public static final String EXTRA_ORDER_KEY= "MY KEY FOR ORDER MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

     //   NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
      //  appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
      //  NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //implement an explicit intent for opening the order activity
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY,mOrderMessage);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        //create a switch case block to handle the clicks on the manu items
        switch (item.getItemId()){
            case R.id.action_order:
                //open order activity
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY,mOrderMessage);
                startActivity(intent);
                return true;
            case R.id.action_call:
                //implement an implicit intent that calls your cafe number
                Uri uri = Uri.parse("tel:0793989320");
                Intent myIntent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(myIntent);
                return true;
            //ASSSIGNMENT
            //ADD THE CASE FOR THE OPTIONS
            //ENSURE THE ITEM ABOUT US OPENS A WEB PAGE AND LOCATE US ITEM OPEN A GOOGLE MAP SHOWING YOUR LATITUDE AND LONGITUDE
        }

        return super.onOptionsItemSelected(item);

    }

   // @Override
   // public boolean onSupportNavigateUp() {
    //    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
     //   return NavigationUI.navigateUp(navController, appBarConfiguration)
       //         || super.onSupportNavigateUp();
   // }

    //A method for displaying toast messages
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void showIceCreamMessage(View view) {
        //define what will be done when the user clicks on the image view
        //e.g. //adding an item to shopping cart or in our case showing a toast

//        displayToast(getString(R.string.ice_cream_order));
        mOrderMessage = getString(R.string.ice_cream_order);
        displayToast(mOrderMessage);
    }

    public void showDonutOrderMessage(View view) {

//        displayToast(getString(R.string.donut_order));
        mOrderMessage = getString(R.string.donut_order);
        displayToast(mOrderMessage);
    }

    public void showFroyoOrderMessage(View view) {

//        displayToast(getString(R.string.froyo_order));
        mOrderMessage = getString(R.string.froyo_order);
        displayToast(mOrderMessage);
    }
}