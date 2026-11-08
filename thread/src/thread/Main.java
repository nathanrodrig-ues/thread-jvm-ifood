package thread;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        String search = "Bruno";

        System.out.println("Search: " + search);

        long startTime = System.currentTimeMillis();

        String[] files = {
            "arquivos/signatarios-fev-2023.txt",
            "arquivos/signatarios-dez-2024.txt",
            "arquivos/signatarios-out-2025.txt"
        };

        // Uma Thread para cada arquivo
        Thread[] threads = new Thread[files.length];

        for (int i = 0; i < threads.length; i++) {
            SearchNameRunnable searchRunnable = new SearchNameRunnable(files[i], search);
            threads[i] = new Thread(searchRunnable);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long endTime = System.currentTimeMillis();

        System.out.println(
            "Search Completed!"
            + "/Time: " + (endTime - startTime) + "ms"
        );
    }
}