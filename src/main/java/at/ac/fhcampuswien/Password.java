package at.ac.fhcampuswien;

public class Password {
    private String password;

    //Default Constructor
    public Password(){
    }

    public Password(String password){
        this.password= password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    boolean checkPassword(){
        if(passwordLength()){
            return true;
        }
        else return false;
    }

    boolean passwordLength(){
        if (this.password.length()> 8 && this.password.length()<25){
            return true;
        }
        else return false;
    }
// help from https://stackoverflow.com/questions/40336374/how-do-i-check-if-a-java-string-contains-at-least-one-capital-letter-lowercase
    boolean checkUpperAndLowerCase(){
        boolean lowerCase = this.password.matches(".*[A-Z].*");
        boolean upperCase = this.password.matches(".*[a-b].*");
        if(lowerCase && upperCase) {
            return true;
        }
        else return false;
    }

    boolean checkContainNumber(){
       return this.password.matches(".*[1-9].*");
    }

    boolean checkNumbersCont(){
        if (checkContainNumber()== false) {
            return false;
        }

        //help from https://stackoverflow.com/questions/4047808/what-is-the-best-way-to-tell-if-a-character-is-a-letter-or-number-in-java-withou
        else
            // look for a number in the string, then check if the two foolowing chars are also numbers, if so, add all numbers and devide by 3, if they equal the number
        //after the first number the numbers are continous. then retrun false
            for (int i = 0; i < this.password.length()-2; i++){
            if (Character.isDigit(this.password.charAt(i))&& Character.isDigit(this.password.charAt(i+1)) && Character.isDigit(this.password.charAt(i+2))){
                if (((this.password.charAt(i))+(this.password.charAt(i+1))+(this.password.charAt(i+2)))/3 == (this.password.charAt(i+1))) {
                    return false;
                }
            }
        }
            return true;
    }

    boolean checkNumberSame(){
        if (checkContainNumber()== false) {
            return false;
        }

        //help from https://stackoverflow.com/questions/4047808/what-is-the-best-way-to-tell-if-a-character-is-a-letter-or-number-in-java-withou
        else
            // look for a number in the string, then check if the two foolowing chars are also numbers, if so, add all numbers and devide by 3, if they equal the number
            //after the first number the numbers are continous. then retrun false
            for (int i = 0; i < this.password.length()-3; i++){
                if (Character.isDigit(this.password.charAt(i))&& Character.isDigit(this.password.charAt(i+1)) && Character.isDigit(this.password.charAt(i+2))&& Character.isDigit(this.password.charAt(i+3))){
                    if (((this.password.charAt(i))+(this.password.charAt(i+1))+(this.password.charAt(i+2))+(this.password.charAt(i+3)))/4 == (this.password.charAt(i))) {
                        return false;
                    }
                }
            }
        return true;
    }

    boolean containSpecialCharacter(){
        boolean containsSpecialCharacter = this.password.matches(".*[!@#$%()?/].*");
        boolean containsNoOtherSpecialCharacter = this.password.matches("[a-zA-Z0-9!@#$%()?/]*");

        if (containsSpecialCharacter&&containsNoOtherSpecialCharacter){
            return true;
        }
        else return false;
    }



    public static void main(String [] args){



    }
}
