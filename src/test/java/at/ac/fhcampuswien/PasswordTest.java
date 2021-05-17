package at.ac.fhcampuswien;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {

  @BeforeAll
  static void init() {
  }

  @BeforeEach
  void setup() {
  }

  @Test
  @DisplayName("Is password length valid")
  public void testPasswordLength_Scenario1() {
    Password password = new Password("crashedUfo@47");
    assertTrue(password.passwordLength());
  }

  @Test
  public void testPasswordLength_Scenario2() {
    Password password = new Password("Ufo@47");
    assertFalse(password.passwordLength());
  }

  @Test
  public void testPasswordLength_Scenario3() {
    Password password = new Password("crashedUfo@crashed45@crashed");
    assertFalse(password.passwordLength());
  }

  @Test
  @DisplayName("are upper and lower case letters used")
  public void testCheckUpperAndLowerCase_Scenario1() {
    Password password = new Password("crashedUfo@47");
    assertTrue(password.checkUpperAndLowerCase());
  }

  @Test
  public void testCheckUpperAndLowerCase_Scenario2() {
    Password password = new Password("crashedufo@47");
    assertFalse(password.checkUpperAndLowerCase());
  }

  @Test
  public void testCheckUpperAndLowerCase_Scenario3() {
    Password password = new Password("CRASHEDUFOS46@");
    assertFalse(password.checkUpperAndLowerCase());
  }

  @Test
  @DisplayName("are numbers used")
  public void testCheckContainNumber_Scenario1() {
    Password password = new Password("crashedUfo@47");
    assertTrue(password.checkContainNumber());
  }

  @Test
  public void testCheckContainNumber_Scenario2() {
    Password password = new Password("crashedufo@crash");
    assertFalse(password.checkContainNumber());
  }

  @Test
  @DisplayName(" are not more then two continous numbers used")
  public void testCheckNumbersCont_Scenario1() {
    Password password = new Password("crashedUfo@47");
    assertTrue(password.checkNumbersCont());
  }

  //cont numbers at the end
  @Test
  public void testCheckNumbersCont_Scenario2() {
    Password password = new Password("crashedufo@456");
    assertFalse(password.checkNumbersCont());
  }

  //cont numbers at front
  @Test
  public void testCheckNumbersCont_Scenario3() {
    Password password = new Password("2345CRasHEDUFOS234@");
    assertFalse(password.checkNumbersCont());
  }

  //no numbers to check
  @Test
  public void testCheckNumbersCont_Scenario4() {
    Password password = new Password("CrashedUf@@os");
    assertFalse(password.checkNumbersCont());
  }

  //first not cont then cont
  @Test
  public void testCheckNumbersCont_Scenario5() {
    Password password = new Password("23CRasHEDUFOS234@");
    assertFalse(password.checkNumbersCont());
  }

  @Test
  @DisplayName(" are not more then three of the same numbers continously used")
  public void testCheckNumberSame_Scenario1() {
    Password password = new Password("crashedUfo@444");
    assertTrue(password.checkNumberSame());
  }

  //cont numbers at the end
  @Test
  public void testCheckNumberSame_Scenario2() {
    Password password = new Password("crashedufo@5555");
    assertFalse(password.checkNumberSame());
  }

  //cont numbers at front
  @Test
  public void testCheckNumberSame_Scenario3() {
    Password password = new Password("22222CRasHEDUFOS234@");
    assertFalse(password.checkNumberSame());
  }

  //no numbers to check
  @Test
  public void testCheckNumberSame_Scenario4() {
    Password password = new Password("CrashedUf@@os");
    assertFalse(password.checkNumberSame());
  }

  @Test
  public void testCheckNumberSame_Scenario5() {
    Password password = new Password("333Crashe7777dUf@@os");
    assertFalse(password.checkNumberSame());
  }

  @Test
  @DisplayName("are valid special characters used")
  public void testContainSpecialCharacter_Scenario1() {
    Password password = new Password("crashedUfo@47");
    assertTrue(password.containSpecialCharacter());
  }

  @Test
  public void testContainSpecialCharacter_Scenario2() {
    Password password = new Password("crashedufo4Crash7");
    assertFalse(password.containSpecialCharacter());
  }

  @Test
  public void testContainSpecialCharacter_Scenario3() {
    Password password = new Password("Cras{}hedUfo47");
    assertFalse(password.containSpecialCharacter());
  }

  @Test
  public void testContainSpecialCharacter_Scenario4() {
    Password password = new Password("Cras{}he#dUfo@47");
    assertFalse(password.containSpecialCharacter());
  }

  @Test
  @DisplayName("is hole password valid")
  public void testCheckPassword_Scenario1() {
    Password password = new Password("crashedUfo@47");
    assertTrue(password.checkPassword());
  }

  @Test
  public void testCheckPassword_Scenario2() {
    Password password = new Password("crashed");
    assertFalse(password.checkPassword());
  }

  @Test
  public void testCheckPassword_Scenario3() {
    Password password = new Password("crashedufo11@1147");
    assertFalse(password.checkPassword());
  }

  @Test
  public void testCheckPassword_Scenario4() {
    Password password = new Password("Crashe#dUfo@456");
    assertFalse(password.checkPassword());
  }

  @Test
  public void testCheckPassword_Scenario5() {
    Password password = new Password("Cras@hedUfo111147");
    assertFalse(password.checkPassword());
  }
}
