package ua.testing;


import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        try {
            System.out.println("Throw exception");
            System.err.println("Throw exception");
            main.throwingException();

            if (5 / 4 == 8) {
                throw new IOException();
            } else {
                throw null;
            }

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            System.err.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
            System.err.println("IOException");
        } catch (Exception e) {
            System.out.println("Exception");
            System.err.println("Exception");
        }finally {
            System.out.println("Finally");
            System.err.println("Finally");
        }

    }

    public void throwingException() throws IOException {
        throw new IOException();
    }

}

class Sub extends Main{

    @Override
    // throwing checked Exception forbidden because of the parent class, but unchecked RuntimeException allowed
    public void throwingException() throws IOException, RuntimeException {
        throw new FileNotFoundException();
    }

}

class SubSub extends Sub{

    @Override
    public void throwingException() throws FileNotFoundException {

    }

}