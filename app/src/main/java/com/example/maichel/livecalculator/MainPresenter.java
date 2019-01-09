package com.example.maichel.livecalculator;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View mView;

    public MainPresenter(MainContract.View  view) {
        mView = view;
    }

    @Override
    public void onInputUpdate(int nb1, int nb2) {
        int result = nb1 + nb2;
        if (mView != null) {
            mView.updateResult(result);
        }
    }
}
