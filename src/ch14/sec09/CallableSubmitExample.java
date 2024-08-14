package ch14.sec09;

import java.util.concurrent.*;

public class CallableSubmitExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 100; i++) {
            final int idx = i;

            Future<Integer> future = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;

                    for (int i = 1; i <= idx; i++) {
                        sum += i;
                    }

                    Thread thread = Thread.currentThread();
                    System.out.println("[" + thread.getName() + "] 1~" + idx + " 합 계산");
                    return sum;
                }
            });

            try {
                int result = future.get(); // call() 작업이 끝날 때 까지 기다렸다가 작업이 리턴한 값을 리턴한다
                System.out.println("\t 리턴값 = " + result);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
    }
}
