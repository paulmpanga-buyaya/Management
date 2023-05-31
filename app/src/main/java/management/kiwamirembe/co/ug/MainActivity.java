package management.kiwamirembe.co.ug;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> groupList;
    private HashMap<String, List<String>> childList;

    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the ExpandableListView and its adapter
        expandableListView = findViewById(R.id.expandableListView);
        prepareData();

        // Create an adapter instance and set it to the ExpandableListView
        expandableListAdapter = new CustomExpandableListAdapter(this, groupList, childList);
        expandableListView.setAdapter(expandableListAdapter);

        fragmentContainer = findViewById(R.id.rightFragmentContainer);

        //ExpandableListView expandableListView = findViewById(R.id.expandableListView);
        ExpandableListAdapter expandableListAdapter = expandableListView.getExpandableListAdapter();

        int groupCount = expandableListAdapter.getGroupCount();
        for (int i = 0; i < groupCount; i++) {
            expandableListView.expandGroup(i);
        }


        // Set a listener for child item clicks
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            String selectedChild = childList.get(groupList.get(groupPosition)).get(childPosition);
            //Toast.makeText(getApplicationContext(), "Selected: " + selectedChild, Toast.LENGTH_SHORT).show();
            switch (selectedChild){
                case "All Products":
                    // Execute function for group 1, child 0
                    loadAllProductsFragment();
                    break;
                case "Inventory":
                    // Execute function for group 1, child 1
                    loadInventoryFragment();
                    break;
                case "Product Categories":
                    // Execute function for group 1, child 1
                    loadProductCategoriesFragment();
                    break;
                // Add more cases as needed for group 1
                case "Receipts":
                    // Execute function for group 1, child 0
                    loadReceiptsFragment();
                    break;
                case "Sales Reports":
                    // Execute function for group 1, child 1
                    loadSalesReportsFragment();
                    break;
                case "All Customers":
                    // Execute function for group 1, child 1
                    loadAllCustomersFragment();
                    break;
                // Add more cases as needed for group 1
            }
            return false;
        });

    }

    private void loadAllCustomersFragment(){
        AllCustomersFragment allCustomersFragment = new AllCustomersFragment();
        // Begin the fragment transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Replace the fragment container with YourFragment
        fragmentTransaction.replace(R.id.rightFragmentContainer, allCustomersFragment);
        // Commit the transaction
        fragmentTransaction.commit();
    }

    private void loadAllProductsFragment(){
        AllProductsFragment allProductsFragment = new AllProductsFragment();
        // Begin the fragment transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Replace the fragment container with YourFragment
        fragmentTransaction.replace(R.id.rightFragmentContainer, allProductsFragment);
        // Commit the transaction
        fragmentTransaction.commit();
    }

    private void loadInventoryFragment(){
        InventoryFragment inventoryFragment = new InventoryFragment();
        // Begin the fragment transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Replace the fragment container with YourFragment
        fragmentTransaction.replace(R.id.rightFragmentContainer, inventoryFragment);
        // Commit the transaction
        fragmentTransaction.commit();
    }

    private void loadProductCategoriesFragment(){
        ProductCategoriesFragment productCategoriesFragment = new ProductCategoriesFragment();
        // Begin the fragment transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Replace the fragment container with YourFragment
        fragmentTransaction.replace(R.id.rightFragmentContainer, productCategoriesFragment);
        // Commit the transaction
        fragmentTransaction.commit();
    }

    private void loadSalesReportsFragment(){
        SalesReportsFragment salesReportsFragment = new SalesReportsFragment();
        // Begin the fragment transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Replace the fragment container with YourFragment
        fragmentTransaction.replace(R.id.rightFragmentContainer, salesReportsFragment);
        // Commit the transaction
        fragmentTransaction.commit();
    }

    private void loadReceiptsFragment(){
        ReceiptsFragment receiptsFragment = new ReceiptsFragment();
        // Begin the fragment transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Replace the fragment container with YourFragment
        fragmentTransaction.replace(R.id.rightFragmentContainer, receiptsFragment);
        // Commit the transaction
        fragmentTransaction.commit();
    }

    // Prepare sample data for the ExpandableListView
    private void prepareData() {
        groupList = new ArrayList<>();
        childList = new HashMap<>();

        groupList.add("Products");
        groupList.add("Sales");
        groupList.add("Customers");

        List<String> group1Items = new ArrayList<>();
        group1Items.add("All Products");
        group1Items.add("Inventory");
        group1Items.add("Product Categories");

        List<String> group2Items = new ArrayList<>();
        group2Items.add("Receipts");
        group2Items.add("Sales Reports");

        List<String> group3Items = new ArrayList<>();
        group3Items.add("All Customers");

        childList.put(groupList.get(0), group1Items);
        childList.put(groupList.get(1), group2Items);
        childList.put(groupList.get(2), group3Items);
    }
}