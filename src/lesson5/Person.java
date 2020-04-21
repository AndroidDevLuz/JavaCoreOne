package lesson5;

public class Person {

    private String fio;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String fio,
                  String position,
                  String email,
                  String phone,
                  int salary,
                  int age){

        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

    }

    public int getAge() {
        return age;
    }

    public void showInfo() {
        System.out.printf("%s\n %s\n  %s\n  %s\n  %s\n  %s\n\n", fio, position, email, phone, salary, age);
    }
}
