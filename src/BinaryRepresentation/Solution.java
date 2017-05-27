package BinaryRepresentation;

import java.util.HashSet;

public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here

        if(n == null || n.length() == 0)
            return "ERROR";

        int mark = 0;

        while(mark < n.length() && n.charAt(mark) != '.')
            mark++;

        String intPart = n.substring(0, mark);
        String fracPart = "";

        StringBuilder intRes = new StringBuilder();
        StringBuilder fracRes = new StringBuilder();

        if(mark < n.length())
            fracPart = n.substring(mark + 1);

        if(intPart.length() == 0)
            return "ERROR";
        if(intPart.length() > 1 && intPart.charAt(0) == '0')
            return "ERROR";

        int integer = Integer.parseInt(intPart);
        while(integer > 0){
            if((integer & 1) == 1)
                intRes.insert(0, 1);
            else
                intRes.insert(0, 0);
            integer = integer >> 1;
        }

        if(intRes.length() == 0)
            intRes.append(0);

        if(fracPart.length() == 0)
            return intRes.toString();

        HashSet<Double> set = new HashSet<Double>();
        Double fraction = Double.parseDouble("0." + fracPart);

        while(fracRes.length() <= 32 && fraction > 0){
            if(set.contains(fraction))
                return "ERROR";
            set.add(fraction);

            fraction = fraction * 2;

            if(fraction >= 1.0){
                fracRes.append(1);
                fraction -= 1.0;
            }
            else
                fracRes.append(0);
        }

        if(fracRes.length() > 32)
            return "ERROR";

        if(fracRes.length() == 0)
            return intRes.toString();

        return intRes.toString() + "." + fracRes.toString();
    }
}
