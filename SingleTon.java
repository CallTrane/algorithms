import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @className: SingleTon
 * @description: TODO
 * @author: trane
 * @date: 2021/8/4 19:59
 */

@Slf4j
public class SingleTon {

    private static int i = 0;

    private final static AtomicReference<SingleTon> atomicReference = new AtomicReference();

    private SingleTon() {
        i++;
    }

    public static SingleTon getInstance() {
        while (true) {
            SingleTon RESULT = atomicReference.get();
            if (RESULT != null) {
                return RESULT;
            }
            RESULT = new SingleTon();
            if (atomicReference.compareAndSet(null, RESULT)) {
                return RESULT;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                getInstance();
                System.out.println(SingleTon.i);
            }, String.valueOf(i)).start();
        }
    }
}
