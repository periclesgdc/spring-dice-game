package com.game.dice.dicegame;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.game.dice.dicegame.data.domain.dice.Dice;
import com.game.dice.dicegame.data.domain.game.Match;
import com.game.dice.dicegame.data.enums.DiceFacesEnum;
import com.game.dice.dicegame.data.enums.DiceTypeEnum;
import com.game.dice.dicegame.data.enums.MatchModeEnum;
import com.game.dice.dicegame.data.enums.ResultEnum;
import com.game.dice.dicegame.services.DiceFactory;


@SpringBootTest
class DicegameApplicationTests {

  @Autowired
  DiceFactory diceFactory;

	@Test
	void creationTest() {

    for (DiceTypeEnum diceType : DiceTypeEnum.values()) {
      Dice currentDice = diceFactory.create(DiceFacesEnum.D6, diceType);

      assertEquals(DiceFacesEnum.D6.getFaces(), currentDice.getFaces());
    }
	}

  @Test
  void maxValueMatchTest() {
    Dice currentDice = diceFactory.create(DiceFacesEnum.D6, DiceTypeEnum.DICE);
    Match currentMatch = Match.create("Player 1", currentDice, MatchModeEnum.MAX_VALUE);

    ResultEnum result = currentMatch.run();

    assertNotNull(result, result.name());
  }
}
