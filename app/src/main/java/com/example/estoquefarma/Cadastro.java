package com.example.estoquefarma;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



    public class Cadastro extends AppCompatActivity {
        private EditText productName, productPrice, productQuantity;
        private Spinner categorySpinner;
        private Button saveButton;
        private SQLiteDatabase db;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro);

            productName = findViewById(R.id.product_name);
            categorySpinner = findViewById(R.id.category_spinner);
            productPrice = findViewById(R.id.product_price);
            productQuantity = findViewById(R.id.product_quantity);
            saveButton = findViewById(R.id.save_button);
            db = new DatabaseHelper(this);

            saveButton.setOnClickListener(v -> {
                String name = productName.getText().toString().trim();
                String category = categorySpinner.getSelectedItem().toString();
                double price = Double.parseDouble(productPrice.getText().toString().trim());
                int quantity = Integer.parseInt(productQuantity.getText().toString().trim());

                if (db.addProducct(name, category, price, quantity)) {
                    Toast.makeText(AddProductActivity.this, "Produto adicionado com sucesso.", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(AddProductActivity.this, "Erro ao adicionar produto.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
