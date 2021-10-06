package com.example.sepodevotar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        this.mViewHolder.btnConfirm = findViewById(R.id.button_entrar);
        EditText editSenha = findViewById(R.id.edit_password);

        this.mViewHolder.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = editSenha.getText().toString();
                if (value.equals("Sisa2021")){
                    Intent intent = new Intent(MainActivity.this, DetalhesVoto.class);
                    startActivity(intent);
                }

            }
        });
    }

    private static class ViewHolder {
        Button btnConfirm;
        // EditText editSenha;
    }

}