package com.cursoandroid.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private SeekBar seekVolume;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // configurando a musica
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
    }

    public void inicializarSeekBar(){
        seekVolume = findViewById(R.id.seekVolume);
        // configurar audio manager que verifica qual o volume atual do usuario e qual  o máximo que o dispositivo suporta
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        // recuperar os valores de volume máximo e o volume atual
        int volumeMaximo = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumeAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        // configura o volume maximo para o seekbar
        seekVolume.setMax(volumeMaximo);

        // configura o progresso atual do seekbar
        seekVolume.setProgress(volumeAtual);
        seekVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // mudar o progresso da seekbar ( volume da musica )
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress ,
                        0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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

    // metodo que remove os recursos da memoria quando a activity é destruida
    protected void onDestroy(){
        super.onDestroy();
        if (mediaPlayer!= null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release(); // libera os recuros de memoria
            mediaPlayer = null; // nao ocupa espaço de memoria com o recurso
        }
    }
    // metodo para pausar a musica quando o app está em segundo plano
    protected  void onStop(){
        super.onStop();
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }
}
