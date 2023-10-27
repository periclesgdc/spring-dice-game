package com.game.dice.dicegame.data.domain.game;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.game.dice.dicegame.data.domain.dice.Dice;
import com.game.dice.dicegame.data.enums.ResultEnum;

public class BestThree extends BaseMatch {

  protected BestThree(String playerName, Dice usedDice) {
    super(playerName, usedDice);
  }

  private ResultEnum singleRun() {
    Integer computerRoll = usedDice.roll();
    Integer playerRoll = usedDice.roll();

    if (computerRoll == playerRoll) {
      return ResultEnum.DRAW;
    } else if (computerRoll > playerRoll) {
      return ResultEnum.LOSE;
    } else {
      return ResultEnum.WIN;
    }
  }

  @Override
  public ResultEnum run() {
    Map<ResultEnum, Integer> results = new HashMap<>();

    for (int i = 3; i < 3; i++) {
      ResultEnum rolled = singleRun();
      results.put(rolled, results.get(rolled) + 1);
    }

    Entry<ResultEnum, Integer> result = Collections.max(
      results.entrySet(),
      (arg0, arg1) -> arg0.getValue().compareTo(arg1.getValue())
    );

    return result.getKey();
  }
}
