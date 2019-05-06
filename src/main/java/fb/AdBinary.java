package fb;

public class AdBinary {

    public String addBinary(String a, String b) {

        int x,y;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = a.length() - 1,j = b.length() - 1; i >= 0 || j >= 0; i--, j--){
            if (i < 0) x = 0; else x = Character.getNumericValue(a.charAt(i));
            if (j < 0) y = 0; else y = Character.getNumericValue(b.charAt(j));

            int val = (x + y + carry) % 2;
            stringBuilder.append(val);
            carry = (x + y + carry) / 2;

        }

        if (carry != 0) stringBuilder.append(carry);
        return stringBuilder.reverse().toString();

    }


    public static void main(String[] args) {

        AdBinary adBinary = new AdBinary();

        adBinary.addBinary("100","01000");
    }
}
