package com.game.dice.dicegame.data.domain.game;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.game.dice.dicegame.data.domain.dice.Dice;
import com.game.dice.dicegame.data.enums.ResultEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public abstract class BaseMatch implements Match {

  @Id
  protected UUID id;

  @Column(length = 25, nullable = false)
  protected String playerName;

  @Column(nullable = false)
  protected Dice usedDice;

  protected List<ResultEnum> results = new ArrayList<>();

  protected BaseMatch(String playerName, Dice usedDice) {
    this.id = UUID.randomUUID();
    this.playerName = playerName;
    this.usedDice = usedDice;
  }
}
