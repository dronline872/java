package Lesson_2;

import java.io.FileWriter;
import java.io.IOException;

public class task_2 {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 2};
        String logFilePath = "log.txt";
        try {
            FileWriter logFileWriter = new FileWriter(logFilePath);
            bubbleSort(array, logFileWriter);
            logFileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bubbleSort(int[] array, FileWriter logFileWriter) throws IOException {
        int n = array.length;
        boolean sorted;
        for (int j : array) {
            logFileWriter.write(j + " ");
        }
        logFileWriter.write("\n");
        for (int i = 0; i < n - 1; i++) {
            sorted = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sorted = true;
                }
            }

            if (!sorted) {
                break;
            }
            
            for (int j : array) {
                logFileWriter.write(j + " ");
            }
            logFileWriter.write("\n");
            
        }
    }
}
