import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class task {
    public final static Scanner sc = new Scanner(System.in);       

    public static void sortLaptop(int ramUser, int storUser, double digUser,  Set<Laptop> unicLaptop)
{

    System.out.println("Введите желаемую характеристику для отбора 1-память, 2-накопитель, 3-диагональ ");
    int sort = sc.nextInt();

    switch (sort) {
        case 1:
            System.out.println("объем оперативной памяти: ");
            ramUser = sc.nextInt();
            break;
        case 2:
            System.out.println("объем накопителя: ");
            storUser = sc.nextInt();
            break;
        case 3:
            System.out.println("диагональ");
            digUser = sc.nextDouble();
            break;
        default:
        break;
    }
    for(Laptop lap: unicLaptop) {
        if ((lap.getRam() >= ramUser) && (lap.getStorageCap() >= storUser)  && lap.getDiagonal() >= digUser) {
            System.out.println(lap.toString());
        }
    }
}
    
    public static void main(String[] args) throws Exception {
        
        Laptop laptop1 = new Laptop("Lenovo IdealPad 5", 8, 256, "Windows 11", "синий", 15.6);
        Laptop laptop2 = new Laptop("Honor MagicBook 16", 16, 512, "без ОС", "серый", 16.1);
        Laptop laptop3 = new Laptop("Apple MacBook Air 13", 8, 256, "MacOs", "золотистый", 13.3);
        Laptop laptop4 = new Laptop("HP 250 G7", 4, 1024, "без ОС", "черный", 15.6);
        Laptop laptop5 = new Laptop("Xiomi RedmiBook 15", 8, 256, "Windows 11", "серый", 15.6);
        Laptop laptop6 = laptop1;

        int ramUser=0;
        int storUser=0;
        double digUser=0;

        Set<Laptop> unicLaptop = new HashSet<Laptop>();
        unicLaptop.add(laptop1);
        unicLaptop.add(laptop2);
        unicLaptop.add(laptop3);
        unicLaptop.add(laptop4);
        unicLaptop.add(laptop5);
        unicLaptop.add(laptop6);
        System.out.println(laptop1.equals(laptop6));
        System.out.printf("Всего уникалных ноутбуков: %d \n", unicLaptop.size());
  
        System.out.println("Добро пожаловать в каталог ноутбуков!  \n Введите желаемое действие  1 - Печать всех товаров 2 - Поиск по каталогу 0 - Выход ");
        int pointUser = sc.nextInt();
        
        Map<Integer, String> mapCrit = new HashMap<>();
        mapCrit.put(1, "объем оперативной памяти");
        mapCrit.put(2, "объем накопителя");
        mapCrit.put(3, "ОС");
        mapCrit.put(4, "цвет");
        mapCrit.put(5, "диагональ");

        switch (pointUser) {
            case 1:
            for(Laptop lap: unicLaptop) 
            {
                if ((lap.getRam() >= ramUser) && (lap.getStorageCap() >= storUser)  && lap.getDiagonal() >= digUser) {
                    System.out.println(lap.toString());
                }
            }
                break;
            case 2:
                sortLaptop(ramUser, storUser, digUser, unicLaptop);
                break;
            case 3:
                System.exit(0);
            default:
                break;
        }



    }

}
