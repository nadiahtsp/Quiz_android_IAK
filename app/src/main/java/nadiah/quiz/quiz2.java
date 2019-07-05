package nadiah.quiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class quiz2 extends AppCompatActivity {
    Button next;

    android.app.AlertDialog.Builder builder;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        initialiazeLayout();

        getSupportActionBar().setTitle("Quiz");
        getSupportActionBar().setSubtitle("");



        //radiogroup inisialisasi
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(quiz2.this, pembahasan2.class);
                startActivity(intent);
            }
        });
    }

    private void initialiazeLayout(){

        next = (Button) findViewById(R.id.next);


    }
    //Memilih RadioButton

    public void onRadioButton(View view){

        Boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.r1:
                if (checked)
                    jawabanSalah();
                break;

            case R.id.r2:
                if (checked)
                    tampilDialog();
                break;

            case R.id.r3:
                if (checked)
                    jawabanSalah();
                break;
            case R.id.r4:
                if (checked)
                    jawabanSalah();
        }
    }

    //Menampilkan jawaban benar
    public void tampilDialog(){
        builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Jawaban Benar!");
        builder.setMessage("Score Anda = 100 ");
        builder.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(quiz2.this, "Selamat", Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();
    }

    //Menampilkan toast text jawaban salah
    public void jawabanSalah(){
        Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
    }
}
