class Solution {
    public int evalRPN(String[] tokens) {
        final Set<String> operators = Set.of("+", "-", "*", "/");
        final Deque<Integer> operands = new ArrayDeque<>();

        for (final String token: tokens) {
            if(operators.contains(token)) {
                final int operand2 = operands.pop();
                final int operand1 = operands.pop();
                operands.push(apply(token, operand1, operand2));
            }
            else {
                operands.push(Integer.parseInt(token));
            }
        }
        
        return operands.pop();
    }

    private int apply(final String operator, final int operand1, final int operand2) {
        switch(operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
            default:
                return operand1 / operand2;
        }
    }
}
