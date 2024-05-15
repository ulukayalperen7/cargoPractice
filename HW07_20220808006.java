public class HW07_20220808006 {

}

interface Common<T> {
    public boolean isEmpty();

    public T peek();

    public int size();
}

interface Node<T> {
    public static final int DEFAULT_CAPACITY = 2;

    public T getNext();

    public double getPriority();

    public void setNext(T item);
}

interface Package<T> {
    public T extract();

    public double getPriority();

    public boolean isEmpty();

    public boolean pack(T item);
}

interface PriorityQueue<T> extends Common<T> {
    public static final int FLEET_CAPACITY = 3;

    public T dequeue();

    public boolean enqueue(T item);
}

interface Sellable {
    public String getName();

    public double getPrice();
}

interface Stack<T> extends Common<T> {
    public T pop();

    public boolean push(T item);
}

interface Wrappable extends Sellable {

}

class Box<T extends Sellable> implements Package<T> {
    private int distanceToAddress;
    private T item;
    private boolean seal;

    public Box() {
        item = null;
        seal = false;
        distanceToAddress = 0;
    }

    public Box(T item, int distanceToAddress) {
        this.item = item;
        this.distanceToAddress = distanceToAddress;
        this.seal = true; // box is sealed __ paketlendi gibi düşün
    }

    public T extract() { // extract item and return it
        if (this.seal == true && this.item != null) { // f-f t-f?
            T outItem = this.item;
            this.item = null;
            this.seal = false;
            return outItem;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        if (this.item == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pack(T item) {
        if (this.item == null) {
            this.item = item;
            this.seal = true;
            return true;
        } else {
            return false;
        }

    }

    public boolean isSealBroken() {
        if (seal == false) {
            return true;
        } else {
            return false;
        }
    }

    public double getPriority() {
        double priority = item.getPrice() / distanceToAddress;
        return priority;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            if (isSealBroken()) {
                String s1 = "box status: There is nothing in the box \n seal status: The seal is broken ";
                return s1;
            } else {
                String s2 = "box status: There is nothing in the box \n seal status: The seal is not broken ";
                return s2;
            }
        } else {
            if (isSealBroken()) {
                String s3 = this.item.toString() + "\nseal status: The seal is broken ";
                return s3;
            } else {
                String s4 = this.item.toString() + "\nseal status: The seal is not broken ";
                return s4;
            }
        }
    }
}

class CargoCompany {
    private CargoFleet queue;
    private Container stack;

    public CargoCompany() {
        stack = new Container();
        queue = new CargoFleet();
    }

    private void ship(CargoFleet fleet) {
        Container container;
        do {
            container = fleet.dequeue();
            if (container != null) {
                empty(container);
            }
        } while (container != null);
    }

    public <T extends Box<?>> void add(T box) {
        boolean addToStack = stack.push(box);
        boolean enqueued = false;

        if (!addToStack) {
            enqueued = queue.enqueue(stack);
        }
        if (!addToStack && !enqueued) {
            ship(queue);
        }
    }

    private void empty(Container container) {
        Box<?> boxToadd;
        while ((boxToadd = container.pop()) != null) {
            deliver(boxToadd);
        }
    }

    private <T extends Box<?>> Sellable deliver(T box) {
        return box.extract();
    }
}

class CargoFleet implements PriorityQueue<Container> {

    private Container head;
    private int size;

    public CargoFleet() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Container peek() {
        return head;
    }

    @Override
    public Container dequeue() {
        if (size == 0) {
            return null;
        } else {
            Container removing = head;
            head = head.getNext();
            this.size--;
            return removing;
        }
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean enqueue(Container item) {
        if (head == null && head.compareTo(item) < 0) {
            item.setNext(head);
            head = item;
        } else {
            head.setNext(item);
        }
        size += 1;
        return true;
    }

}

class Container implements Node<Container>, Comparable<Container>,
        Stack<Box<?>> {

    private Box<?>[] boxes;
    private Container next;
    private double priority;
    private int size;
    private int top;

    public Container() {
        this.boxes = new Box<?>[2];
    }

    @Override
    public String toString() {
        return "container : priority = " + getPriority();
    }

    @Override
    public Box<?> pop() {
        if (size == 0) {
            return null;
        }
        if (isEmpty())
            return null;

        Box<?> extracted = boxes[top];
        boxes[top--] = null;
        size--;
        priority -= extracted.getPriority();

        return extracted;
    }

    @Override
    public int compareTo(Container o) {
        return Double.compare(this.priority, o.getPriority());
    }

    @Override
    public Container getNext() {
        return next;
    }

    @Override
    public void setNext(Container item) {
        this.next = item;
    }

    @Override
    public double getPriority() {
        return priority;
    }

    public Box<?> peek() {
        return boxes[top];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean push(Box<?> item) {
        if (size == 2) {
            return false;
        } else {
            boxes[size] = item;
            size++;
            top = size - 1;
            priority += item.getPriority();

            return true;
        }

    }
}

class Matroschka<T extends Wrappable> extends Product
        implements Wrappable, Package<T> {

    private T item;

    public Matroschka(T item) { // tek satır ifelse: kullan? if else olmıyor?
        super("Doll", (item == null) ? 5
                : 5 +
                        item.getPrice());
        this.item = item;
    }

    @Override
    public T extract() {
        T newItem = item;
        item = null;
        return newItem;
    }

    @Override
    public boolean isEmpty() {
        if (item == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "{" + item + "}";
    }

    @Override
    public boolean pack(T item) {
        if (isEmpty()) {
            this.item = item;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getPriority() {
        throw new UnsupportedOperationException();
    }
}

class Mirror extends Product {

    private int height;
    private int width;

    public Mirror(int width, int height) {
        super("mirror", 2);
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return height * width;
    }

    @Override
    public double getPrice() {
        return getArea() * super.getPrice();
    }

    public <T> T reflect(T item) {
        System.out.println(item);
        return item;
    }

}

class Paper extends Product implements Wrappable {
    private String note;

    public Paper() {
        super("Paper", 0.5);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String getName() {
        return "paper";
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

abstract class Product implements Sellable {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "name: " + getName() + " price: " + getPrice();
    }
}
