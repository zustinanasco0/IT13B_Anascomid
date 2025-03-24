package MIDTERM;

public class TION_ANASCO_SINGLE_MULTIDIMENSIONAL_ARRAY {

    public static void main(String[] args) {

        char letters[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        for (char a = 0; a < letters.length; a++) {
            System.out.print(letters[a] + " ,");
            

        }
        System.out.println();
        System.out.println();
        int numbers[][] = {
            {1, 2, 3, 4,},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
//        System.out.println("The Elements of Row 1:" + " " + numbers [0][0] + " " + numbers [0][1]+ " " + numbers [0][2]+ " " + numbers [0][3]);
//           System.out.println("The Elements of Row 2:" + " " + numbers [1][0] + " " + numbers [1][1]+ " " + numbers [1][2]+ " " + numbers [1][3]);
//           System.out.println("The Elements of Row 3:" + " " + numbers [2][0] + " " + numbers [2][1]+ " " + numbers [2][2]+ " " + numbers [2][3]);
//        
//        
        
        
        for (int c = 0; c< numbers.length; c++){
            System.out.print("The Elements in Row " + (c + 1) + ": ");
            for (int z = 0; z< numbers[c].length; z++){
                System.out.print(numbers[c][z] + " ");
            }
            System.out.println();
        }

    }

}
