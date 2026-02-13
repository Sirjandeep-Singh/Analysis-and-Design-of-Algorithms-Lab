package LAB4;

import java.util.Scanner;

public class StringPermutations {
    public static void permutationGen(StringBuilder currentString, int idx){
        int size = currentString.length();

        if(idx ==  size - 1){
            System.out.println(currentString);
            return;
        }

        for(int i = idx ; i < size ; i++){
            swapChars(currentString, idx, i);
            permutationGen(currentString, idx + 1);
            swapChars(currentString, idx, i);
        }
    }

    private static void swapChars(StringBuilder newString, int idx, int target){
        char tempIdxChar = newString.charAt(idx);
        newString.setCharAt(idx, newString.charAt(target));
        newString.setCharAt(target, tempIdxChar);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String target = input.nextLine();
        target = target.trim();
        StringBuilder myString = new StringBuilder(target);
        permutationGen(myString, 0);
    }

}
