package com.min.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        ImageView mGirl = findViewById(R.id.fondo);//girl del id del xml

        Glide.with(this)
                .load("https://images.unsplash.com/photo-1543127172-4b33cb699e35?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                //.load(R.drawable.ola)//girl.png
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                //  .circleCrop()
                //  .placeholder(new ColorDrawable(this.getResources().getColor(R.color.amarillo)))
                .into(mGirl);
        openApp();
        //Le aplicaremos la animacion:
        ImageView logo = findViewById(R.id.logo);
        //creamos un objeto animacion que incorpora la animacion descrita en el xml y con el metodo loadAnimation
        //startAnimation lo aplicamos al imageview del logo
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);

        TextView nombre2 = findViewById(R.id.nombre);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.fade_in);


        logo.startAnimation(animation);
        nombre2.startAnimation(animation2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void openApp()
    {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 3000);
    }
}
