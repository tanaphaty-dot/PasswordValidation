// ดูโจทย์ วิธีทำใน README.md
// หน้าที่ของคุณ: ออกแบบ test เอง แล้วเติม check(...) ให้ครบทุก branch
public class TestRunner {

    static int pass = 0, fail = 0;

    static void check(String name, boolean ok) {
        if (ok) { pass++; System.out.println("  [PASS] " + name); }
        else    { fail++; System.out.println("  [FAIL] " + name); }
    }

    public static void main(String[] a) {
        boolean ea = false;
        assert ea = true;
        if (!ea) System.out.println("** คำเตือน: assertion ปิดอยู่ รันด้วย  java -ea TestRunner **");

        System.out.println("== Password Validation ==");

        // ตัวอย่าง assertion ปกติ (ตัวแทนกลุ่ม valid)
        check("'Abcdef12' valid", PasswordValidator.validate("Abcdef12"));

        // ตัวอย่างแพตเทิร์นทดสอบ "ต้อง throw" ด้วย try/catch
        boolean threw = false;
        try { PasswordValidator.validate(null); }
        catch (IllegalArgumentException e) {  threw = true; }
        check("null -> throws IllegalArgumentException",  threw);

        // TODO: R2 - boundary ความยาว (เช่น 7, 8, 20, 21)
        check("Length 7 ('Abc1234') -> false", PasswordValidator.validate("Abc1234") == false);
        check("Length 8 ('Abc12345') -> true", PasswordValidator.validate("Abc12345") == true);
        check("Length 20 ('Abcdef12345678901234') -> true", PasswordValidator.validate("Abcdef12345678901234") == true);
        check("Length 21 ('Abcdef123456789012345') -> false", PasswordValidator.validate("Abcdef123456789012345") == false);
        // TODO: R3 - ไม่มีตัวพิมพ์ใหญ่ -> false
        check("No uppercase ('abcdef12') -> false", PasswordValidator.validate("abcdef12") == false);
        // TODO: R4 - ไม่มีตัวพิมพ์เล็ก -> false
        check("No lowercase ('ABCDEF12') -> false", PasswordValidator.validate("ABCDEF12") == false);
        // TODO: R5 - ไม่มีตัวเลข -> false
        check("No Number ('Abcdefgh') -> false",PasswordValidator.validate("Abcdefgh") == false);
        // TODO: R6 - มีช่องว่าง -> false
        check("Don't space  ('Abce df12') -> false",PasswordValidator.validate("Abce df12") == false );
        check("Don't space (' Abcdef12') -> false", PasswordValidator.validate(" Abcdef12") == false);
        check("Don't space ('Abcdef12 ') -> false", PasswordValidator.validate("Abcdef12 ") == false);

        // TODO: boundary อื่นๆ ที่คุณคิดว่าจำเป็น
        check("Empty string -> false", PasswordValidator.validate("") == false);

        System.out.println("==================================");
        System.out.printf("PASS %d / FAIL %d%n", pass, fail);
        System.out.println("==================================");
        System.exit(fail == 0 ? 0 : 1);
    }
}

//         check("Special characters included ('Abc!@123') -> true", PasswordValidator.validate("Abc!@123") == true);
