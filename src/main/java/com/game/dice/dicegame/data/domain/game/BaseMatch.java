package com.game.dice.dicegame.data.domain.game;

import java.util.ArrayList;
import java.util.List;

import com.game.dice.dicegame.data.domain.dice.Dice;
import com.game.dice.dicegame.data.enums.ResultEnum;


public abstract class BaseMatch implements Match {

  protected String playerName;
  protected Dice usedDice;

  protected List<ResultEnum> results = new ArrayList<>();

  protected BaseMatch(String playerName, Dice usedDice) {
    this.playerName = playerName;
    this.usedDice = usedDice;
  }

  @Override
  public String print() {
    return "%s used %s".formatted(playerName, usedDice.getClass().getSimpleName());
  }
}
