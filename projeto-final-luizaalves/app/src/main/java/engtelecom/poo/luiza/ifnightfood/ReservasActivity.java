package engtelecom.poo.luiza.ifnightfood;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ReservasActivity extends AppCompatActivity {
    private Cardapio cardapio;
    private StringBuilder[] mDiaDaSemana;
    private StringBuilder[] mExibirReservas;
    private DiaSemana[] mSemana = new DiaSemana[5];
    private ListView mListaReservar;
    private ArrayAdapter<StringBuilder> mAdapter;
    private StringBuilder mToken;
    private ArrayList mTokensGerado;
    private StringBuilder[] mHistorico = new StringBuilder[10];
    private int i = 0;
    public static final int SEGUNDA = 1;
    private Intent intent;
    public static final String RESPOSTA = "resposta";
    private SharedPreferences mPreferences;
    private static final String mSharedPrefFile = "poo.engtelecom.main";
    public final String HISTORICO_KEY = "historico";
    private final String RESERVAR_KEY = "reservar";
    private int x = 0;
    private String[] d = new String[4];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);
        mPreferences = getSharedPreferences(mSharedPrefFile, MODE_PRIVATE);
        String lista = mPreferences.getString(HISTORICO_KEY,"");
        mListaReservar = (ListView) findViewById(R.id.lista);

        String reservar = mPreferences.getString(RESERVAR_KEY,"");
        mExibirReservas = new StringBuilder[4];
        for (int i = 0; i < 4; i++) {
            mExibirReservas[i] = new StringBuilder("");
        }
        for (int i = 0; i < 10; i++) {
            mHistorico[i] = new StringBuilder(lista);
        }
        mAdapter = new ArrayAdapter<StringBuilder>(this, android.R.layout.simple_list_item_1,mExibirReservas);

        mDiaDaSemana = new StringBuilder[5];
        mTokensGerado = new ArrayList();
        mToken = new StringBuilder("");
        intent = new Intent(ReservasActivity.this,PrincipalActivity.class);
        for (int i = 0; i < 5; i++) {
            mDiaDaSemana[i]=new StringBuilder("");
        }
        if(x == 0){
            pedidoGET();
            x++;
        }

        mListaReservar.setAdapter(mAdapter);
        mListaReservar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:{
                        AlertDialog.Builder msgbox = new AlertDialog.Builder(ReservasActivity.this);
                        msgbox.setTitle("Confirmar reserva");
                        msgbox.setMessage("Você deseja mesmo reservar este lanche?");
                        msgbox.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                gerarTickerGET();
                                Toast toast = Toast.makeText(getApplicationContext(), "Reservado.", Toast.LENGTH_LONG);
                                toast.show();
                                d[0] = parent.getItemAtPosition(0).toString();//---
                                SharedPreferences.Editor editor = mPreferences.edit();
                                editor.putString("s",d[0]);
                                editor.apply();

                                mTokensGerado.add(0);
                                mExibirReservas[0].delete(0,mExibirReservas[0].length()-1);
                                mAdapter.notifyDataSetChanged();
                                startActivityForResult(intent,SEGUNDA);
                            }
                        });
                        msgbox.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        msgbox.show();

                        break;
                    }
                    case 1:{
                        AlertDialog.Builder msgbox = new AlertDialog.Builder(ReservasActivity.this);
                        msgbox.setTitle("Confirmar reserva");
                        msgbox.setMessage("Você deseja mesmo reservar este lanche?");
                        msgbox.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                gerarTickerGET();
                                Toast toast = Toast.makeText(getApplicationContext(), "Reservado.", Toast.LENGTH_LONG);
                                toast.show();
                                d[1] = parent.getItemAtPosition(1).toString();//---
                                SharedPreferences.Editor editor2 = mPreferences.edit();
                                editor2.putString("ss",d[1]);
                                editor2.apply();

                                mTokensGerado.add(1);
                                mExibirReservas[1].delete(0,mExibirReservas[1].length());
                                mAdapter.notifyDataSetChanged();
                                startActivityForResult(intent,SEGUNDA);
                            }
                        });
                        msgbox.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        msgbox.show();
                        break;
                    }
                    case 2:{
                        AlertDialog.Builder msgbox = new AlertDialog.Builder(ReservasActivity.this);
                        msgbox.setTitle("Confirmar reserva");
                        msgbox.setMessage("Você deseja mesmo reservar este lanche?");
                        msgbox.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                gerarTickerGET();
                                Toast toast = Toast.makeText(getApplicationContext(), "Reservado.", Toast.LENGTH_LONG);

                                d[2] = parent.getItemAtPosition(2).toString();//---
                                SharedPreferences.Editor editor3 = mPreferences.edit();
                                editor3.putString("sss",d[2]);
                                editor3.apply();
                                mTokensGerado.add(2);
                                mExibirReservas[2].delete(0,mExibirReservas[2].length());
                                mAdapter.notifyDataSetChanged();
                                startActivityForResult(intent,SEGUNDA);
                            }
                        });
                        msgbox.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        msgbox.show();
                        break;
                    }
                    case 3:{
                        AlertDialog.Builder msgbox = new AlertDialog.Builder(ReservasActivity.this);
                        msgbox.setTitle("Confirmar reserva");
                        msgbox.setMessage("Você deseja mesmo reservar este lanche?");
                        msgbox.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                gerarTickerGET();
                                Toast toast = Toast.makeText(getApplicationContext(), "Reservado.", Toast.LENGTH_LONG);
                                toast.show();
                                d[3] = parent.getItemAtPosition(3).toString();//---
                                SharedPreferences.Editor editor4 = mPreferences.edit();
                                editor4.putString("ssss",d[3]);
                                editor4.apply();
                                mTokensGerado.add(3);
                                mExibirReservas[3].delete(0,mExibirReservas[3].length());
                                mAdapter.notifyDataSetChanged();
                                startActivityForResult(intent,SEGUNDA);
                            }
                        });
                        msgbox.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        msgbox.show();
                        break;
                    }
                }
            }
        });

    }

    public void pedidoGET(){
        RequestQueue fila = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, LoginActivity.mUrlIP+"cardapio", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();

                cardapio = gson.fromJson(response, Cardapio.class);
                mSemana = cardapio.getCardapio();

                for (int i = 0; i <5; i++) {
                    mDiaDaSemana[i].append(mSemana[i].getDia().toString().toUpperCase()+" = "+mSemana[i].getLanches()[0].toString()+", "+mSemana[i].getLanches()[1].toString()+"\n\n");
                }
                reservasExibidas();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast = Toast.makeText(getApplicationContext(), "Erro: " + error.toString(), Toast.LENGTH_LONG);
                toast.show();
            }
        }
        );
        fila.add(stringRequest);

    }

    public void reservasExibidas(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar x = new GregorianCalendar();
        sdf.setCalendar(x);

        if(x.MONDAY == x.get(x.DAY_OF_WEEK)){
            if(x.get(x.HOUR)<21){
                reservar(1);
            }
            else{
                reservar(2);
            }
        }
        if(x.TUESDAY == x.get(x.DAY_OF_WEEK)){
            if(x.get(x.HOUR)<21){
                reservar(2);
            }
            else{
                reservar(3);
            }
        }
        if(x.WEDNESDAY == x.get(x.DAY_OF_WEEK)){
            if(x.get(x.HOUR)<21){
                reservar(3);
            }
            else{
                reservar(4);
            }
        }
        if(x.THURSDAY == x.get(x.DAY_OF_WEEK)){
            if(x.get(x.HOUR)<21){//começa sexta e termina quarta
                reservar(4);
            }
            else{//começa segunda e termina quinta
                reservar(0);
            }
        }
        if(x.FRIDAY == x.get(x.DAY_OF_WEEK)){
            if(x.get(x.HOUR)<21){//começa segunda e termina quinta
                reservar(0);
            }
            else{ //começa terça-feira e termina sexta
                reservar(1);
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    public void reservar(int i){
        for (int j =0; j < 4; i++,j++) {
            mExibirReservas[j].append(mDiaDaSemana[i]);
            if(i==4) i=0;
        }
    }

    public void gerarTickerGET(){
        RequestQueue fila = Volley.newRequestQueue(this);
        mToken.delete(0,mToken.length());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, LoginActivity.mUrlIP+"obterticket", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mToken.append(response);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast = Toast.makeText(getApplicationContext(), "Erro: " + error.toString(), Toast.LENGTH_LONG);
                toast.show();
            }
        }
        );
        fila.add(stringRequest);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String listaHistorico = String.valueOf(mHistorico);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(HISTORICO_KEY,listaHistorico);
        editor.apply();
        String reservar = mExibirReservas[1].toString();
        SharedPreferences.Editor editor2 = mPreferences.edit();
        editor2.putString(RESERVAR_KEY,reservar);
        editor2.apply();

    }

}
