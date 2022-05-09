package com.asteph11.finalproject.models.viewmodels;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.asteph11.finalproject.models.data.Player;
import com.asteph11.finalproject.models.data.TurnHandler;

public class MatchViewModel extends ViewModel {

    private TurnHandler turnHandler;

    public void init(Context c) {
        if(turnHandler == null) {
            initMatch(new Player("NA"), new Player("NA"));
        }
    }

    public void initMatch(Player p1, Player p2) {
        turnHandler = new TurnHandler(p1, p2);
    }

    public Player getP1() {
        return turnHandler.getP1();
    }

    public Player getP2() {
        return turnHandler.getP2();
    }

    public TurnHandler getTurnHandler() {
        return turnHandler;
    }

    public boolean gameReady() throws Exception {
        if(turnHandler == null || getP1() == null || getP2() == null) {
            throw new Exception("Turnover or Players are null!");
        }

        return getP1().isReady() && getP2().isReady();
    }

}