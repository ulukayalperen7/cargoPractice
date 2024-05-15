
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

interface PriorityQueue<T> {
    public static final int FLEET_CAPACITY = 3;

    public T dequeue();

    public boolean enqueue(T item);
}

interface Sellable {
    public String getName();

    public double getPrice();
}

interface Stack<T> {
    public T pop();

    public boolean push();
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

}

class CargoFleet implements PriorityQueue<Container> {

    @Override
    public Container dequeue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dequeue'");
    }

    @Override
    public boolean enqueue(Container item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enqueue'");
    }

}

class Container implements Node<Container>, Comparable<Container>, Stack<Box<?>> {

    @Override
    public Box<?> pop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pop'");
    }

    @Override
    public boolean push() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'push'");
    }

    @Override
    public int compareTo(Container o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    @Override
    public Container getNext() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNext'");
    }

    @Override
    public double getPriority() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPriority'");
    }

    @Override
    public void setNext(Container item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNext'");
    }

}

class Matroschka<T extends Wrappable> extends Product implements Wrappable, Package<T> {

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    public double getPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPrice'");
    }

    @Override
    public T extract() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extract'");
    }

    @Override
    public double getPriority() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPriority'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public boolean pack(T item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pack'");
    }

}

class Mirror extends Product {

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    public double getPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPrice'");
    }

}

class Paper extends Product implements Wrappable {

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    public double getPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPrice'");
    }

}

abstract class Product implements Sellable {

}
