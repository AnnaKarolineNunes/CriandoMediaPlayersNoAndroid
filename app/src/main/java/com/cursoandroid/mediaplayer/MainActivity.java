package com.cursoandroid.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // configurando a musica
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
    }

    // passo executar a musica
    public void executarSom(View view){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    // pausa a musica, podendo retomar de onde parou
    public  void pausarMusica(View view){
        //se realmente a musica estiver sendo executada
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    // encerra a musica
    public void pararMusica(View view){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);

        }
    }
}
