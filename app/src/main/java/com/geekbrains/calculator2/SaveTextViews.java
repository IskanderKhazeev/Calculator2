package com.geekbrains.calculator2;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

public class SaveTextViews implements Parcelable {
    private TextView textCalculation;
    private TextView textResult;



    public SaveTextViews(TextView textCalculation, TextView textResult) {
        this.textCalculation = textCalculation;
        this.textResult = textResult;
    }

    public TextView getTextCalculation() {
        return textCalculation;
    }

    public void setTextCalculation(TextView textCalculation) {
        this.textCalculation = textCalculation;
    }

    public TextView getTextResult() {
        return textResult;
    }

    public void setTextResult(TextView textResult) {
        this.textResult = textResult;
    }

    protected SaveTextViews(Parcel in) {
    }

    public static final Creator<SaveTextViews> CREATOR = new Creator<SaveTextViews>() {
        @Override
        public SaveTextViews createFromParcel(Parcel in) {
            return new SaveTextViews(in);
        }

        @Override
        public SaveTextViews[] newArray(int size) {
            return new SaveTextViews[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
