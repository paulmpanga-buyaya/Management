package management.kiwamirembe.co.ug;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AllProductsFragment extends Fragment {
    public AllProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_all_products, container, false);

        TextInputLayout categoryTextInputLayout = root.findViewById(R.id.categoryTextInputLayout);
        final TextInputEditText categoryTextInputEditText = root.findViewById(R.id.categoryTextInputEditText);
        categoryTextInputEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display dropdown menu or show a dialog with the category options
                showCategoryDropdown();
            }
        });

        return root;
    }
    // Method to show the category dropdown menu
    private void showCategoryDropdown() {
        final String[] categories = {"PVC Pipes", "PVC Fittings", "HDPE Pipes", "HDPE Rolls", "HDPE Fittings", "PPR Pipes", "PPR Fittings"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Select a category");
        builder.setItems(categories, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selectedCategory = categories[which];
                Toast.makeText(getActivity(), selectedCategory, Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

}