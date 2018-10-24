package com.example.sprintboot.entity;

import com.example.sprintboot.core.PersistenceRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuctionType {
    Person person;
    History history;
    Winner winner;


    public AuctionType() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public Winner getWinner() {
        return winner;
    }

    public void setWinner(Winner winner) {
        this.winner = winner;
    }
}
