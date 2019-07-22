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

import static engtelecom.poo.luiza.ifnightfood.ReservasActivity.RESPOSTA;

public class PrincipalActivity extends AppCompatActivity {
    private final int TERCEIRA = 1;
    private final int QUARTA = 1;
    private ListView mHistorico;
    private ArrayAdapter<ArrayList> mAdapter;
    private ArrayList historico;
    private SharedPreferences mPreferences;
    private static final String mSharedPrefFile = "poo.engtelecom.main";
    private final String USER_KEY = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        mPreferences = getSharedPreferences(mSharedPrefFile, MODE_PRIVATE);
        String user = mPreferences.getString(USER_KEY,"");
        mHistorico = (ListView) findViewById(R.id.listaHistorico);

        ArrayList<String> f = new ArrayList<String>();
        f.add(mPreferences.getString("s",""));
        f.add(mPreferences.getString("ss",""));
        f.add(mPreferences.getString("sss",""));
        f.add(mPreferences.getString("ssss",""));
        ArrayAdapter<String> mAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,f);
        mHistorico.setAdapter(mAdapter2);
        mAdapter2.notifyDataSetChanged();

        historico = new ArrayList();

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

    public void exibirConfirmacaoExcluir(){
        AlertDialog.Builder msgbox = new AlertDialog.Builder(this);
        msgbox.setTitle("Excluir reserva");
        msgbox.setMessage("Você deseja mesmo excluir esta reserva?");
        msgbox.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //pega o token e joga no url pra consumir
                Toast.makeText(PrincipalActivity.this,"Reserva excluida.", Toast.LENGTH_SHORT).show();
            }
        });
        msgbox.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        msgbox.show();
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
