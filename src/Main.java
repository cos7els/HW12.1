import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        CustomList<String> data = new CustomList<>();
        for (int i = 0; i < 10; i++) {
            data.add("Word" + random.nextInt(100));
        }
        System.out.println(data);
        data.remove(9);
        System.out.println(data);
        data.add("Word New");
        System.out.println(data);
        System.out.println(data.indexOf("Word New"));
        data.remove("Word New");
        System.out.println(data);
        data.set(2, "NEW WORD");
        System.out.println(data);
        data.add(3, "Again Word");
        System.out.println(data);
        System.out.println(data.contains("Again Word"));
        System.out.println(data.get(data.indexOf("NEW WORD")));
        System.out.println(data.isEmpty());
        data.clear();
        System.out.println(data);
        System.out.println(data.isEmpty());

    }

}
