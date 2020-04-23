package lesson5;

public class Employees {

    private static Person[] persArray;

    public static void main(String[] args) {
        fillAdapter();
        printPersonFields(persArray);
    }

    private static void fillAdapter() {
        persArray = new Person[5];
        persArray[0] = new Person("Иванов Иван","Инженер", "ii@gmail.com", "+79996669966",30000, 67);
        persArray[1] = new Person("Петров Вася","Инженер", "pv@gmail.com", "+79996669966",30000, 21);
        persArray[2] = new Person("Благодарный Леха","Инженер", "sl@gmail.com", "+79996669966",30000, 45);
        persArray[3] = new Person("Лузянин Николай","Developer", "nl9166420458@gmail.com", "+79166420458",40000, 36);
        persArray[4] = new Person("Бывалый Игорь","Инженер", "ii@gmail.com", "+79996669966",30000, 44);
    }

    private static void printPersonFields(Person[] array) {
        for(int i=0; i < 5; i++){
            if(array[i].getAge() > 40) {
                array[i].showInfo();
            }
        }
    }
}
