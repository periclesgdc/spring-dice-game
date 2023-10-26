package com.game.dice.dicegame.data.domain.dice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class BaseDice implements Dice {

  @Getter
  protected Integer faces;
}
