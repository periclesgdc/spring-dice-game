package com.game.dice.dicegame;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.game.dice.dicegame.data.domain.game.Match;
import com.game.dice.dicegame.data.enums.DiceFacesEnum;
import com.game.dice.dicegame.data.enums.DiceTypeEnum;
import com.game.dice.dicegame.data.enums.MatchModeEnum;
import com.game.dice.dicegame.services.DiceFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor@Slf4j
public class PlayedMatch implements CommandLineRunner {

  private final DiceFactory diceFactory;

  @Override
  public void run(String... args) throws Exception {
    Match currentMatch = Match.create("Player one", diceFactory.create(DiceFacesEnum.D6, DiceTypeEnum.DICE), MatchModeEnum.MAX_VALUE);
    log.info("Created a match -> {}", currentMatch.print());

    var result = currentMatch.run();

    log.info("Result -> {}", result);
  }
}
