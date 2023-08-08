package Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {

    public void validateRegistration(String login, String password, String confirmPassword)
            throws EmptyLoginException, InvalidCharacterException, PasswordConfirmationException, LengthException {
        if(login==null || login.trim().length()==0 ||
                password == null || password.length() == 0 ||
        confirmPassword == null || confirmPassword.length() == 0){
            throw new EmptyLoginException("Все поля должны быть заполнены!");
        }
        if(login.length() > 20 || password.length() > 20 || confirmPassword.length() > 20){
            throw new LengthException("Длина поля не должна превышать 20 символов!");
        }
        Pattern pattern = Pattern.compile("[^a-zA-z0-9_]");
        Matcher matcher1 = pattern.matcher(login);
        Matcher matcher2 = pattern.matcher(password);
        Matcher matcher3 = pattern.matcher(confirmPassword);
        if (matcher1.find() || matcher2.find() || matcher3.find()){
            throw new InvalidCharacterException("Введены недопустимые символы!");
        }

        if(!password.equals(confirmPassword)){
            throw new PasswordConfirmationException("Пароль и его подтверждение не совпадают!");
        }
    }

    public static void main(String[] args) {
        Registration registration = new Registration();
        try {
            registration.validateRegistration("758758689", "svas", "svas");
        } catch (EmptyLoginException e) {
            e.printStackTrace();
        } catch (InvalidCharacterException e) {
            e.printStackTrace();
        } catch (LengthException e) {
            e.printStackTrace();
        } catch (PasswordConfirmationException e) {
            e.printStackTrace();
        }
    }
}
