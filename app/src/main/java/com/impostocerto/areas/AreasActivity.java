package com.impostocerto.areas;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.impostocerto.login.LoginActivity;
import com.impostocerto.login.R;
import com.impostocerto.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathan on 05/05/2015.
 */
public class AreasActivity extends ActionBarActivity implements PopupMenu.OnMenuItemClickListener {

    private Toolbar toolbar;                              // Declaring the Toolbar Object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);

    /* Assinging the toolbar object ot the view
    and setting the the Action bar to our toolbar
     */
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("Selecione uma Área");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        findViewById(R.id.educacao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList ids = new ArrayList();
                ids.add(R.id.saude);
                ids.add(R.id.saneamento);
                ids.add(R.id.seguranca);
                ids.add(R.id.transporte);
                ids.add(R.id.urbanizacao);
                ids.add(R.id.entretenimento);
                blurViews(ids);
                PopupMenu popupMenu = new PopupMenu(AreasActivity.this, view);
                popupMenu.setOnMenuItemClickListener(AreasActivity.this);
                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu popupMenu) {
                        unBlurViews(ids);
                    }
                });
                popupMenu.inflate(R.menu.educacao_menu);
                popupMenu.show();
            }
        });

        findViewById(R.id.saude).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList ids = new ArrayList();
                ids.add(R.id.educacao);
                ids.add(R.id.saneamento);
                ids.add(R.id.seguranca);
                ids.add(R.id.transporte);
                ids.add(R.id.urbanizacao);
                ids.add(R.id.entretenimento);
                blurViews(ids);
                PopupMenu popupMenu = new PopupMenu(AreasActivity.this, view);
                popupMenu.setOnMenuItemClickListener(AreasActivity.this);
                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu popupMenu) {
                        unBlurViews(ids);
                    }
                });
                popupMenu.inflate(R.menu.saude_menu);
                popupMenu.show();
            }
        });

        findViewById(R.id.saneamento).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList ids = new ArrayList();
                ids.add(R.id.educacao);
                ids.add(R.id.saude);
                ids.add(R.id.seguranca);
                ids.add(R.id.transporte);
                ids.add(R.id.urbanizacao);
                ids.add(R.id.entretenimento);
                blurViews(ids);
                PopupMenu popupMenu = new PopupMenu(AreasActivity.this, view);
                popupMenu.setOnMenuItemClickListener(AreasActivity.this);
                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu popupMenu) {
                        unBlurViews(ids);
                    }
                });
                popupMenu.inflate(R.menu.saneamento_menu);
                popupMenu.show();
            }
        });

        findViewById(R.id.seguranca).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList ids = new ArrayList();
                ids.add(R.id.educacao);
                ids.add(R.id.saude);
                ids.add(R.id.saneamento);
                ids.add(R.id.transporte);
                ids.add(R.id.urbanizacao);
                ids.add(R.id.entretenimento);
                blurViews(ids);
                PopupMenu popupMenu = new PopupMenu(AreasActivity.this, view);
                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu popupMenu) {
                        unBlurViews(ids);
                    }
                });
                popupMenu.setOnMenuItemClickListener(AreasActivity.this);
                popupMenu.inflate(R.menu.seguranca_menu);
                popupMenu.show();
            }
        });

        findViewById(R.id.transporte).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList ids = new ArrayList();
                ids.add(R.id.educacao);
                ids.add(R.id.saude);
                ids.add(R.id.saneamento);
                ids.add(R.id.seguranca);
                ids.add(R.id.urbanizacao);
                ids.add(R.id.entretenimento);
                blurViews(ids);
                PopupMenu popupMenu = new PopupMenu(AreasActivity.this, view);
                popupMenu.setOnMenuItemClickListener(AreasActivity.this);
                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu popupMenu) {
                        unBlurViews(ids);
                    }
                });
                popupMenu.inflate(R.menu.transporte_menu);
                popupMenu.show();
            }
        });
        findViewById(R.id.urbanizacao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList ids = new ArrayList();
                ids.add(R.id.educacao);
                ids.add(R.id.saude);
                ids.add(R.id.saneamento);
                ids.add(R.id.seguranca);
                ids.add(R.id.transporte);
                ids.add(R.id.entretenimento);
                blurViews(ids);
                PopupMenu popupMenu = new PopupMenu(AreasActivity.this, view);
                popupMenu.setOnMenuItemClickListener(AreasActivity.this);
                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu popupMenu) {
                        unBlurViews(ids);
                    }
                });
                popupMenu.inflate(R.menu.urbanizacao_menu);
                popupMenu.show();
            }
        });

        findViewById(R.id.entretenimento).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ArrayList ids = new ArrayList();
                ids.add(R.id.educacao);
                ids.add(R.id.saude);
                ids.add(R.id.saneamento);
                ids.add(R.id.seguranca);
                ids.add(R.id.transporte);
                ids.add(R.id.urbanizacao);
                blurViews(ids);
                PopupMenu popupMenu = new PopupMenu(AreasActivity.this, view);
                popupMenu.setOnMenuItemClickListener(AreasActivity.this);
                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu popupMenu) {
                        unBlurViews(ids);
                    }
                });
                popupMenu.inflate(R.menu.entretenimento_menu);
                popupMenu.show();
            }
        });
    }

    private void blurViews(ArrayList<Integer> ids) {
        for (int i = 0 ; i < ids.size() ; i++){
            LinearLayout parent = (LinearLayout) findViewById(ids.get(i)).getParent();
            parent.setAlpha((float) 0.25);
        }
    }

    private void unBlurViews(ArrayList<Integer> ids) {
        for (int i = 0 ; i < ids.size() ; i++){
            LinearLayout parent = (LinearLayout) findViewById(ids.get(i)).getParent();
            parent.setAlpha((float) 1);
        }
    }

    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            //EDUCACAO
            case R.id.item_pre_escola:
                callProjectActivity("Educação", "Pré Escola");
                return true;
            case R.id.item_fundamental1:
                callProjectActivity("Educação", "Ensino Fundamental 1");
                return true;
            case R.id.item_fundamental2:
                callProjectActivity("Educação", "Ensino Fundamental 2");
                return true;
            case R.id.item_ensino_medio:
                callProjectActivity("Educação", "Ensino Médio");
                return true;

            //SAUDE
            case R.id.item_posto_saude:
                callProjectActivity("Saúde", "Posto de Saúde");
                return true;
            case R.id.item_pronto_socorro:
                callProjectActivity("Saúde", "Pronto Socorro");
                return true;
            case R.id.item_ambulancia:
                callProjectActivity("Saúde", "Ambulância");
                return true;
            case R.id.item_medicos:
                callProjectActivity("Saúde", "Médicos");
                return true;

            //SANEAMENTO
            case R.id.item_agua:
                callProjectActivity("Saneamento", "Água");
                return true;
            case R.id.item_esgoto:
                callProjectActivity("Saneamento", "Esgoto");
                return true;

            //SEGURANCA
            case R.id.item_ronda_escolar:
                callProjectActivity("Segurança", "Ronda Escolar");
                return true;
            case R.id.item_base_movel:
                callProjectActivity("Segurança", "Base Móvel");
                return true;
            case R.id.item_base_fixa:
                callProjectActivity("Segurança", "Base Fixa");
                return true;

            //TRANSPORTE
            case R.id.item_transp_escolar:
                callProjectActivity("Transporte", "Escolar");
                return true;
            case R.id.item_transp_publico:
                callProjectActivity("Transporte", "Público");
                return true;
            case R.id.item_transp_deficiente:
                callProjectActivity("Transporte", "Deficiente");
                return true;

            //URBANIZACAO
            case R.id.item_ruas:
                callProjectActivity("Urbanização", "Ruas");
                return true;
            case R.id.item_pracas:
                callProjectActivity("Urbanização", "Praças");
                return true;

            //ENTRETENIMENTO
            case R.id.item_area_lazer:
                callProjectActivity("Entretenimento", "Lazer");
                return true;
            case R.id.item_centro_esportivo:
                callProjectActivity("Entretenimento", "Centro Esportivo");
                return true;
            case R.id.item_centro_convivencia:
                callProjectActivity("Entretenimento", "Centro de Convivência");
                return true;
        }
        return false;
    }

    private void callProjectActivity(String area, String subarea) {
        Intent intent = new Intent(getBaseContext(), ProjectActivity.class);
        intent.putExtra("AREA", area);
        intent.putExtra("SUBAREA", subarea);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        discardVote();
        super.onBackPressed();
    }

    private void discardVote() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
