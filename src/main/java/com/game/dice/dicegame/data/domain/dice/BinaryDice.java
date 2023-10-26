package com.game.dice.dicegame.data.domain.dice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.util.Pair;

public class BinaryDice extends BaseDice {

  private final List<Pair<Integer, Integer>> superpositionFace;

  public BinaryDice(Integer faces) {
    super(faces);
    superpositionFace = new ArrayList<>();

    for (int i = 0; i < faces; i++) {
      superpositionFace.add(Pair.of(fetchRandFace(faces), fetchRandFace(faces)));
    }
  }

  @Override
  public Integer roll() {
    Pair<Integer, Integer> rolledPair = superpositionFace.get(fetchRandFace(faces));
    return rolledPair.getFirst() + rolledPair.getSecond();
  }
}
