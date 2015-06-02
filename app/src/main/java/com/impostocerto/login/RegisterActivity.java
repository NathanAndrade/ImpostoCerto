package com.impostocerto.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

/**
 * Created by Nathan on 05/05/2015.
 */
public class RegisterActivity extends ActionBarActivity {

    private Toolbar toolbar;                              // Declaring the Toolbar Object

    private AutoCompleteTextView mEmail;
    private EditText mPassword;
    private EditText mPassword2;
    private EditText mNome;
    private EditText mCPF;
    private EditText mTitulo;
    private EditText mCEP;

    SharedPreferences sharedpreferences;
    public static final String rName = "nameKey";
    public static final String rPass = "passwordKey";
    public static final String rEmail = "emailKey";
    public static final String RegPREFERENCES = "RegPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    /* Assinging the toolbar object ot the view
    and setting the the Action bar to our toolbar
     */
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle(R.string.register);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mEmail = (AutoCompleteTextView) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.reg_password);
        mPassword2 = (EditText) findViewById(R.id.reg_password2);
        mNome = (EditText) findViewById(R.id.reg_name);
        mCPF = (EditText) findViewById(R.id.cpf);
        mTitulo = (EditText) findViewById(R.id.titulo);
        mCEP = (EditText) findViewById(R.id.cep);
    }

    public void attemptRegister() {
        // Reset errors.
        mEmail.setError(null);
        mPassword.setError(null);
        mPassword2.setError(null);
        mNome.setError(null);
        mCPF.setError(null);
        mTitulo.setError(null);
        mCEP.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        String password2 = mPassword2.getText().toString();
        String nome = mNome.getText().toString();
        String cpf = mCPF.getText().toString();
        String titulo = mTitulo.getText().toString();
        String cep = mCEP.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmail.setError(getString(R.string.error_field_required));
            focusView = mEmail;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmail.setError(getString(R.string.error_invalid_email));
            focusView = mEmail;
            cancel = true;
        } else if (TextUtils.isEmpty(password) || password.length() < 4) {
            mPassword.setError(getString(R.string.error_invalid_password));
            focusView = mPassword;
            cancel = true;
        } else if (TextUtils.isEmpty(password2) || password2.length() < 4) {
            mPassword2.setError(getString(R.string.error_invalid_password));
            focusView = mPassword2;
            cancel = true;
        } else if (!password2.equals(password)){
            mPassword.setError(getString(R.string.error_diferent_password));
            mPassword2.setError(getString(R.string.error_diferent_password));
            focusView = mPassword2;
            cancel = true;
        } else if (TextUtils.isEmpty(nome)) {
            mNome.setError(getString(R.string.error_field_required));
            focusView = mNome;
            cancel = true;
        } else if (TextUtils.isEmpty(cpf)) {
            mCPF.setError(getString(R.string.error_field_required));
            focusView = mCPF;
            cancel = true;
        } else if (TextUtils.isEmpty(titulo)) {
            mTitulo.setError(getString(R.string.error_field_required));
            focusView = mTitulo;
            cancel = true;
        } else if (TextUtils.isEmpty(cep)) {
            mCEP.setError(getString(R.string.error_field_required));
            focusView = mCEP;
            cancel = true;
        } else if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {

            sharedpreferences=getSharedPreferences(RegPREFERENCES,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();
            editor.putString(rEmail,email);
            editor.putString(rPass,password);
            editor.putString(rName,nome);

            if (editor.commit()) {
                Intent i = new Intent(this, LoginActivity.class);
                startActivity(i);
            }
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.btnSaveUser) {
            attemptRegister();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        discardRegistration();
        super.onBackPressed();
    }

    private void discardRegistration() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
