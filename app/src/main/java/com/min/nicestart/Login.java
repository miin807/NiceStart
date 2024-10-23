package com.min.nicestart;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView mGirl = findViewById(R.id.girl);//girl del id del xml

        Glide.with(this)
             //   .load("https://images.unsplash.com/photo-1489424731084-a5d8b219a5bb")
                .load(R.drawable.girl)//girl.png
              //  .transition(DrawableTransitionOptions.withCrossFade(2000))
               // .centerCrop()
                //  .circleCrop()
               // .placeholder(new ColorDrawable(this.getResources().getColor(R.color.amarillo)))
                        .into(mGirl);


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void AbrirSignup (View v)
    {
        Intent intent = new Intent(Login.this, Signup.class);
        startActivity(intent);
    }

    public void AbrirMain(View view) {
        Intent intent = new Intent(Login.this,Main.class);
        startActivity(intent);
    }

}