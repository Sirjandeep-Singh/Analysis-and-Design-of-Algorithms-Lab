package LAB1;

import java.util.*;

public class StringPerm {
    public static void permutationGenerator(StringBuilder currentString, int idx){
        int size = currentString.length();
        if(idx ==  size - 1){
            System.out.println(currentString);
            return;
        }
        for(int i = idx ; i < size ; i++){
            swapChars(currentString, idx, i);
            permutationGenerator(currentString, idx + 1);
            swapChars(currentString, idx, i);
        }
    }

    private static void swapChars(StringBuilder currentString, int idx, int target){
        char tempIdxChar = currentString.charAt(idx);
        currentString.setCharAt(idx, currentString.charAt(target));
        currentString.setCharAt(target, tempIdxChar);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String target = input.nextLine();
        target = target.trim();
        StringBuilder targetString = new StringBuilder(target);
        permutationGenerator(targetString, 0);
    }

}
