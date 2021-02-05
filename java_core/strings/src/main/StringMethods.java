package main;

import java.io.UnsupportedEncodingException;

//This class shows all string methods with examples
public class StringMethods {
    public static void main(String[] args) {
        String hello = "Hello World";
        System.out.println("String Example: " + hello);

        //1. char charAt(int index)
        System.out.println("charAt of the 7 index: " + hello.charAt(7));

        //2. int compareTo(Object o)
        System.out.println("compareTo object: " + hello.compareTo("Hello World"));

        //4. int compareToIgnoreCase(String str)
        System.out.println("compareToIgnoreCase : " + hello.compareToIgnoreCase("HELLO world"));

        //5.String concat(String s)
        System.out.println("concat: " + hello.concat(" and Java"));

        //6. boolean contentEquals(StringBuffer sb)
        System.out.println("contentEquals: " + hello.contentEquals(new StringBuffer("Hello")));// - false

        //7. static String copyValueOf(char[] data)
        char copyValueOf[] = {'H', 'i', ' ', 'w', 'o', 'r', 'l', 'd'};
        System.out.println("copyValueOf: " + String.copyValueOf(copyValueOf));

        //8. static String copyValueOf(char[] data, int offset, int count)
        System.out.println("copyValueOf: " + String.copyValueOf(copyValueOf, 3, 4));

        //9. boolean endsWith(String suffix)
        System.out.println("endsWith: " + hello.endsWith("end"));// - false

        //10. boolean equals(Object anObject)
        System.out.println("equals: " + hello.equals(new String("Hello World")));// - true
        System.out.println("==: " + (hello == new String("Hello World")));// - false

        //11. boolean equalsIgnoreCase(String anotherString)
        System.out.println("equalsIgnoreCase: " + hello.equalsIgnoreCase(new String("Hello WORLD")));// - true

        //12. byte[] getBytes()
        System.out.println("getBytes: " + hello.getBytes());

        //13. byte[] getBytes(String charsetName) throws UnsupportedEncodingException
        try {
            System.out.println("getBytes: " + hello.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported character set");
        }

        //14. void getChars(int srcBegin, int srcEnd, char[] dst,  int dstBegin)
        char getChars[] = new char[4];
        hello.getChars(0, 4, getChars, 0);
        System.out.print("getChars: ");
        System.out.println(getChars);

        //15. int hashCode()
        System.out.println("hashCode: " + hello.hashCode());

        //16. int indexOf(char ch)
        System.out.println("indexOf: " + hello.indexOf('l'));

        //17. int indexOf(char ch, int fromIndex)
        System.out.println("indexOf: " + hello.indexOf('o', 7));

        //18. int indexOf(String str)
        System.out.println("indexOf: " + hello.indexOf("Hello"));

        //19. int indexOf(String str, int fromIndex)
        System.out.println("indexOf: " + hello.indexOf("World", 3));

        //20. String intern()
        String s1 = new String("Hello Java").intern();
        String s2 = new String("Hello Java").intern();
        System.out.println("intern with ==: " + (s1 == s2));// - true

        //21. int lastIndexOf(int ch)
        System.out.println("lastIndexOf: " + hello.lastIndexOf('o'));

        //22. int lastIndexOf(int ch, int fromIndex)
        System.out.println("lastIndexOf: " + hello.lastIndexOf('o', 6));

        //23. int lastIndexOf(String str)
        System.out.println("lastIndexOf: " + hello.lastIndexOf("Hello"));

        //24. int lastIndexOf(String str, int fromIndex)
        System.out.println("lastIndexOf: " + hello.lastIndexOf("World", 5));

        //25. int length()
        System.out.println("length: " + hello.length());

        //26. boolean matches(String regex)
        System.out.println("matches: " + hello.matches("Hello(.*)"));

        //27. boolean regionMatches(boolean ignoreCase, int toffset, String other,
        //int ooffset, int len)
        System.out.println("regionMatches: " + hello.regionMatches(true, 0, "hello", 0, 5));

        //28. boolean regionMatches(int toffset, String other,
        //int ooffset, int len) - with no Ignore cases

        //29. String replace(char oldChar, char newChar)
        System.out.println("replace: " + hello.replace('o', 't'));

        //30. String replaceAll(String regex, String replacement)
        System.out.println("replaceAll: " + hello.replaceAll("World(.*)", "Java"));

        //31. String replaceFirst(String regex, String replacement)
        System.out.println("replaceFirst: " + hello.replaceFirst("(.*)Hello", "Hi"));

        //32. String[] split(String regex)
        for (String str : hello.split(" ")) {
            System.out.println("split whitespace, word: " + str);
        }

        //33. String[] split(String regex, int limit) - with limit for return value

        //34 boolean startsWith(String prefix)
        System.out.println("startsWith: " + hello.startsWith("Hel"));

        //35. boolean startsWith(String prefix, int toffset)

        //36. CharSequence subSequence(int beginIndex, int endIndex)
        System.out.println("subSequence: " + hello.subSequence(0, 5));

        //37 String substring(int beginIndex)
        System.out.println("substring: " + hello.substring(5));

        //38. String substring(int beginIndex, int endIndex)

        //39. char[] toCharArray()

        //40. String toLowerCase()
        System.out.println("toLowerCase: " + hello.toLowerCase());

        //41. String toLowerCase(Locale locale)

        //42. String toString()

        //43.String toUpperCase()
        System.out.println("toUpperCase: " + hello.toUpperCase());

        //44 String toUpperCase(Locale locale)

        //45. String trim()
        System.out.println("trim: " + "   Hello world   ".trim());

        //46. static String valueOf(Primitive data types)
        System.out.println("valueOf, int: " + String.valueOf(127349));

        //47. static String format(String format, Object... args)
        System.out.println("format: " + String.format("The first string: %s,\nthe second: %s,",
                hello, "Hello java"));

        //48. static String join(CharSequence delimiter, CharSequence... elements)
        System.out.println("join: " + String.join("/", "05", "12", "2020"));
    }
}
