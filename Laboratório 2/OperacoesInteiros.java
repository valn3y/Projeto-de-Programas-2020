import java.util.ArrayList;
import java.util.Scanner;

class OperacoesInteiros {
    public static void main(String[] args) {
        OperacoesInteiros oi = new OperacoesInteiros();
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int value = 0;
        String status = "continue";

        while (status == "continue") {
            int in = scan.nextInt();
            if (in != -1) {
                list.add(in);
            } else {
                oi.operation(list);
                list.clear();

                if (in == value) {
                    status = "stop";
                }
            }
            value = in;
        }
        scan.close();
    }

    public void operation(ArrayList<Integer> list) {
        if (list.size() != 0) {
            System.out.println(list.size());
            pairOrOdd(list);
            System.out.println(sum(list));
            System.out.printf("%.2f\n", media(list));
            maxAndMin(list);
        }
    }

    public Integer sum(ArrayList<Integer> list) {
        Integer result = 0;
        for (int i = 0; i < list.size(); i++) {
            result = result + list.get(i);
        }
        return result;
    }

    public void pairOrOdd(ArrayList<Integer> list) {
        Integer pair = 0;
        Integer odd = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                pair = pair + 1;
            } else {
                odd = odd + 1;
            }
        }
        System.out.println(pair);
        System.out.println(odd);
    }

    public Double media(ArrayList<Integer> list) {
        Integer s = sum(list);
        Integer c = list.size();
        return s.doubleValue() / c.doubleValue();
    }

    public void maxAndMin(ArrayList<Integer> list) {
        Integer max = list.get(0);
        Integer min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            Integer value = list.get(i);
            if (value < min) {
                min = value;
            } else if (value > max) {
                max = value;
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
}
