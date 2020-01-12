package com.isil.appvendedor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText cantidad;
    TextView resultado;
    double s_basico=465.00;
    DecimalFormat df=new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cantidad=findViewById(R.id.txtcantidad);
        resultado=findViewById(R.id.txtresultado);

    }
    public void calcular(View view) {

        if (cantidad.getText().toString().isEmpty()) {
            resultado.setText("Ingrese una cantidad");
        } else {


            double monto = Double.parseDouble(cantidad.getText().toString());
            double comision = monto * 0.185;
            double s_neto = s_basico + comision;

            resultado.setText("SUELDO BASE : " + df.format(s_basico) + " soles"+"\n" +
                            "----------------------------------------------------------" + "\n" +

                    "COMISION : " + df.format(comision) + " soles"+"\n" +
                            "----------------------------------------------------------" +"\n" +
                    "SUELDO NETO : " + df.format(s_neto)+" soles"
                    );


        }
    }
    public void borrar(View view){
        resultado.setText("");
        cantidad.setText("");
    }
}
