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

    boolean checkContainNumber(String password){
        return true;
    }

    boolean checkNumbersCont(String password){
        return true;
    }

    boolean checkNumberSame(String password){
        return true;
    }

    boolean containSpecialCharacter(String password){
        return true;
    }



    public static void main(String [] args){



    }
}
