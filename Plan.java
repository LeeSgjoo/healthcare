package healthcare;
import java.util.Scanner;
import java.util.ArrayList;

class Plan{
    private String title;
    private String[] Kind;
    private int month;
    private int day;
    private int days; // ex) 1/15 => 15 days
    private int Tminute;
    private int Tsecond;
    private int Ttotal; // Timer total seconds
    private boolean iscompleted;
    private static final int[] MAX_DAYS= {0,31,28,31,30,31,30,31,31,30,31,30,31};

    public Plan();
    public Plan(String title, String kind, int month, int day, int Tminute, int Tsecond){
        this.title = title;
        this.kind = kind;
        this.month = month;
        this.day = day;
        this.Tminute = Tminute;
        this.Tsecond = Tsecond;
        this.iscompleted = false;
    }

    public String[] getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setTitle(){
        String title;
        System.out.print("Enter title: ");
        title = sc.nextLine();
        this.title = title;
    }

    public String getKind() {
        return kind;
    }
    public void setKind(){
        int kind_num;
        String temp;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of exercises: ");
        kin_num = nextInt();
        this.kind = new String[kind_num];

        for (int i = 0; i < kind_num; i++) {
            System.out.print("Enter kind("  + (i+1) + "): ");
            temp = sc.nextLine();
            kind[i] = temp;
        }
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setMonth() {
        int month;
        boolean vaild = false;
        while(vaild == false) {
            System.out.println("input month : ");
            if (month >= 1 && month <= 12) {
                this.month = month;
                vaild = true;
            }
            else {
                System.out.println("Error: invalid day!!");
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
        int day;
        boolean vaild = false;
        while(vaild == false) {
            System.out.println("input day : ");
            if (day >= 1 && day <= MAX_DAYS[this.month]) {
                this.day = day;
                vaild = true;
            }
            else {
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
        int Tminute;
        boolean vaild = false;
        Scanner sc = new Scanner(System.in);
        while(vaild == false) {
            System.out.println("Set minute of timer : ");
            Tminute = sc.nextInt();

            if (Tminute >= 0 && Tminute <= 59) {
                this.Tminute = Tminute;
                vaild = true;
            }
            else System.out.println("Error: invalid minute!!");
        }
    }
    public int getTsecond() {
        return Tsecond;
    }
    public void setTsecond(int Tsecond) {
        this.Tsecond = Tsecond;
    }
    public void setTsecond() {
        int Tsecond;
        boolean vaild = false;
        Scanner sc = new Scanner(System.in);
        while(vaild == false) {
            System.out.println("Set second of timer : ");
            Tsecond = sc.nextInt();
            if (Tsecond >= 0 && Tsecond <= 59) {
                this.Tsecond = Tsecond;
                vaild = true;
            }
            else System.out.println("Error: invalid second!!");
        }
    }
    public int getDays(){
        days = MAX_DAYS[this.month] - this.day;
        return days;
    }
    public String getIscompleted(){
        if(this.iscompleted == true) {
            return "(Y)";
        }
        else {
            return "(N)";
        }
    }
    public void checkComplete(){
        this.iscompleted = true;
    }
    public int getTtotal(){
        return (Tminute/60 + Tsecond);
    }

    // 날짜 정렬도 해야 하는디 고냥 플랜을 어레이리스트로 담을 까?
    public void printPlan(){
        String information;
        information = (month + "/" + day + " - " + title + getIscompleted()); // 타이틀은 레그데이라던가
        System.out.println(information);
    }
}