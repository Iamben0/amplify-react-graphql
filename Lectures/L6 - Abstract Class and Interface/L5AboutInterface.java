public class L5AboutInterface {
    public static void main(String[] args) {
        L5Worker w = new L5WorkerClassA();
        w.doWork();
        w = new L5WorkerClassB();
        w.doWork();

        processWork(w);
        processWork(new L5WorkerClassA());
    }

    public static void processWork(L5Worker w) {
        w.doWork();
    }
}

interface L5Worker {
    public void doWork();
}

class L5WorkerClassA implements L5Worker {
    // Can include constructor(s), instance variables, methods ...
    @Override
    // have to override all the method that you implement from
    public void doWork() {
        System.out.println("WorkerClass A");
    }
}

class L5WorkerClassB implements L5Worker {
    // Can include constructor(s), instance variables, methods ...
    public void doWork() {
        System.out.println("WorkerClass B");
    }
}
