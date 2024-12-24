package Project2_이슬;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgramManager {
    
    static HashMap<String, Programs> prgmMap = new HashMap<>();
    static DataFile fileCtrl = new DataFile("programs");
    Scanner scan = new Scanner(System.in);

    public static void showAllPrograms() throws Exception {
        prgmMap = fileCtrl.prgmLoadFile();

        for (Map.Entry<String, Programs> entry : prgmMap.entrySet()) {
            Programs program = entry.getValue();
            if (program.isConfirmed() && program.isAvailable()) {
                System.out.println(program.toString());
            }
        }
    }
}
