package com.jb_dev.quizappproject.Model;

import java.util.Random;

/**
 * Created by Dad on 9/7/2016.
 */

public class Question {
    int mFirstNumber;
    int mSecondNumber;
    int mAnswer;
    int mFalseAnswer1;
    int mFalseAnswer2;
    int mFalseAnswer3;

    String mQuestion;

    public Question() {
        mFirstNumber = getNewNumber();
        mSecondNumber = getNewNumber();
        mAnswer = mFirstNumber + mSecondNumber;
        mQuestion = mFirstNumber + " + " + mSecondNumber + " = ";
        mFalseAnswer1 = mAnswer + 3;
        mFalseAnswer2 = mAnswer - 5;
        mFalseAnswer3 = mAnswer + 5;
    }

    public void getNewQuestion() {
        mFirstNumber = getNewNumber();
        mSecondNumber = getNewNumber();
        mAnswer = mFirstNumber + mSecondNumber;
        mQuestion = mFirstNumber + " + " + mSecondNumber + " = ";
        mFalseAnswer1 = mAnswer + 3;
        mFalseAnswer2 = mAnswer - 5;
        mFalseAnswer3 = mAnswer + 5;

    }

    public int getNewNumber() {
            Random randomNumber = new Random();
            int i = randomNumber.nextInt(100);

            return i;
        }



    public String getQuestion() {
        return mQuestion;
    }

    public int getAnswer() {
        return mAnswer;
    }

    public int getFalseAnswer1() {
        return mFalseAnswer1;
    }

    public int getFalseAnswer2() {
        return mFalseAnswer2;
    }

    public int getFalseAnswer3() {
        return mFalseAnswer3;
    }
}
