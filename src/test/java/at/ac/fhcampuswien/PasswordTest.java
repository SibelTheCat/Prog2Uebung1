package at.ac.fhcampuswien;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {

  @BeforeAll
  static void init(){}

  @BeforeEach
  void setup(){}

  @Test
  @DisplayName("Is password length valid")
    public void testPasswordLength_Scenario1(){
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
  public void testCheckUpperAndLowerCase_Scenario1(){
    Password password = new Password("crashedUfo@47");
    assertTrue(password.checkUpperAndLowerCase());
  }
  @Test
  public void testCheckUpperAndLowerCaseh_Scenario2() {
    Password password = new Password("crashedufo@47");
    assertFalse(password.checkUpperAndLowerCase());
  }
  @Test
  public void testCheckUpperAndLowerCase_Scenario3() {
    Password password = new Password("CRASHEDUFOS46@");
    assertFalse(password.checkUpperAndLowerCase());
  }
}
