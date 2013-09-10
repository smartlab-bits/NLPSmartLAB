/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smartlab.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author ipc
 */
public class NLPSmartLAB {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String[] words1, words2;
    private String[] lightwords = {"light", "tubelight", "see", "bulb", "dark", "darker", "bright", "brighter", "darken", "brighten", "brightness", "darkness", "dim", "lit"};
    private String[] fanwords = {"fan", "hot", "hotter", "warm", "warmer", "cool", "cooler", "cold", "heat", "chill", "chilling", "chilled", "burning", "freezing", "increase", "decrease"};
    private String[] absolutenegatives = {"no", "not", "off", "make"};
    private String[] relativenegatives = {"no", "not", "on"};
    private String[] questionwords = {"why"};
    private String[] conjunctions = {"and", "but"};
    private boolean corLight = false, corFan = false;
    private boolean offwordLight = false, offwordFan = false;
    private int fanSent = 0, lightSent = 0;

    public void tokenizeString(String s) { // breaks the given sentence into words
        int i = 0;
        for (String st : conjunctions) {
            i = s.indexOf(st);
            if (i != -1) {
                words1 = s.substring(0, i).split(" ");
                words2 = s.substring(i).split(" ");
                break;
            }
        }
        if (i == -1 || (words2.length == 2)) {
            words1 = s.split(" ");
            words2 = "".split("");
        }
    }

    public void recognizeLight() { // gives output for light
        if (findLightWords()) {
            if (lightSent == 1) {
                if (countNegatives1() % 2 == 0) {
                    corLight = true;
                }
                if (offwordLight == false) {
                    if (corLight == true) {
                        System.out.println("ON");
                    } else {
                        System.out.println("OFF");
                    }
                } else {
                    if (corLight == true) {
                        System.out.println("OFF");
                    } else {
                        System.out.println("ON");
                    }
                }
            } else if (lightSent == 2) {
                if (countNegatives2() % 2 == 0) {
                    corLight = true;
                }
                if (offwordLight == false) {
                    if (corLight == true) {
                        System.out.println("ON");
                    } else {
                        System.out.println("OFF");
                    }
                } else {
                    if (corLight == true) {
                        System.out.println("OFF");
                    } else {
                        System.out.println("ON");
                    }
                }
            }
        }
        resetLight();
    }

    public void recognizeFan() { // gives output for fan
        if (findFanWords()) {
            if (fanSent == 1) {
                if (countNegatives1() % 2 == 0) {
                    corFan = true;
                }
                if (offwordFan == false) {
                    if (corFan == true) {
                        System.out.println("ON");
                    } else {
                        System.out.println("OFF");
                    }
                } else {
                    if (corFan == true) {
                        System.out.println("OFF");
                    } else {
                        System.out.println("ON");
                    }
                }
            } else if (fanSent == 2) {
                if (countNegatives2() % 2 == 0) {
                    corFan = true;
                }
                if (offwordFan == false) {
                    if (corFan == true) {
                        System.out.println("ON");
                    } else {
                        System.out.println("OFF");
                    }
                } else {
                    if (corFan == true) {
                        System.out.println("OFF");
                    } else {
                        System.out.println("ON");
                    }
                }
            }
        }
        resetFan();
    }

    private void resetLight() { // self-explanatory
        corLight = false;
        offwordLight = false;
    }

    private void resetFan() { // self-explanatory
        corFan = false;
        offwordFan = false;
    }

    private boolean isQuestion1() { // checks if 1st sentence is a question
        for (String s : questionwords) {


            for (String word : words1) {
                if (s.equalsIgnoreCase(word)) {
                    return true;
                }
            }

        }
        return false;
    }

    private boolean isQuestion2() { // checks if second sentence is a question
        for (String s : questionwords) {



            for (String word : words2) {
                if (s.equalsIgnoreCase(word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int countNegatives1() { // counts negative words in sentence 1
        int count = 0;
        String negativewords[];
        if (isQuestion1()) {
            negativewords = relativenegatives;
        } else {
            negativewords = absolutenegatives;
        }
        for (String s : negativewords) {


            for (String w : words1) {
                if (w.equalsIgnoreCase(s)) {
                    count++;
                }
            }


        }
        return count;
    }

    private int countNegatives2() { // counts negative words in sentence 2
        int count = 0;
        String negativewords[];
        if (isQuestion2()) {
            negativewords = relativenegatives;
        } else {
            negativewords = absolutenegatives;
        }
        for (String s : negativewords) {



            for (String w : words2) {
                if (w.equalsIgnoreCase(s)) {
                    count++;
                }
            }

        }
        return count;
    }

    private boolean findLightWords() { // finds if the sentence contains light-related words and changes offwordLight accordingly
        boolean flag = false;
        for (String light : lightwords) {

            for (String s : words1) {
                if (s.equalsIgnoreCase(light)) {
                    lightSent = 1;
                    flag = true;


                    if (words1[0].equalsIgnoreCase("dim") ||words1[0].equalsIgnoreCase("darken") || (!(s.equalsIgnoreCase(words1[0])) && (light.contains("bright") || light.equalsIgnoreCase("lit")))) {
                        offwordLight = true;
                    }
                    break;
                }
            }

            for (String s : words2) {
                if (s.equalsIgnoreCase(light)) {
                    lightSent = 2;
                    flag = true;


                    if (words2[1].equalsIgnoreCase("dim") ||words2[1].equalsIgnoreCase("darken") || (!(s.equalsIgnoreCase(words2[1])) && (light.contains("bright") || light.equalsIgnoreCase("lit")))) {
                        offwordLight = true;
                    }
                    break;
                }
            }
        }



        return flag;
    }

    private boolean findFanWords() { // finds if the sentence contains fan-related words and changes offwordFan accordingly
        boolean flag = false;
        for (String fan : fanwords) {

            for (String s : words1) {
                if (s.equalsIgnoreCase(fan)) {
                    fanSent = 1;
                    flag = true;


                    if (words1[0].equalsIgnoreCase("heat") || words1[0].equalsIgnoreCase("increase") || (!(s.equalsIgnoreCase(words1[0])) && (fan.contains("cool") || fan.contains("chill") || fan.equalsIgnoreCase("cold") || fan.equalsIgnoreCase("freezing")))) {
                        offwordFan = true;
                    }
                    break;
                }
            }

            for (String s : words2) {
                if (s.equalsIgnoreCase(fan)) {
                    fanSent = 2;
                    flag = true;


                    if (words2[1].equalsIgnoreCase("heat") || words2[1].equalsIgnoreCase("increase") || (!(s.equalsIgnoreCase(words2[1])) && (fan.contains("cool") || fan.contains("chill") || fan.equalsIgnoreCase("cold") || fan.equalsIgnoreCase("freezing")))) {
                        offwordFan = true;
                    }
                    break;
                }
            }
        }



        return flag;
    }

    public String getInp() throws IOException { // gets input from user (testing only)
        return br.readLine();
    }

    public static void main(String[] args) throws IOException {
        NLPSmartLAB obj = new NLPSmartLAB();


        while (true) {
            String get = obj.getInp();
            obj.tokenizeString(get);
            obj.recognizeLight();
            obj.recognizeFan();
        }
    }
}