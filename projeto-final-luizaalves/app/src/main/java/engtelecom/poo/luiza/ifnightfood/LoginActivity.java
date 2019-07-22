package engtelecom.poo.luiza.ifnightfood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class LoginActivity extends AppCompatActivity {
    public static final String mUrlIP = "http://191.36.8.33:5000/";
    private EditText mEditUser;
    private EditText mEditSenha;
    private final int SEGUNDA = 1;
    private SharedPreferences mPreferences;
    private static final String mSharedPrefFile = "poo.engtelecom.contador";
    private final String USER_KEY = "usuario";
    private final String SENHA_KEY  = "senha";
    private final String CHECK_KEY  = "check";
    private CheckBox mCheckBox;
    private boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //usuario
        mPreferences = getSharedPreferences(mSharedPrefFile, MODE_PRIVATE);
        String user = mPreferences.getString(USER_KEY,"");
        mEditUser = (EditText) findViewById(R.id.username);
        mEditUser.setText(user);

        //senha
        mEditSenha = (EditText) findViewById(R.id.senha);
        mPreferences = getSharedPreferences(mSharedPrefFile, MODE_PRIVATE);
        String senha = mPreferences.getString(SENHA_KEY,"");
        mEditSenha.setText(senha);

        //lembrar senha
        mCheckBox = (CheckBox) findViewById(R.id.salvarSenha);
        mPreferences = getSharedPreferences(mSharedPrefFile, MODE_PRIVATE);
        boolean check2 = mPreferences.getBoolean(CHECK_KEY,false);
        mCheckBox.setChecked(check2);
    }
    public void pedidoGET(final View view){
        RequestQueue fila = Volley.newRequestQueue(this);
        final String url = mUrlIP+"login/"+mEditUser.getText().toString()+"/"+mEditSenha.getText();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.compareTo("Autenticado com sucesso")== 0){
                    invocarSegunda(view);

                    if(verificarCheckbox()==true) check = true;

                    else if(verificarCheckbox()==false) check = false;
                }
                else if(response.compareTo("Erro na autenticação")== 0){
                    mEditUser.setText("");
                    mEditSenha.setText("");
                    Toast toast = Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG);
                    toast.show();
                }
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast = Toast.makeText(getApplicationContext(),"Erro: "+error.toString(),Toast.LENGTH_LONG);
                toast.show();
            }
        }
        );
        fila.add(stringRequest);
    }

    public void invocarSegunda(View view){
        Intent intent = new Intent(this,PrincipalActivity.class);
        startActivityForResult(intent,SEGUNDA);
    }
    @Override
    protected void onPause() {
        super.onPause();
        String user = mEditUser.getText().toString();
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(USER_KEY,user);
        editor.apply();

        if(check==true) {
            SharedPreferences.Editor editor3 = mPreferences.edit();
            editor3.putBoolean(CHECK_KEY,true);
            editor3.apply();
        }
        else {
            SharedPreferences.Editor editor3 = mPreferences.edit();
            editor3.putBoolean(CHECK_KEY,false);
            editor3.apply();
        }

        if(check==true){
            String senha = mEditSenha.getText().toString();
            SharedPreferences.Editor editor2 = mPreferences.edit();
            editor2.putString(SENHA_KEY,senha);
            editor2.apply();
        }
        else if(check==false) {
            mEditSenha.setText("");
            String senha = mEditSenha.getText().toString();
            SharedPreferences.Editor editor2 = mPreferences.edit();
            editor2.putString(SENHA_KEY,senha);
            editor2.apply();
        }

    }
    public boolean verificarCheckbox() {
        if (mCheckBox.isChecked()) {
            return true;
        }
        return false;
    }

}
