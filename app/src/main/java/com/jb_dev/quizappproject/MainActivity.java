package com.jb_dev.quizappproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jb_dev.quizappproject.Model.Question;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;
    TextView mTextView2;
    TextView mScoreTextView;
    Question mQuestion;

    Button mButton;
    Button mButton2;
    Button mButton3;
    int answer;
    int questionAnswer;
    int score;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.TextView);
        mScoreTextView = (TextView) findViewById(R.id.scoreTextView);

        mButton = (Button) findViewById(R.id.Button);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton3 = (Button) findViewById(R.id.button3);

        score = 0;
        mScoreTextView.setText(score + "");
        getNewQuestion();












    }

    private void setButtonAction(boolean b) {

    }

    private void getNewQuestion() {
        Question question = new Question();
        mQuestion = question;
        questionAnswer = question.getAnswer();
        mTextView.setText(question.getQuestion());

        if(questionAnswer < 100) {
            setAnswerButtonsText(true, false, false);
        }else if(questionAnswer < 150) {
            setAnswerButtonsText(false, true, false);

        }else if(questionAnswer < 200) {
            setAnswerButtonsText(false, false, true);
        }

    }

    public void setAnswerButtonsText(boolean first, boolean second, boolean third) {
        boolean firstAnswer = first;
        boolean secondAnswer = second;
        boolean thirdAnswer = third;

        View.OnClickListener v = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Wrong Answer, Try Again!", Toast.LENGTH_LONG).show();

            }
        };

        View.OnClickListener v2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Right Answer! Well Done", Toast.LENGTH_LONG).show();
                getNewQuestion();
                score++;
                mScoreTextView.setText(score + "");
            }
        };


        if(firstAnswer) {
            mButton.setText(mQuestion.getAnswer() + "");
            mButton2.setText(mQuestion.getFalseAnswer1() + "");
            mButton3.setText(mQuestion.getFalseAnswer2() + "");
            mButton.setOnClickListener(v2);
            mButton2.setOnClickListener(v);
            mButton3.setOnClickListener(v);
        } else if (secondAnswer) {
            mButton.setText(mQuestion.getFalseAnswer1() + "");
            mButton2.setText(mQuestion.getAnswer() + "");
            mButton3.setText(mQuestion.getFalseAnswer2() + "");
            mButton.setOnClickListener(v);
            mButton2.setOnClickListener(v2);
            mButton3.setOnClickListener(v);
        } else if (thirdAnswer) {
            mButton.setText(mQuestion.getFalseAnswer1() + "");
            mButton2.setText(mQuestion.getFalseAnswer2() + "");
            mButton3.setText(mQuestion.getAnswer() + "");
            mButton.setOnClickListener(v);
            mButton2.setOnClickListener(v);
            mButton3.setOnClickListener(v2);
        }






    }

}
