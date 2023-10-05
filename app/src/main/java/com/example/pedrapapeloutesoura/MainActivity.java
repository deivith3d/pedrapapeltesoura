package com.example.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
        ImageView ivPedra = findViewById(R.id.imageViewPedra);
        ivPedra.setColorFilter(Color.argb(100, 219, 249, 191));

        ImageView ivPapel = findViewById(R.id.imageViewPapel);
        ivPapel.setColorFilter(Color.argb(0, 0, 0, 0));

        ImageView ivTesoura = findViewById(R.id.imageViewTesoura);
        ivTesoura.setColorFilter(Color.argb(0, 0, 0, 0));

    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
        ImageView ivPedra = findViewById(R.id.imageViewPedra);
        ivPedra.setColorFilter(Color.argb(0, 0, 0, 0));

        ImageView ivPapel = findViewById(R.id.imageViewPapel);
        ivPapel.setColorFilter(Color.argb(100, 219, 249, 191));

        ImageView ivTesoura = findViewById(R.id.imageViewTesoura);
        ivTesoura.setColorFilter(Color.argb(0, 0, 0, 0));
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
        ImageView ivPedra = findViewById(R.id.imageViewPedra);
        ivPedra.setColorFilter(Color.argb(0, 0, 0, 0));

        ImageView ivPapel = findViewById(R.id.imageViewPapel);
        ivPapel.setColorFilter(Color.argb(0, 0, 0, 0));

        ImageView ivTesoura = findViewById(R.id.imageViewTesoura);
        ivTesoura.setColorFilter(Color.argb(100, 219, 249, 191));
    }

    public void opcaoSelecionada(String opSelec){
        ImageView ivComp = findViewById(R.id.ivComputador);
        TextView tvResult =findViewById(R.id.textResultado);

        int num = new Random().nextInt(3);
        String[] opcao = {"pedra","papel","tesoura"};
        String opcaoApp = opcao[num];

        switch(opcaoApp){
            case "pedra": ivComp.setImageResource(R.drawable.pedra);

                break;
            case "papel": ivComp.setImageResource(R.drawable.papel);

                break;
            case "tesoura": ivComp.setImageResource(R.drawable.tesoura);

                break;

        }
        ivComp.setColorFilter(Color.argb(100, 219, 249, 191));
        //Comp ganhador
        if(
                (opSelec=="pedra" && opcaoApp=="papel")||
                (opSelec=="papel" && opcaoApp=="tesoura")||
                (opSelec=="tesoura" && opcaoApp=="pedra"))
        {
            tvResult.setText("Você perdeu :(");

        }else if(
                (opcaoApp=="pedra" && opSelec=="papel")||
                (opcaoApp=="papel" && opSelec=="tesoura")||
                (opcaoApp=="tesoura" && opSelec=="pedra"))
        {
            tvResult.setText("Você ganhou :)");
        }else{// Empate
            tvResult.setText("Empatamos :|");
        }
    }
}
