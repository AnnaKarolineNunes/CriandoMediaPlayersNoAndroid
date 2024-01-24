TEMPLATE DE README

# Criando Media PLayers no android

## Descrição

Projeto que visa a criação de media players no android.

## Recursos

- Play
- Pause
- Stop
- Executar videos
- 
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
