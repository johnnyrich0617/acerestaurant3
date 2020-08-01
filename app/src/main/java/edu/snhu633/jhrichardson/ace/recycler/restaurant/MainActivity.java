package edu.snhu633.jhrichardson.ace.recycler.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import edu.snhu633.jhrichardson.ace.recycler.restaurant.list.adapters.RecyclerViewListAdapter;
import edu.snhu633.jhrichardson.ace.recycler.restaurant.model.AppMainMenuModel;

/**
 * This activity sets up the main menu for the application.  It uses a RecyclerView and
 * GridLayoutManager to create and manage the children in the list.  It is constructed as
 * a "List of Links" pattern, but displayed as cards.
 *
 * @author jhrichardson
 */
public class MainActivity extends AppCompatActivity implements RecyclerViewListAdapter.ItemListener {

    RecyclerView recyclerView;
    ArrayList<AppMainMenuModel> menuItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create the menu contents and set the view
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.menuItemList = getMenuItems();

        //create the adapter and register the ItemListener as this class
        RecyclerViewListAdapter adapter = new RecyclerViewListAdapter(menuItemList, this,
                this);
        recyclerView.setAdapter(adapter);

        // create the GridLayOutManager to manage the children in the list
        GridLayoutManager manager = new GridLayoutManager(this, 2,
                GridLayoutManager.VERTICAL, true);
        recyclerView.setLayoutManager(manager);

    }

    /**
     * The implementation of the ItemListener onItemClick callback
     * @param item  The listItem that has been clicked
     *
     * @see edu.snhu633.jhrichardson.ace.recycler.restaurant.model.AppMainMenuModel
     */
    @Override
    public void onItemClick(AppMainMenuModel item) {
        /*
        From the invoking ListItem, determine which child has been clicked
        and start the associated Activity.

        For this class I was responsible for the functionality set for the AboutUs and Directions
        Activities.
         */
        switch(item.getText()) {
            case "Our Menu":
            case "Mobile Order":
            case "Reservations":
            case "Beverage Mixer":
            case "Calorie Counter":
            case "Catering":
                Toast.makeText(getApplicationContext(), item.getText() + " is clicked",
                        Toast.LENGTH_SHORT).show();
                break;
            case "AboutUs":
                Intent aboutusIntent = new Intent(MainActivity.this,
                        AboutUsViewActivity.class);
                startActivity(aboutusIntent);
                break;
            case "Directions":
                try {
                    double restLat = Double.parseDouble(getResources().getString(R.string.main_location_lat));
                    double restLong = Double.parseDouble(getResources().getString(R.string.main_location_long));
                    Intent mapIntent = new Intent(MainActivity.this,
                            AceMapsActivity.class);
                    mapIntent.putExtra(getResources().getString(R.string.const_lat_key), restLat);
                    mapIntent.putExtra(getResources().getString(R.string.const_long_key), restLong);
                    startActivity(mapIntent);
                }
                catch (NumberFormatException nfe){
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.error_latlong_parse_exception),
                            Toast.LENGTH_LONG).show();
                    nfe.printStackTrace();
                }
        }


    }

    /**
     * Private Utility Method to create the menu list of ListItems
     * @return  ArrayList of AppMainMenuModel
     * @see edu.snhu633.jhrichardson.ace.recycler.restaurant.model.AppMainMenuModel
     */
    private ArrayList<AppMainMenuModel> getMenuItems() {
        int index = 0;
        ArrayList<AppMainMenuModel> alist = new ArrayList<>();
        String[] menuItemsStrings = getResources().getStringArray(R.array.main_menu_items);
        for(String item : menuItemsStrings) {
           alist.add(index, new AppMainMenuModel(item,
                   getImageForItem(item),
                   getColorForItem(item)));
        }
        return alist;
    }

    /**
     * Private Utility Method top fetch the associated color
     * for a menu item tile
     * @param menuItem  the menu item to lookup
     * @return The string representation of the color
     */
    private String getColorForItem(String menuItem) {
        if(menuItem.contains("Menu")){
            return getResources().getString(R.string.menu_item);
        }
        else if(menuItem.contains("Mobile")){
            return getResources().getString(R.string.mobile_item);
        }
        else if(menuItem.contains("Reservation")) {
            return getResources().getString(R.string.reservation_item);
        }
        else if(menuItem.contains("Beverage")){
            return getResources().getString(R.string.beverage_item);
        }
        else if(menuItem.contains("Calorie")) {
            return getResources().getString(R.string.calorie_item);
        }
        else if(menuItem.contains("Catering")) {
            return getResources().getString(R.string.catering_item);
        }
        else if(menuItem.contains("Directions")) {
            return getResources().getString(R.string.directions_item);
        }
        else if(menuItem.contains("AboutUs")) {
            return getResources().getString(R.string.aboutus_item);
        }
        else {
                return getResources().getString(R.string.aboutus_item);
            }
    }

    /**
     * Private Utility Method top fetch the associated image
     * for a menu item tile
     * @param menuItem  the menu item to lookup
     * @return The int representation of the image
     */
    private int getImageForItem(String menuItem) {
        if(menuItem.contains("Menu")){
            return R.drawable.menu;
        }
        else if(menuItem.contains("Mobile")){
            return R.drawable.mobileorder;
        }
        else if(menuItem.contains("Reservation")) {
            return R.drawable.reservations;
        }
        else if(menuItem.contains("Beverage")){
            return R.drawable.berverage;
        }
        else if(menuItem.contains("Calorie")) {
            return R.drawable.calorie;
        }
        else if(menuItem.contains("Catering")) {
            return R.drawable.catering;
        }
        else if(menuItem.contains("Directions")) {
            return R.drawable.directions;
        }
        else if(menuItem.contains("AboutUs")) {
            return R.drawable.aboutus;
        }
        else
            return R.drawable.ace_logo;
    }
}