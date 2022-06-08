package businesslogiclayer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationValues {
    public boolean Telephone(String phoneNumber) throws Exception{
        String regex = "(?:\\+7\\(\\d{3}\\)|\\d{3}-)\\d{3}-\\d{2}-\\d{2}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phoneNumber);
        boolean b = m.matches();
        if (b == false) throw new Exception(" Неверный формат телефона \n Необходимо +7(###)###-##-##");
        else return true;
    }
    
    public boolean Time(String time) throws Exception{
        String regex = "([0-1][0-9]|[2][0-3]):([0-5][0-9]):(\\d{2})";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(time);
        boolean b = m.matches();
        if (b == false) throw new Exception(" Неверный формат времени \n Необходимо hh:mm:ss");
        else return true;
    }
    
    public boolean Email(String email) throws Exception{
        String regex = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        boolean b = m.matches();
        if (b == false) throw new Exception("----- Вы ввели НЕнадежный пароль -----     \n"
                + "Пароль считается надежным, если он состоит из 8 или более символов,  \n"
                + "где символом может быть английская буква, цифра и знак подчеркивания \n"
                + "Пароль должен содержать хотя бы 1 заглавную букву, 1 маленькую букву и 1 цифру");
        else return true;
    }
    
    public boolean NumberAccount(String numberAccount) throws Exception{
        String regex = "\\d{5}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(numberAccount);
        boolean b = m.matches();
        if (b == false) throw new Exception(" Неверный формат номера \n Необходимо 5 цифр");
        else return true;
    }
}
