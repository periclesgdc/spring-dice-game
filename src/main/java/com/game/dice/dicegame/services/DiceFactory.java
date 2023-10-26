package com.game.dice.dicegame.services;

import org.springframework.stereotype.Service;

import com.game.dice.dicegame.data.domain.dice.SingleDice;
import com.game.dice.dicegame.data.domain.dice.Dice;
import com.game.dice.dicegame.data.domain.dice.BinaryDice;
import com.game.dice.dicegame.data.enums.DiceFacesEnum;
import com.game.dice.dicegame.data.enums.DiceTypeEnum;

@Service
public class DiceFactory {

  public Dice create(DiceFacesEnum faces, DiceTypeEnum type) {
    switch (type) {
      case DICE:
        return new SingleDice(faces.getFaces());
      case BINARY_DICE:
        return new BinaryDice(faces.getFaces());
      default:
        return null;
    }
  }
}
