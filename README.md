TEMPLATE DE README

# Criando Media PLayers no android

## Descrição

Projeto que visa a criação de media players no android.

## Recursos

- Play
- Pause
- Stop
- Controlar volume
## Capturas de Tela

![image](https://github.com/AnnaKarolineNunes/CriandoMediaPlayersNoAndroid/assets/101477642/6a8980f4-7249-46a8-86a4-3b59daaa9b80)

## Passo a passo do Play

 Após criar o layout no arquivo xml, no MainActivity.java vamos configurar o som para que o mesmo funcione ao apertar o butão de play.
    ```
    
      public class MainActivity extends AppCompatActivity {
      private MediaPlayer mediaPlayer; // criamos o atributo do tipo Media PLayer
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
  
          // configurando a musica
          mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
      }
  
      //  criar o evento de clique, que no caso se o objeto mediaPlayer existir, ele inicia
      public void executarSom(View view){
          if(mediaPlayer != null){
              mediaPlayer.start();
          }
      }
  }

## Passo a passo do pause
Ainda no MainActivity.java, logo após o método executarSom, devemos criar o método pausarMusica, que verifica se a existe uma musica tocando, e se existir a mesma é pausada.
    ```
    
    public  void pausarMusica(View view){
        //se realmente a musica estiver sendo executada
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

## Passo a passo do stop
Ainda no MainActivity.java, logo após o método pausarMusica, devemos criar o método pararMusica, que verifica se existe musica tocando e encerra a musica. 
    ```

      public void pararMusica(View view){
          if (mediaPlayer.isPlaying()){
              mediaPlayer.stop();
              mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
  
          }
      }
      
 ## Passo a passo para controloar o volume com seekbar
Passo 1 : No MainActivity.java, devemos criar os atributos do tipo SeekBar e AudioManager para controlar o volume 
    ```  

      private SeekBar seekVolume;
      private AudioManager audioManager;
      
Passo 2: criar o método inicializarSeekBar() 
    ```  

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
