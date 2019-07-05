package nadiah.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class quiz4 extends AppCompatActivity {
    AlertDialog.Builder builder;
    EditText etJb;

    Button btncek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
        Intent intent = getIntent();
        initialLayout();

    }

    private void initialLayout(){
        btncek = (Button) findViewById(R.id.btn_jawaban);

        etJb = (EditText) findViewById(R.id.et_jb);

        btncek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etJb.getText().toString().equalsIgnoreCase("hongaria")){
                    builder = new AlertDialog.Builder(quiz4.this);
                    builder.setCancelable(false);
                    builder.setTitle("Jawaban Benar!");
                    builder.setMessage("Score Anda = 100");
                    builder.setPositiveButton("OKE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.setClass(quiz4.this,pembahasan4.class);
                            startActivity(intent);
                        }
                    });
                    builder.create().show();
                }
                else if (etJb.getText().toString().equalsIgnoreCase("")){
                    Intent intent = new Intent();
                    intent.setClass(quiz4.this,pembahasan3.class);
                    startActivity(intent);
                }
                else {
                    builder = new AlertDialog.Builder(quiz4.this);
                    builder.setCancelable(false);
                    builder.setMessage("Jawaban Salah");
                    builder.setPositiveButton("OKE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.setClass(quiz4.this,pembahasan4.class);
                            startActivity(intent);
                        }
                    });
                    builder.create().show();
                }
            }
        });
    }


}
