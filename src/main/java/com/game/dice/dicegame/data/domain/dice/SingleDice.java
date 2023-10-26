package com.game.dice.dicegame.data.domain.dice;

public class SingleDice extends BaseDice {

  public SingleDice(Integer faces) {
    super(faces);
  }

  @Override
  public Integer roll() {
    return fetchRandFace(faces);
  }
}
