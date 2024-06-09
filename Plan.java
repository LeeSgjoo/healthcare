package healthcare;

import java.util.Scanner;

class Plan {
    private String title;
    private String[] kind;
    private int month;
    private int day;
    private int days; // ex) 1/15 => 15 days
    private int Tminute;
    private int Tsecond;
    private int Ttotal; // Timer total seconds
    private boolean iscompleted;
    private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static Scanner sc = new Scanner(System.in);

    public Plan() {}

    public Plan(String title, String kind, int month, int day, int Tminute, int Tsecond) {
        this.title = title;
        this.month = month;
        this.day = day;
        this.Tminute = Tminute;
        this.Tsecond = Tsecond;
        this.iscompleted = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitle() {
        System.out.print("Enter title: ");
        this.title = sc.nextLine();
    }

    public String[] getKind() {
        return kind;
    }

    public void setKind() {
        System.out.print("Enter number of exercises: ");
        int kind_num = sc.nextInt();
        sc.nextLine(); // consume the remaining newline
        this.kind = new String[kind_num];

        for (int i = 0; i < kind_num; i++) {
            System.out.print("Enter kind(" + (i + 1) + "): ");
            kind[i] = sc.nextLine();
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setMonth() {
        boolean valid = false;
        while (!valid) {
            System.out.print("Input month: ");
            int month = sc.nextInt();
            if (month >= 1 && month <= 12) {
                this.month = month;
                valid = true;
            } else {
                System.out.println("Error: invalid month!!");
            }
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setDay() {
        boolean valid = false;
        while (!valid) {
            System.out.print("Input day: ");
            int day = sc.nextInt();
            if (day >= 1 && day <= MAX_DAYS[this.month]) {
                this.day = day;
                valid = true;
            } else {
                System.out.println("Error: invalid day!!");
            }
        }
    }

    public int getTminute() {
        return Tminute;
    }

    public void setTminute(int Tminute) {
        this.Tminute = Tminute;
    }

    public void setTminute() {
        boolean valid = false;
        while (!valid) {
            System.out.print("Set minute of timer: ");
            int Tminute = sc.nextInt();
            if (Tminute >= 0 && Tminute <= 59) {
                this.Tminute = Tminute;
                valid = true;
            } else {
                System.out.println("Error: invalid minute!!");
            }
        }
    }

    public int getTsecond() {
        return Tsecond;
    }

    public void setTsecond(int Tsecond) {
        this.Tsecond = Tsecond;
    }

    public void setTsecond() {
        boolean valid = false;
        while (!valid) {
            System.out.print("Set second of timer: ");
            int Tsecond = sc.nextInt();
            if (Tsecond >= 0 && Tsecond <= 59) {
                this.Tsecond = Tsecond;
                valid = true;
            } else {
                System.out.println("Error: invalid second!!");
            }
        }
    }

    public int getDays() {
        days = MAX_DAYS[this.month] - this.day;
        return days;
    }

    public String getIscompleted() {
        return this.iscompleted ? "(Y)" : "(N)";
    }

    public void checkComplete() {
        this.iscompleted = true;
    }

    public int getTtotal() {
        return (Tminute * 60 + Tsecond);
    }

    public void printPlan() {
        String information = (month + "/" + day + " - " + title + " " + getIscompleted());
        System.out.println(information);
    }
}
