package com.example.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    protected EditText editTextName, editTextPhoneNumber;
    protected Button addButton;

    protected RadioButton radioButtonMale, radioButtonFemale;
    protected ArrayAdapter listViewPeopleAdapter, listViewCountriesAdapter;
    protected ListView listViewPeople;
    protected Spinner spinnerCountries;
    protected List<Person> listPeople;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // The variable
        // Get view elements
        editTextName = findViewById(R.id.editTextName);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        addButton = findViewById(R.id.addButton);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        listViewPeople = findViewById(R.id.listViewPerson);
        spinnerCountries = findViewById(R.id.spinnerCountries);
        // Adapter
        String[] countries = new String[] {"Hà Nội", "Hồ Chí Minh", "Đà Nẵng", "Hải Phòng", "Cần Thơ", "Huế",
                "Nha Trang", "Vũng Tàu", "Đà Lạt", "Hải Dương", "Quy Nhơn", "Hòa Bình"};
        listViewCountriesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,countries);
        listViewCountriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountries.setAdapter(listViewCountriesAdapter);

        // Initialize List View With Some Elements (People)
        listPeople = new ArrayList<>();
        listPeople.add(new Person("Le Quang Vu","0981182171","Nam","Hải Dương"));
        listViewPeopleAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,listPeople);
        listViewPeople.setAdapter(listViewPeopleAdapter);
        // Click event
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidInputs()){
                    String newPersonName = editTextName.getText().toString();
                    String newPersonPhoneNumber = editTextPhoneNumber.getText().toString();
                    String gender = radioButtonMale.isChecked() ? "Nam" : "Nữ";
                    String address = spinnerCountries.getSelectedItem().toString();
                    Person newPerson = new Person(newPersonName, newPersonPhoneNumber, gender, address);
                    listPeople.add(newPerson);
                    listViewPeopleAdapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                    clearFields();
                }else{
                    Toast.makeText(MainActivity.this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean isValidInputs() {
        return !editTextName.getText().toString().trim().isEmpty() &&
                !editTextPhoneNumber.getText().toString().trim().isEmpty() &&
                (radioButtonMale.isChecked() || radioButtonFemale.isChecked());
    }

    private void clearFields() {
        editTextName.setText("");
        editTextPhoneNumber.setText("");
        radioButtonMale.setChecked(false);
        radioButtonFemale.setChecked(false);
        spinnerCountries.setSelection(0);
    }
}