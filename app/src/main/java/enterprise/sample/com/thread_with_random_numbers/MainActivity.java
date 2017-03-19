package enterprise.sample.com.thread_with_random_numbers;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    TextView johnsView;
    int x;
    Random johnsRand = new Random();
    String number;
    Handler johnsHandler = new Handler();


    public void randomize(View view) {
        Runnable johnsRunnable = new Runnable() {
            @Override
            public void run() {
                generateNumber();
            }
        };
        new Thread(johnsRunnable).start();
    }

    private  void generateNumber(){
        for(int i=0; i<=40; i++){
            x=johnsRand.nextInt(100)+1;
            number = String.valueOf(x);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            johnsHandler.post(new Runnable(){
                @Override
                public void run(){
                    johnsView = (TextView)findViewById(R.id.myTextView);
                    johnsView.setText(number);
                }
            });
        }
    }
}
