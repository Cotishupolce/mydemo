import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String[][] nA = {{"1","2","3","4","5","6","7","8","9","10"},{"100"}};
        String[][] nR = {{"I","II","III","IV","V","VI","VII","VIII","IX","X"},{"C","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"}};
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] s1 = new String[3];
        int[] nT = new int[2];
        int[] gen = new int[2];
        char[] oT = new char[3];
        int [] p = new int[2];
        char[] oTT = {'0','1','2','3','4','5','6','7','8','9'};
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            s1[0] = sc.next();      // первое число
            s1[1] = sc.next();      // операция
            s1[2] = sc.next();      // второе число
            sc.close();
        }
        for (int i = 0; i <= 9; i++) { // проверка на собвадения с nR и nA, и последующего присвоения int значений из num.

                if (nA[0][i].equals((s1[0]))) {
                    nT[0] = num[i];
                    gen[0] = 1;
                    p[0]=1;
                }
                if(nA[0][i].equals(s1[2])){
                    nT[1] = num[i];
                    gen[1] = 1;
                    p[1]=1;
                }
                if (nR[0][i].equals(s1[0])) {
                    nT[0] = num[i];
                    gen[0] = 0;
                    p[0]=1;

                }if(nR[0][i].equals(s1[2])){
                    nT[1] = num[i];
                    gen[1] = 0;
                    p[1]=1;
                }
        }
        if (p[0]!=p[1]){
                        try{
                            throw new IOException();
                        }catch (IOException e) {
                            System.out.println("т.к. используются неподходящие числа");
                            System.exit(0);
                        }
        }
        if (gen[0]==gen[1]){
                switch (gen[0]) {
                    case 1 -> {                 //Операции с арабскими цифрами
                        switch (s1[1]) {
                            case "+" -> System.out.println(nT[0] + nT[1]);
                            case "-" -> System.out.println(nT[0] - nT[1]);
                            case "*" -> System.out.println(nT[0] * nT[1]);
                            case "/" -> System.out.println(nT[0] / nT[1]);
                            default -> {
                                try {
                                    throw new IOException();
                                } catch (IOException e) {
                                    System.out.println("т.к. форма математической операции не удовлетворяет заданию - два операнда и один оператор (+,-,/,*)");
                                    System.exit(0);
                                }
                            }
                        }
                    }
                    case 0 -> {                 //Операции с римскими цифрами
                        switch (s1[1]) {
                            case "+" -> {
                                String fa = String.valueOf(nT[0] + nT[1]);
                                switch (fa.length()) {
                                    case 1 -> {
                                        for (int i = 0; i <= 9; i++) {
                                            if (fa.equals(nA[0][i])) {
                                                System.out.println(nR[0][i]);
                                            }
                                        }
                                    }
                                    case 2 -> {
                                        oT[0] = fa.charAt(0);
                                        oT[1] = fa.charAt(1);
                                        for (int i = 0; i <= 9; i++) {
                                            if ((oT[0] == oTT[i])) {
                                                switch (oT[1]) {
                                                    case '0' -> System.out.println(nR[1][i]);
                                                    case '1' -> System.out.println(nR[1][i] + nR[0][0]);
                                                    case '2' -> System.out.println(nR[1][i] + nR[0][1]);
                                                    case '3' -> System.out.println(nR[1][i] + nR[0][2]);
                                                    case '4' -> System.out.println(nR[1][i] + nR[0][3]);
                                                    case '5' -> System.out.println(nR[1][i] + nR[0][4]);
                                                    case '6' -> System.out.println(nR[1][i] + nR[0][5]);
                                                    case '7' -> System.out.println(nR[1][i] + nR[0][6]);
                                                    case '8' -> System.out.println(nR[1][i] + nR[0][7]);
                                                    case '9' -> System.out.println(nR[1][i] + nR[0][8]);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            case "-" -> {
                                if ((nT[0] - nT[1]) <= 0) {
                                    System.out.println("т.к. в римской системе нет отрицательных чисел и нуля");
                                } else {
                                    String fb = String.valueOf(nT[0] - nT[1]);
                                    for (int i = 0; i <= 9; i++) {
                                        if (fb.equals(nA[0][i])) {
                                            System.out.println(nR[0][i]);
                                        }
                                    }

                                }
                            }
                            case "*" -> {
                                String fc = String.valueOf(nT[0] * nT[1]);
                                switch (fc.length()) {
                                    case 1 -> {
                                        for (int i = 0; i <= 9; i++) {
                                            if (fc.equals(nA[0][i])) {
                                                System.out.println(nR[0][i]);
                                            }
                                        }
                                    }
                                    case 2 -> {
                                        oT[0] = fc.charAt(0);
                                        oT[1] = fc.charAt(1);
                                        for (int i = 0; i <= 9; i++) {
                                            if ((oT[0] == oTT[i])) {
                                                for (int i1 = 0; i1 <= 9; i1++) {
                                                    if (oT[1] == oTT[i1]) {
                                                        switch (oT[1]) {
                                                            case '0' -> System.out.println(nR[1][i]);
                                                            case '1' -> System.out.println(nR[1][i] + nR[0][0]);
                                                            case '2' -> System.out.println(nR[1][i] + nR[0][1]);
                                                            case '3' -> System.out.println(nR[1][i] + nR[0][2]);
                                                            case '4' -> System.out.println(nR[1][i] + nR[0][3]);
                                                            case '5' -> System.out.println(nR[1][i] + nR[0][4]);
                                                            case '6' -> System.out.println(nR[1][i] + nR[0][5]);
                                                            case '7' -> System.out.println(nR[1][i] + nR[0][6]);
                                                            case '8' -> System.out.println(nR[1][i] + nR[0][7]);
                                                            case '9' -> System.out.println(nR[1][i] + nR[0][8]);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    case 3 -> {
                                        if (fc.equals(nA[1][0])) {
                                            System.out.println(nR[1][0]);
                                        }
                                    }
                                }
                            }
                            case "/" -> {

                                if ((nT[0] / nT[1]) <= 0) {
                                    try{
                                        throw new IOException();
                                    }catch (IOException e) {
                                        System.out.println("т.к. в римской системе нет отрицательных чисел и нуля");
                                        System.exit(0);
                                    }
                                } else {
                                    String fb = String.valueOf(nT[0] / nT[1]);
                                    for (int i = 0; i <= 9; i++) {
                                        if (fb.equals(nA[0][i])) {
                                            System.out.println(nR[0][i]);
                                        }
                                    }
                                }
                            }
                            default -> {
                                try {
                                    throw new IOException();
                                } catch (IOException e) {
                                    System.out.println("т.к. форма математической операции не удовлетворяет заданию - два операнда и один оператор (+,-,/,*)");
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
            }else{
                try{
                    throw new IOException();
                }catch (IOException e) {
                    System.out.println("т.к. используются одновременно разные сисемы счисления");
                    System.exit(0);
                }
            }
    }
}

