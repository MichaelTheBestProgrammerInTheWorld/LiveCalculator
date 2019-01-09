package com.example.maichel.livecalculator;

public class MainContract {

    public interface Presenter {
        void onInputUpdate(int nb1, int nb2);
    }

    public interface View {
        void updateResult(int result);
    }

}
