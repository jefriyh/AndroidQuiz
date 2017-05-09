package com.crocias.simplequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView mTextQuestion;
    Button mBtnSubmit;
    RadioGroup optionGroup;
    RadioButton optionA, optionB,optionC,optionD;
    List<QuizModel> quizModelList = new ArrayList<>();
    int no = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextQuestion = (TextView) findViewById(R.id.mTextQuestion);
        mBtnSubmit = (Button) findViewById(R.id.mBtnSubmit);
        optionGroup = (RadioGroup) findViewById(R.id.optionGroup);
        optionA = (RadioButton) findViewById(R.id.optionA);
        optionB = (RadioButton) findViewById(R.id.optionB);
        optionC = (RadioButton) findViewById(R.id.optionC);
        optionD = (RadioButton) findViewById(R.id.optionD);
        prepareData();
        setData();

        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(no<quizModelList.size()) {
                    checkAnswer();
                    no++;
                }
                if(no<quizModelList.size()) {
                    setData();
                }
            }
        });
    }





    //digunakan untuk menset soal
    void prepareData(){
        setQuestion("Dibawah ini activity lifecycle pada android kecuali?", "onCreate", "onStart", "onResume", "onCenter", "D");
        setQuestion("Jenis view untuk menampilkan gambar disebut?", "ImageView", "PictureView", "GraphicView", "WallpaperView", "A");
        setQuestion("untuk berpindah dari satu activity ke activity lain dapat menggunakan perintah?", "Move", "Intent", "Change", "Link", "B");

    }

    void setData(){
        mTextQuestion.setText(quizModelList.get(no).getQuestion());
        optionA.setText(quizModelList.get(no).getOptionA());
        optionB.setText(quizModelList.get(no).getOptionB());
        optionC.setText(quizModelList.get(no).getOptionC());
        optionD.setText(quizModelList.get(no).getOptionD());

    }

    void checkAnswer(){
        int index =0;
        switch (quizModelList.get(no).getAnswer()){
            case "A":
                index =0;
                break;
            case "B":
                index =1;
                break;
            case "C":
                index =2;
                break;
            case "D":
                index =3;
                break;
            default:index=0; break;
        }

        int selectedAnsewer = optionGroup.indexOfChild(findViewById(optionGroup.getCheckedRadioButtonId()));
        if(index == selectedAnsewer){
            Toast.makeText(this, "Benar", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Salah", Toast.LENGTH_SHORT).show();
        }
    }


    //fungsi untuk mengeset soal ke model yang kemudian akan dimasukan ke modellist
    void setQuestion(String question, String optionA, String optionB, String optionC, String optionD, String answer){
        QuizModel quizModel = new QuizModel(question, optionA, optionB, optionC, optionD, answer);
        quizModelList.add(quizModel);
    }






}
