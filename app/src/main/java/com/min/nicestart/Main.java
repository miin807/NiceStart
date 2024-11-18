package com.min.nicestart;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class Main extends AppCompatActivity {
private WebView miVisorWeb;
//private TextView textoo;
private SwipeRefreshLayout swipeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        WebView mycontext=findViewById(R.id.web);
        registerForContextMenu(mycontext);
//        TextView textoo = findViewById(R.id.texto);
//        registerForContextMenu(textoo);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        miVisorWeb = (WebView) findViewById(R.id.web);
////        miVisorWeb.getSettings().setJavaScriptEnabled(true);
////        miVisorWeb.getSettings().setBuiltInZoomControls(true);
        WebSettings webSettings = miVisorWeb.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com");


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //implemento context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuinfo)
    {
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        if (id==R.id.item1) {
            Toast.makeText(this, "ITEM COPIADO", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if( id==R.id.item2)
        {
            Toast.makeText(this, "DOWLOAD ITEM", Toast.LENGTH_SHORT).show();
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_appbar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();//numero segun orden de creacion en xml
        if(id==R.id.item1)
        {
            Toast toast = Toast.makeText(this, "Infecting", Toast.LENGTH_LONG);
            toast.show();
        }
        if(id==R.id.item2)
        {
            final ConstraintLayout layout=findViewById(R.id.main);
            Snackbar snackbar = Snackbar
                    .make(layout, "fancy a Snack while you refresh", Snackbar.LENGTH_LONG)
                    .setAction("Action", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(Main.this, "Action is restaured", Toast.LENGTH_SHORT).show();
                        }

                    });
    snackbar.show();
        }
        if (id == R.id.item3) {
            Intent intent = new Intent(Main.this, Profile.class);
            startActivity(intent);
        }

        if (id == R.id.item4) {
            showAlertDailogButtonClicked(Main.this);
        }


        return super.onOptionsItemSelected(item);
    }

    //implementacion swipe refresh
    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
           // Toast toast0 = Toast.makeText(Main.this, "Hi there! I don't exist :)", Toast.LENGTH_LONG);
            //toast0.show();
            final ConstraintLayout layout=findViewById(R.id.main);

            Snackbar snackbar= Snackbar
                    .make(layout,"Refreshing",Snackbar.LENGTH_LONG)
                    .setAction("Action", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(layout,"Action is restored",Snackbar.LENGTH_LONG);
                            snackbar1.show();
                        }
                    });

            snackbar.show();

            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };


    public void showAlertDailogButtonClicked (Main main)
    {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

        builder.setTitle("SOL");
        builder.setMessage("¿Te gusta el sol ?");
        builder.setIcon(R.drawable.sol);
        builder.setCancelable(true);



        builder.setPositiveButton("Log out", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                dialog.dismiss();
                Intent intent = new Intent(Main.this, Login.class);
                startActivity(intent);

            }
        });

        builder.setNegativeButton("No hace nada", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...

                dialog.dismiss();
            }
        });

        builder.setNeutralButton("Salir de la app", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...
                System.exit(0);//Sale correctamente de la app

                //dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}