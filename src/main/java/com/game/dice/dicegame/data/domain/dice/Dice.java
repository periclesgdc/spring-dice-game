package com.game.dice.dicegame.data.domain.dice;

import java.util.Random;

public interface Dice {

  public Integer getFaces();
  public Integer roll();

  default public Integer fetchRandFace(Integer faces) {
    return new Random().nextInt(faces);
  }
}
