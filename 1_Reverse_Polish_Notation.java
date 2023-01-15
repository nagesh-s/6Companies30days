class test {
    int stack[], top;

    test(int length) {
        stack = new int[length];
        top = -1;
    }

    void push(int num) {
        stack[++top] = num;
    }

    int pop() {
        return stack[top--];
    }
}

public class Solution {

    public int evalRPN(String[] tokens) {

        test obj = new test(tokens.length);
        int n1, n2, n3 = 0;
        int i = 0;
        while (i < tokens.length) {
            if (tokens[i].matches("-?[0-9]+")) {
                obj.push(Integer.parseInt(tokens[i]));
            }

            else {
                n1 = obj.pop();
                n2 = obj.pop();

                switch (tokens[i]) {

                    case "+":
                        n3 = n2 + n1;
                        break;

                    case "-":
                        n3 = n2 - n1;
                        break;

                    case "*":
                        n3 = n2 * n1;
                        break;

                    case "/":
                        n3 = n2 / n1;
                        break;
                }
                obj.push(n3);
            }
            i++;
        }

        return obj.pop();
    }

}
