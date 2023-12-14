import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Hamburger {


    int count;

    public int solution(int[] ingredient) {

        if (ingredient.length < 4) {

            return count;
        }

        if (ingredient.length == 4) {

            if (ingredient[0] != 1 || ingredient[1] != 2 || ingredient[2] != 3 || ingredient[3] != 1) {

                return 0;
            }

            if (ingredient[0] == 1 && ingredient[1] == 2 && ingredient[2] == 3 && ingredient[3] == 1) {

                return 1;
            }
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ingredient.length; i++) {

            stack.add(ingredient[i]);

            if(stack.size()<4) {
                continue;
            }

            if (stack.elementAt(stack.size() - 1) == 1 && stack.elementAt(stack.size() - 2) == 3
                    && stack.elementAt(stack.size() - 3) == 2 && stack.elementAt(stack.size() - 4) == 1) {
                count++;
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();

            }
        }

        return count;
    }

}
