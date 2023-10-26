package com.game.dice.dicegame.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DiceFacesEnum {
  D6(6),
  D10(10),
  D20(20);

  private Integer faces;
}
