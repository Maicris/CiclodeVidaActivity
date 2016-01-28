package br.com.appdev.ciclodevidaactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtLife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        txtLife = new TextView(this);
        setContentView(txtLife);
        txtLife.setText(txtLife.getText().toString() + "Evento onCreate disparado!");
        if (savedInstanceState == null)
            txtLife.setText(txtLife.getText().toString() + "\nPrimeira vez da Activity");
        else
            txtLife.setText(
                    txtLife.getText().toString() + "\n" +
                            savedInstanceState.getString("Texto"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        txtLife.setText(txtLife.getText().toString() + "\nEvento onResume disparado!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        txtLife.setText(txtLife.getText().toString() + "\nEvento onPause disparado!");
        if (isFinishing())
            txtLife.setText(txtLife.getText().toString() + "\nFUI!!!!!!!");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Texto", "Valor antes da Rotação");
    }
}
