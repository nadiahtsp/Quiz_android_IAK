package nadiah.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class quiz5 extends AppCompatActivity {
    AlertDialog.Builder builder;
    CheckBox check_ans14;
    CheckBox check_ans24;
    CheckBox check_ans34;
    CheckBox check_ans44;
    Button btn_next11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);
        initializeLayout();


        btn_next11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View klik) {
                if (check_ans14.isChecked() && check_ans44.isChecked()) {
                    tampilDialog();
                    check_ans14.setChecked(true);
                    check_ans44.setChecked(true);
                } else if (check_ans14.isChecked() && check_ans24.isChecked()) {
                    jawabanSalah();
                    check_ans14.setChecked(true);
                    check_ans24.setChecked(true);
                } else if (check_ans24.isChecked() && check_ans34.isChecked()) {
                    jawabanSalah();
                    check_ans24.setChecked(true);
                    check_ans34.setChecked(true);
                } else if (check_ans14.isChecked() && check_ans34.isChecked()) {
                    jawabanSalah();
                    check_ans14.setChecked(true);
                    check_ans34.setChecked(true);
                } else if (check_ans24.isChecked() && check_ans44.isChecked()) {
                    jawabanSalah();
                    check_ans24.setChecked(true);
                    check_ans34.setChecked(true);
                } else if (check_ans34.isChecked() && check_ans44.isChecked()) {
                    jawabanSalah();
                    check_ans24.setChecked(true);
                    check_ans34.setChecked(true);
                } else if (check_ans14.isChecked()) {
                    jawabanSalah();
                    check_ans14.setChecked(true);
                } else if (check_ans24.isChecked()) {
                    jawabanSalah();
                    check_ans24.setChecked(true);
                } else if (check_ans34.isChecked()) {
                    jawabanSalah();
                    check_ans34.setChecked(true);
                } else if (check_ans44.isChecked()) {
                    jawabanSalah();
                    check_ans44.setChecked(true);
                }
            }
        });
    }


    public void intent6 (View view) {
        Intent i = new Intent(quiz5.this, pembahasan5.class);
        startActivity(i);
    }

    private void initializeLayout() {
        btn_next11 = (Button) findViewById(R.id.btn_next11);
        check_ans14 = (CheckBox) findViewById(R.id.check_ans14);
        check_ans24 = (CheckBox) findViewById(R.id.check_ans24);
        check_ans34 = (CheckBox) findViewById(R.id.check_ans34);
        check_ans44 = (CheckBox) findViewById(R.id.check_ans14);
    }



    //Menampilkan jawaban benar
    public void tampilDialog(){
        builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Question 2 Passed ! ");
        builder.setMessage("Your Score = 100");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(quiz5.this, "Nice", Toast.LENGTH_SHORT).show();
                //Define intent function
                Intent intent = new Intent();

                //Set Class (nama file sekarang.this, nama file, tujuan.class)
                intent.setClass(quiz5.this, pembahasan5.class);

                startActivity(intent);

            }
        });


        builder.create().show();
    }

    //Menampilkan toast text jawaban salah
    public void jawabanSalah(){
        Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
    }
}
