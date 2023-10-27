package com.game.dice.dicegame.data.domain.game;

import com.game.dice.dicegame.data.domain.dice.Dice;
import com.game.dice.dicegame.data.enums.MatchModeEnum;
import com.game.dice.dicegame.data.enums.ResultEnum;

public interface Match {

  public static Match create(String playerName, Dice dice, MatchModeEnum matchMode) {
    switch (matchMode) {
      case MAX_VALUE:
        return new MaxValueMatch(playerName, dice);
      case BEST_THREE:
        return new BestThree(playerName, dice);
      default:
        return null;
    }
  }

  public ResultEnum run();
  public String print();
}
