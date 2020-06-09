package cat.udl.amd.act1_events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etTitle = findViewById(R.id.etTitle);
        final EditText etDate = findViewById(R.id.etDate);
        final EditText etDescriptio = findViewById(R.id.etDesc);
        final Spinner spinner = findViewById(R.id.spinner);
        final Button btCreate = findViewById(R.id.btCrear);
        final TextView tvResult = findViewById(R.id.tvResult);
        final Button btErase = findViewById(R.id.btErase);

        List<String> spinnerInflater = new ArrayList<String>();
        spinnerInflater.add("Cumple");
        spinnerInflater.add("Lan Party");
        spinnerInflater.add("Pool Party");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerInflater);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etDescriptio.getText().toString().isEmpty() || etTitle.getText().toString().isEmpty() || etDate.getText().toString().isEmpty()){

                    tvResult.setText("Todos los campos son obligatorios");
                    Toast.makeText(getApplicationContext(), "Rellena todos los campos.", Toast.LENGTH_SHORT).show();

                }else{

                    String  title = etTitle.getText().toString();
                    String date = etDate.getText().toString();
                    String desc = etDescriptio.getText().toString();
                    int type = spinner.getSelectedItemPosition();

                    String aux;
                    switch(type){
                        case 0: aux = "cumple"; tvResult.setBackgroundColor(Color.parseColor("#a020f0"));  break;
                        case 1: aux = "lan party"; tvResult.setBackgroundColor(Color.parseColor("#32cd32")); break;
                        case 2: aux = "pool party"; tvResult.setBackgroundColor(Color.parseColor("#1e90ff")); break;
                        default: aux = null;break;
                    }
                    String result = new String("Et convido a la meva festa " + title + " de " + aux + " el dia " + date + ": " + desc );

                    tvResult.setText(result);

                }
            }
        });

        btErase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etTitle.setText("");
                etDescriptio.setText("");
                etDate.setText("");
                tvResult.setText("");
                tvResult.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        });

    }
}
