
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

class Box<T extends Sellable> {

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
