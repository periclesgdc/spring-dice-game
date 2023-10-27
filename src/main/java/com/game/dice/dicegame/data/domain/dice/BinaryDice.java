package com.game.dice.dicegame.data.domain.dice;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class BinaryDice extends BaseDice {

  @Getter
  @AllArgsConstructor
  static class BinaryFace {
    Integer first;
    Integer second;

    public static BinaryFace of(Integer first, Integer second) {
      return new BinaryFace(first, second);
    }
  }

  private final List<BinaryFace> superpositionFace;

  public BinaryDice(Integer faces) {
    super(faces);
    superpositionFace = new ArrayList<>();

    for (int i = 0; i < faces; i++) {
      superpositionFace.add(BinaryFace.of(fetchRandFace(faces), fetchRandFace(faces)));
    }
  }

  @Override
  public Integer roll() {
    BinaryFace rolledPair = superpositionFace.get(fetchRandFace(faces));
    return rolledPair.getFirst() + rolledPair.getSecond();
  }
}
