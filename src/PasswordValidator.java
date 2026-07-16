// ดูโจทย์ spec และวิธีทำใน README.md
public class PasswordValidator {

    static final int MIN_LEN = 8;
    static final int MAX_LEN = 20;

    static boolean validate(String pw) {
        // TODO: implement ตาม spec ใน README.md (R1-R6)
                // R1: pw ต้องไม่เป็น null -> throw IllegalArgumentException
            if (pw == null) {
                throw new IllegalArgumentException("Password cannot be null");
        }

                // R2: ความยาว >= 8 และ <= 20 (inclusive)
             if (pw.length() < MIN_LEN || pw.length() > MAX_LEN) {
                return false;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;

        // วนลูปตรวจเช็คตัวอักษรทีละตัว
        for (int i = 0; i < pw.length(); i++) {
            char ch = pw.charAt(i);

            if (ch == ' ') {
                return false;
            }

                // ตรวจสอบเงื่อนไขตัวอักษรแต่ละประเภท
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        return hasUpper && hasLower && hasDigit;
    }
}
