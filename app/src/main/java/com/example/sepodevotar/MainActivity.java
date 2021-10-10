package com.example.sepodevotar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                }else{
                    dialogAlert();
                }
            }
        });
    }

    private static class ViewHolder {
        Button btnConfirm;
        // EditText editSenha;
    }

    private AlertDialog alerta;

    private void dialogAlert() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Titulo");
        //define a mensagem
        builder.setMessage("Qualifique este software");
        //define um botão como positivo
        builder.setPositiveButton(R.string.dialog_text, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                // Toast.makeText(MainActivity.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }

}