import java.util.Stack;

public abstract class calc extends operations{
   

    public  double evaluate(String expression) {
        Stack<Double> numberStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        
        int token = 0;
        int token_a = 0;
        int token_sqrt = 0;
        final double  euler = Math.E;
        final double PI = Math.PI;
       

        for (int i = 0; i < expression.length(); i++) {
         
            char c = expression.charAt(i);
           
            if(i  < expression.length()-1){
                char x = expression.charAt(i+1);
                
                if((isOperator(c)&& isOperator(x))|| (isOperator(c) && i == 0)){
                    throw new IllegalArgumentException("Syntax Error");
                }
            }
           
           
            if (c == 's' && i + 2 < expression.length() && expression.substring(i, i + 6).equals("sin^-1")) {
                i += 6; // Skip "asin"
                
                System.out.println(6666);
                int startIndex = expression.indexOf("(", i);
                int endIndex = expression.indexOf(")", startIndex + 1);
                if (startIndex < 0 || endIndex < 0) {
                    throw new IllegalArgumentException("Missing parentheses for asin argument");
                }

                String argument = expression.substring(startIndex + 1, endIndex);
                double argumentValue = Double.parseDouble(argument); // Recursively evaluate the argument
                double result = Math.asin(argumentValue);
               
                
                numberStack.push(result);
               
         
                
            }
           else if (c == 'c' && i + 2 < expression.length() && expression.substring(i, i + 6).equals("cos^-1")) {
                i += 6; // Skip "acos"
                token_a = 1;
                
                int startIndex = expression.indexOf("(", i);
                int endIndex = expression.indexOf(")", startIndex + 1);
                if (startIndex < 0 || endIndex < 0) {
                    throw new IllegalArgumentException("Missing parentheses for acos argument");
                }

                String argument = expression.substring(startIndex + 1, endIndex);
                double argumentValue = Double.parseDouble(argument); // Recursively evaluate the argument
                double result = Math.acos(argumentValue);
               
                
                numberStack.push(result);
               
             
                
            }
           else if (c == 't' && i + 2 < expression.length() && expression.substring(i, i + 6).equals("tan^-1")) {
                i += 6; // Skip "atan"
                token_a = 1;
                System.out.println(6666);
                int startIndex = expression.indexOf("(", i);
                int endIndex = expression.indexOf(")", startIndex + 1);
                if (startIndex < 0 || endIndex < 0) {
                    throw new IllegalArgumentException("Missing parentheses for atan argument");
                }

                String argument = expression.substring(startIndex + 1, endIndex);
                double argumentValue = Double.parseDouble(argument); // Recursively evaluate the argument
                double result = Math.atan(argumentValue);
               
                
                numberStack.push(result);
               
                
            }


             else if (c == 's' && i + 2 < expression.length() && expression.substring(i, i + 3).equals("sin")) {
                i += 2 ; // Skip "sin"
                token = 1;
                int startIndex = expression.indexOf("(", i);
                int endIndex = expression.indexOf(")", startIndex + 1);
                if (startIndex < 0 || endIndex < 0) {
                    throw new IllegalArgumentException("Missing parentheses for sin argument");
                }

                String argument = expression.substring(startIndex + 1, endIndex);
                double argumentValue = evaluate(argument); // Recursively evaluate the argument
                double result = Math.sin(argumentValue);
                
                numberStack.push(result);
               
                
                
            }
            if (c == 'c' && i + 2 < expression.length() && expression.substring(i, i + 3).equals("cos")) {
                i += 2 ; // Skip "sin"
                token = 1;
               
                int startIndex = expression.indexOf("(", i);
                int endIndex = expression.indexOf(")", startIndex + 1);
                if (startIndex < 0 || endIndex < 0) {
                    throw new IllegalArgumentException("Missing parentheses for cos argument");
                }

                String argument = expression.substring(startIndex + 1, endIndex);
                double argumentValue = evaluate(argument); // Recursively evaluate the argument
                double result = Math.cos(argumentValue);
                
                numberStack.push(result);
               
               
              
                
            }
           else if (c == 't' && i + 2 < expression.length() && expression.substring(i, i + 3).equals("tan")) {
                i += 2 ; // Skip "tan"
                token = 0;
                int startIndex = expression.indexOf("(", i);
                int endIndex = expression.indexOf(")", startIndex + 1);
                if (startIndex < 0 || endIndex < 0) {
                    throw new IllegalArgumentException("Missing parentheses for cos argument");
                }

                String argument = expression.substring(startIndex + 1, endIndex);
                double argumentValue = evaluate(argument); // Recursively evaluate the argument
                double result = Math.tan(argumentValue);
                
                numberStack.push(result);
               
              
                
            }
            else if (c == 'l' && i + 2 < expression.length() && expression.substring(i, i + 3).equals("log")) {
                i += 2 ; // Skip "log"
                token = 1;
                int startIndex = expression.indexOf("(", i);
                int endIndex = expression.indexOf(")", startIndex + 1);
                if (startIndex < 0 || endIndex < 0) {
                    throw new IllegalArgumentException("Missing parentheses for log argument");
                }
                System.out.println("fnfjnfj");
                String argument = expression.substring(startIndex + 1, endIndex);
                double argumentValue = evaluate(argument); // Recursively evaluate the argument
                double result = Math.log10(argumentValue);
                System.out.println(result);
                numberStack.push(result);
               
              
                
            }
        
            
           

           else if (Character.isDigit(c) || c == '.' || c == '-') {
                StringBuilder sb = new StringBuilder();
                
                while (i < expression.length() &&(Character.isDigit(expression.charAt(i))|| expression.charAt(i)== '.' || expression.charAt(i)== '-')){

                
                    sb.append(expression.charAt(i++));
                    System.out.println(sb);
                   

                
                }
               
                i--; // Decrement i to account for the extra increment in the loop
                numberStack.push(Double.parseDouble(sb.toString()));
                System.out.println(numberStack);
            } 
            else if (c == '^' ) {
                System.out.println(expression.substring(i,i+2));
                if(expression.substring(i,i+2).equals("^-")){
                    
                    System.out.println(expression.substring(i+1,i+3));
                    String argument = expression.substring(i+1,i+3);
                    i+=4;
                    double argumentValue = Double.parseDouble(argument);
                    double result = Math.pow(numberStack.pop(), argumentValue);
                  
                    numberStack.push(result);
                  
                }else{   operatorStack.push(c);}
             
            } else if (c == '(') {
             operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    double operand2 = numberStack.pop();
                    double operand1 = numberStack.pop();
                    char operator = operatorStack.pop();
                    double result = performOperation(operand1, operand2, operator);
                    numberStack.push(result);   
                   
                }
                // Remove the '(' from the stack
                operatorStack.pop();

            } else if(c=='\u221A'){
                token_sqrt = 1;
                
                StringBuilder sb = new StringBuilder();
                int j = i +1;
                try {
                    while (i < expression.length() && expression.charAt(j) != ')'&& (Character.isDigit(expression.charAt(i+1)))){
                        
                        sb.append(expression.charAt(j++));
                        System.out.println(sb);
    
                    
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
                
               
                j--; // Decrement i to account for the extra increment in the loop
                numberStack.push(Double.parseDouble(sb.toString()));

                numberStack.push(Math.sqrt(numberStack.pop()));
            }else if(c== '!'){
               
                double result = 1;
                double end = numberStack.pop();
                for (int j = 1; j<= end; j++) {
                    result = result * j;
                   
               
            }
            System.out.println(result);
            numberStack.push(result);}
            else if(c== 'e'){
               
            numberStack.push(euler);
           
               
            }
            else if(c== '\u03c0'){
               
                numberStack.push(PI);
             
                   
                }
            
            else if (isOperator(c)) {
                while (!operatorStack.isEmpty() && hasHigherPrecedence(operatorStack.peek(), c)) {
                    double operand2 = numberStack.pop();
                    double operand1 = numberStack.pop();
                       
                    
                   
                   
                    char operator = operatorStack.pop();
                    double result = performOperation(operand1, operand2, operator);
                    numberStack.push(result);
                 
                }
                operatorStack.push(c);
            } else{
                
            }
           
        }
        if(token_a ==1 && numberStack.size() >=2){
            numberStack.remove(1);
            
        }
       token_a = 0;
        // Process remaining operators after handling all characters
        while (!operatorStack.isEmpty()) {
            System.out.println(numberStack);
            if(token==1 && numberStack.size() >= 2){
                 
                numberStack.remove(1);
                
            }
           
            token = 0;
           
            if(numberStack.size()!= 1){
                double operand2 = numberStack.pop();
            double operand1 = numberStack.pop();
            char operator = operatorStack.pop();
            double result = performOperation(operand1, operand2, operator);
            numberStack.push(result);
            }else{
                operatorStack.pop();
            }
            
            
            
        }
        if(token_sqrt== 1){
                 
            int x = numberStack.indexOf(numberStack.getLast());
            numberStack.remove(x);

               
           }
          
           token = 0;
        
        System.out.println(numberStack);
       
        return numberStack.pop(); // Final result should be on the top of the stack
    }

    // ... other methods (isOperator, hasHigherPrecedence, performOperation, etc.) remain the same ...

    // ... (rest of the code remains the same)



    @Override

    public  boolean isOperator(char c) 
    {
        return c == '+' || c == '\u2013' || c == '*' || c == '/' || c == '^'|| c =='\u221A' || c == '%';
    }

    private  boolean hasHigherPrecedence(char op1, char op2) {
        if (op1 == '^') {
            return true;
        } else if(op1 == '/' || op2 == '/'){
            return true;
        }else if(op1 == '%'){
            return true;
        }
        else{
            return (op1 == '*' && op2 == '/') && (op2 == '+' || op2 == '\u2013');
        }
        
    }


@Override
public double performOperation(double operand1, double operand2, char operator) {
    switch (operator) {
        case '^':
        return Math.pow(operand1, operand2);
        case'\u221A':
        return Math.sqrt(operand2);
        case '%':
        return operand1 % operand2;
        case '+':
            return operand1 + operand2;
        case '\u2013':
            return operand1 - operand2;
        case '*':
            return operand1 * operand2;
        case '/':
            return operand1 / operand2;
       
        
        default:
        return 0;
           // Should never ha  return 0;ppen
    }
}


   
}
