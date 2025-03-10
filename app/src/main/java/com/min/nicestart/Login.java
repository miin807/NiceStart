package com.min.nicestart;

import android.content.Intent;
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



        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);


        ImageView mGirl = findViewById(R.id.girl);//girl del id del xml

        Glide.with(this)
                   .load("https://images.unsplash.com/photo-1547355253-ff0740f6e8c1?q=80&w=1854&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                //.load(R.drawable.girl)//girl.png
                 .transition(DrawableTransitionOptions.withCrossFade(1000))
                .centerCrop()
                //  .circleCrop()
                //  .placeholder(new ColorDrawable(this.getResources().getColor(R.color.amarillo)))
                .into(mGirl);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login), (v, insets) -> {
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
        Intent intent = new Intent(Login.this, Main.class);
        startActivity(intent);
    }

}