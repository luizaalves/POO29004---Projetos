package engtelecom.poo.luiza.ifnightfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;

public class CardapioActivity extends AppCompatActivity {
    Cardapio cardapio;
    private TextView mCardapio;
    private DiaSemana[] mSemana = new DiaSemana[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);
        mCardapio = (TextView) findViewById(R.id.textViewL2);
        pedidoGET();
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
                    mCardapio.append(mSemana[i].getDia().toString().toUpperCase()+" = "+mSemana[i].getLanches()[0].toString()+", "+mSemana[i].getLanches()[1].toString()+".\n\n\n");
                }

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

}