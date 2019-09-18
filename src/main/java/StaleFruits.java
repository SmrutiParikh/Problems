//        mxn matrix with 0, 1, 2 values.
//        0 -> no fruit
//        1 -> fresh fruit
//        2 -> stale fruit
//
//        stale fruit rots near by fresh fruit in 1 day
//
//        0 1 1 2 2
//        2 0 0 1 2
//        1 0 0 0 2

import sun.misc.Queue;

import java.io.*;

class StaleFruits {

    static class Node {
        Integer rowIndex;
        Integer colIndex;
        Integer day;

        //constructor
        Node(Integer rowIndex, Integer colIndex, Integer day) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
            this.day = day;
        }

        //getter setter
        public Integer getRowIndex() {
            return rowIndex;
        }

        public void setRowIndex(Integer rowIndex) {
            this.rowIndex = rowIndex;
        }

        public Integer getColIndex() {
            return colIndex;
        }

        public void setColIndex(Integer colIndex) {
            this.colIndex = colIndex;
        }

        public Integer getDay() {
            return day;
        }

        public void setDay(Integer day) {
            this.day = day;
        }
    }

    static void run(){
        String inputFilePath = "src/main/resources/fruitsArray.txt";
        try {
            int[][] array = readFileAndPrepareArray(inputFilePath);
            int maxDays = findMaxDays(array);
            System.out.println("Max days for stale : " + maxDays);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int[][] readFileAndPrepareArray(String inputFile) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(inputFile)));
        String rows = bufferedReader.readLine();
        String cols = bufferedReader.readLine();
        int m = Integer.parseInt(rows);
        int n = Integer.parseInt(cols);
        int[][] array = new int[m][n];

        for(int i = 0;  i < m ; i++){
            String line = bufferedReader.readLine();
            String[] elements = line.split(" ");
            if(elements.length != n){
                throw new Exception("Array dimensions do not match");
            }
            for(int j = 0; j< n ; j++){
                array[i][j] = Integer.parseInt(elements[j]);
            }
        }

        return array;
    }

    private static int findMaxDays(int[][] array) {
        Queue<Node> stales = new Queue<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int current = array[i][j];
                if (current == 2) {
                    stales.enqueue(new Node(i, j, 0));
                }
            }
        }

        int maxDays = 0;

        while (!stales.isEmpty()) {
            int level = checkStales(stales, array);
            if (level > maxDays) {
                maxDays = level;
            }
        }
        return maxDays;
    }

    private static int checkStales(Queue<Node> queue, int[][] arr) {
        try {
            Node current = queue.dequeue();
            int level = current.getDay();
            int i = current.getRowIndex();
            int j = current.getColIndex();

            addPossibleStales(i - 1, j, level, arr, queue);
            addPossibleStales(i, j - 1, level, arr, queue);
            addPossibleStales(i + 1, j, level, arr, queue);
            addPossibleStales(i, j + 1, level, arr, queue);

            return level;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static void addPossibleStales(int x, int y, int level, int[][] arr, Queue<Node> queue) {
        int row = arr.length;
        int col = arr[0].length;
        if (existsIndex(x, y, row, col) && arr[x][y] == 1) {
            queue.enqueue(new Node(x, y, level + 1));
            arr[x][y] = 2;
        }
    }

    private static boolean existsIndex(int i, int j, int rows, int cols) {
        return i >= 0 && j >= 0 && i < rows && j < cols;
    }
}
