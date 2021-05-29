public class App {
    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(8);
        list.insert(9);
        list.deleteAt(2);
        list.insertAtTop(78);
        list.insertAt(0, 55);
        list.show();
    }
}
