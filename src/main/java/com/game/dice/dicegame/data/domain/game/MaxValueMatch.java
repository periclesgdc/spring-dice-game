package com.game.dice.dicegame.data.domain.game;

import com.game.dice.dicegame.data.domain.dice.Dice;
import com.game.dice.dicegame.data.enums.ResultEnum;

public class MaxValueMatch extends BaseMatch {

  protected MaxValueMatch(String playerName, Dice usedDice) {
    super(playerName, usedDice);
  }

  @Override
  public ResultEnum run() {
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
}
