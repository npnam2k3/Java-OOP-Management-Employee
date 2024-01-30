package managerEmployee;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Validate {
    public static boolean validateId(String id) {
        boolean checkId = false;
        if (id.length() >= 1 && id.length() <= 10)
            checkId = true;
        return checkId;
    }

    public static boolean validateName(String name) {
        boolean checkName = false;
        name.isBlank();
        if (name.length() >= 3 && name.length() <= 100)
            checkName = true;
        return checkName;
    }

    public static boolean validateBirthDate(String birthDate) {
        boolean checkBirthDate = false;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                    .withResolverStyle(ResolverStyle.STRICT); //ResolverStyle.STRICT: có tác dụng kiểm tra 1 ngày có tồn tại trong lịch hay không
            LocalDate.parse(birthDate, formatter); //chuyển từ string sang LocalDate theo mẫu được xác định bởi DateTimeFormatter
            checkBirthDate = true; //nếu khi chuyển đổi không xảy ra ngoại lệ => định dạng đúng
        } catch (DateTimeParseException e) {
            checkBirthDate = false;
        }
        return checkBirthDate;
    }

    public static boolean validatePhoneNumber(String phoneNumber){
        boolean checkPhoneNumber = false;
        if(phoneNumber.length() == 10){
            checkPhoneNumber = true;
        }
        return checkPhoneNumber;
    }

    public static boolean validateNumOfWorkingDay(int numOfWorkingDay){
        boolean check = false;
        if(numOfWorkingDay>0)
            check = true;
        return check;
    }
}
