package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface{
    private String string;
    @Override
    public String getString() {
        return string;
    }

    @Override
    public void setString(String string) {
        this.string = string;
    }

    @Override
    public int countNumbers() {
        if (string == null) throw new NullPointerException();
        int count = 0;
        if (string == "") return 0;
        for (int i = 0; i < string.length(); i++) {
            if(Character.isDigit(string.charAt(i))) {
                while((i < string.length()) && (Character.isDigit(string.charAt(i)))) i++;
                count++;
            }
        }
        return count;
    }

    @Override
    public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
        if (n <= 0) throw new IllegalArgumentException();
        if (n > string.length()) return "";
        String result = "";
        if(startFromEnd == false) {
            for (int i = n-1; i < string.length(); i += n) {
                result += string.charAt(i);
            }
        }
        else {
            for (int i = string.length() - n; i >= 0; i -= n) {
                result = string.charAt(i) + result;
            }
        }
        return result;
    }

    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
        if (startPosition > endPosition) throw new IllegalArgumentException();
        else if (startPosition <= endPosition) {
            if ((startPosition < 1) || (endPosition > string.length())) {
                throw new MyIndexOutOfBoundsException();
            } else if ((startPosition > 0) && (endPosition > 0) && (string == null)) {
                throw new NullPointerException();
            }
        }
        String temp = "";
        String tempFront = "";
        String tempBack = "";
        for (int i = startPosition-1; i <= endPosition-1; i++) {
            temp += string.charAt(i);
        }
        for (int i = 0; i < startPosition-1; i++) {
            tempFront += string.charAt(i);
        }
        for (int i = endPosition; i < string.length(); i++) {
            tempBack += string.charAt(i);
        }
        for (int i = startPosition-1; i <= endPosition-1; i++) {
            temp = temp.replaceAll("0", "Zero");
            temp = temp.replaceAll("1", "One");
            temp = temp.replaceAll("2", "Two");
            temp = temp.replaceAll("3", "Three");
            temp = temp.replaceAll("4", "Four");
            temp = temp.replaceAll("5", "Five");
            temp = temp.replaceAll("6", "Six");
            temp = temp.replaceAll("7", "Seven");
            temp = temp.replaceAll("8", "Eight");
            temp = temp.replaceAll("9", "Nine");
        }
        string = tempFront + temp + tempBack;
    }
}
