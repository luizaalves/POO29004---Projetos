package engtelecom.poo.luiza.ifnightfood;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static engtelecom.poo.luiza.ifnightfood.ReservasActivity.RESPOSTA;

public class PrincipalActivity extends AppCompatActivity {
    private final int TERCEIRA = 1;
    private final int QUARTA = 1;
    private ListView mHistorico;
    private ArrayAdapter<String> mAdapter;
    //private ArrayList historico;
    private SharedPreferences mPreferences;
    private static final String mSharedPrefFile = "poo.engtelecom.main";
    private final String USER_KEY = "usuario";

    //quando abre a tela, exibe essas info
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        mPreferences = getSharedPreferences(mSharedPrefFile, MODE_PRIVATE);
        String user = mPreferences.getString(USER_KEY,"");
        mHistorico = (ListView) findViewById(R.id.listaHistorico);

        //tem que dar um get da url para pegar os itens já reservados e jogar nessa Arraylist de reservas
        ArrayList<String> reservas = new ArrayList<String>();
        reservas.add(mPreferences.getString("s",""));

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, reservas);

        //exibe na tela as reservas
        mHistorico.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        //historico = new ArrayList();

        /*mAdapter = new ArrayAdapter<ArrayList>(this, android.R.layout.simple_list_item_1,historico);
        mHistorico.setAdapter(mAdapter);*/

        findViewById(R.id.BotaoCardapio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                View view = null;
                invocarQuarta(view);
            }
        });

        findViewById(R.id.BotaoReservar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = null;
                invocarTerceira(view);
            }
        });
    }

    public void invocarTerceira(View view){
        Intent intent = new Intent(this,ReservasActivity.class);
        startActivityForResult(intent,TERCEIRA);
    }

    public void invocarQuarta(View view){
        Intent intent = new Intent(this,CardapioActivity.class);
        startActivityForResult(intent,QUARTA);
    }

}
