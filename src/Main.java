public class Main {
    public static void main(String[] args) {
        System.out.println("chains:\n");
        HashTable table = new HashTableWithChains();
        fillTable(table);
        table.show();

        System.out.println("\n\n\nopen address:\n");
        table = new HashTableWithOpenAddressing(100);
        fillTable(table);
        table.show();
    }

    private static void fillTable(HashTable table){
        for (int i = 0; i < 100; i++) {
            int a = (int) (Math.random() * 1000);
            table.add(Integer.toString(a));
        }
    }
}
