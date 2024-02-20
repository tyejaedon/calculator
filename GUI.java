import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class GUI extends calc implements ActionListener {
    double answer;
    int calculation;
    final Double pie = Math.PI;
    final Double euler = Math.E;

    
    JFrame frame;
    JTextField textField = new JTextField();
    JButton buttonZero = new JButton("0");
    JButton buttonOne = new JButton("1");
    JButton buttonTwo = new JButton("2");
    JButton buttonThree = new JButton("3");
    JButton buttonFour = new JButton("4");
    JButton buttonFive = new JButton("5");
    JButton  buttonSix = new JButton("6");
    JButton buttonSeven = new JButton("7");
    JButton buttonEight = new JButton("8");
    JButton buttonNine = new JButton("9");
    JButton buttonDot = new JButton(".");
    JButton buttonClear = new JButton("C");
    JButton buttonDelete = new JButton("DEL");
    JButton buttonEqual = new JButton("=");
    JButton buttonMul = new JButton("X");
    JButton buttonDiv = new JButton("/");
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("\u2013");
    JButton buttonSquare = new JButton("+/-");
    JButton buttonOPBrac = new JButton("(");
    JButton buttonCLBrac = new JButton(")");
    JButton buttonlog10 = new JButton("log()");
    JButton buttonReciprocal = new JButton("1/x");
    JButton buttonSqrt = new JButton("\u221A");
    JButton buttonSin = new JButton("sin");
    JButton buttonCos = new JButton("cos");
    JButton buttonTan = new JButton("tan");
    JButton buttonExponent = new JButton("e^");
    JButton buttonPie = new JButton("\u03c0");
    JButton buttonModulo = new JButton("%");
    JButton buttonCosinverse = new JButton("cos^-1");
    JButton buttonSininverse = new JButton("sin^-1");
    JButton buttonTaninverse = new JButton("tan^-1");
    JButton buttonPower = new JButton("x^y");   
    JButton buttonFactorial = new JButton("x!");

    Color black = new Color(32,32,32);
    Color grey = new Color(128,128,128);
    Color orange = new Color(255, 153,51);
    Color darkgrey = new Color(64,64,64);

    JButton[][] numbers = {{buttonSeven,buttonEight,buttonNine},
    {buttonFour,buttonFive,buttonSix},
    {buttonOne,buttonTwo,buttonThree},
    {buttonZero,buttonDot}};

    JButton[] basics = {buttonDiv,buttonMul,buttonMinus,buttonPlus,buttonEqual};

    JButton[][] operators = {{buttonPower,buttonSqrt,buttonSquare,buttonClear,buttonDelete,buttonModulo},
    {buttonSininverse,buttonReciprocal,buttonExponent},
    {buttonCosinverse,buttonPie,buttonCos},
    {buttonTaninverse,buttonSin,buttonTan},
    {buttonOPBrac,buttonCLBrac,buttonlog10,buttonFactorial}};

    
    public void prepareGUI() {
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setSize(580, 550);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(black);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void addComponents(){
        System.out.println(buttonCos.getText());
        // positioning them for all x.y.width, height set them cause mine is not running i dont know why
        int x;
        int y;
        
        for(int i = 0; i < 4;i++){
            for(int j = 0; j <numbers[i].length;j++){
                if(i==0){y=180;
                    if(j==0){x=240;}
                    else if(j==1){x=320;}
                    else {x=400;}
                }
                else if(i==1){y=260;
                        if(j==0){x=240;}
                        else if(j==1){x=320;}
                        else {x=400;}
                }
                else if(i==2){y=340;
                    if(j==0){x=240;}
                    else if(j==1){x=320;}
                    else {x=400;}
                }
                else{y=420;
                    if(j==0){x=320;}
                    else {x=400;}
                }


                numbers[i][j].setBounds(x, y, 80, 80);
                numbers[i][j].setFont(new Font("Arial", Font.BOLD, 18));
                numbers[i][j].setBackground(grey);
                numbers[i][j].setForeground(Color.white);
                frame.add(numbers[i][j]);
            }
        
        
        }
        for(int i=0; i<basics.length; i++){
            if(i==0){y=100;}
            else if(i==1){y=180;}
            else if(i==2){y=260;}
            else if(i==3){y=340;}
            else{y=420;}

            basics[i].setBounds(480, y, 80, 80);
            basics[i].setFont(new Font("Arial", Font.BOLD, 18));
            basics[i].setBackground(orange);
            basics[i].setForeground(Color.white);
            frame.add(basics[i]);
        }
        for(int i=0; i<operators.length; i++){
            for(int j=0; j<operators[i].length; j++){
                if(i==0){
                    y=100;
                    x= j*80;
                }
                else if(i==1){
                    y=180;
                    x= j*80;
                }
                else if(i==2){
                    y=260;
                    x= j*80;
                }
                else if(i==3){
                    y=340;
                    x= j*80;
                }
                else{
                    y=420;
                    x= j*80;
                }
                operators[i][j].setBounds(x, y, 80, 80);
                operators[i][j].setFont(new Font("Arial", Font.BOLD, 13));
                operators[i][j].setForeground(Color.white);
                operators[i][j].setBackground(darkgrey);
                frame.add(operators[i][j]);
        }

        textField.setBounds(0, 0, 560, 100);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setForeground(Color.white);

        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(textField);
        textField.setBackground(black);
    }



    }
    public void addActionEvent(){
         
        for(int i = 0; i < 4;i++){
            for(int j = 0; j <numbers[i].length;j++){

                final int index = i;
                final int index2 = j;
                numbers[i][j].addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                      
                        // TODO Auto-generated method stub
                        String Current = textField.getText();
                        textField.setText(Current + numbers[index][index2].getText());
                    }
                });
            }
        
    }
        

  
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                textField.setText("");
            }
        });
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Current = textField.getText();
                if (Current.length() > 0) {
                    textField.setText(Current.substring(0, Current.length() - 1));
                }
            }
        });
        buttonEqual.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e){
                answer = evaluate(textField.getText());
                System.out.println(answer);
                textField.setText(Double.toString(answer));
            }
        });
        buttonMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Current = textField.getText();
                textField.setText(Current + "x");
            }
        });
        buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Current = textField.getText();
                textField.setText(Current + "/");
            }
        });
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Current = textField.getText();
                textField.setText(Current + "+");
            }
        });
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Current = textField.getText();
                textField.setText(Current + "\u2013");
            }
        });
        buttonSquare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Current = textField.getText();
                textField.setText(Current + "-");
            }
        });
        buttonReciprocal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Current = textField.getText();
                textField.setText(Current + "^-1");
            }
        });
        buttonSqrt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Current = textField.getText();
                textField.setText(Current + "\u221A");
            }
        });
        buttonSin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Current = textField.getText();
                textField.setText(Current + "sin(");
            }
        });
        buttonCos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Current = textField.getText();
                if (Current == null){
                    textField.setText("cos(");
                }else{
                    textField.setText(Current + "cos(");
                }

            }
        });
        buttonTan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Current = textField.getText();
                textField.setText(Current + "tan(");
            }
        });

        buttonlog10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Current = textField.getText();
                textField.setText(Current + "log(");
            }
        });
        buttonExponent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String Current = textField.getText();
                textField.setText(Current + "e");
            }
        });
        buttonPie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Current = textField.getText();
                textField.setText(Current + "\u03c0");
            }
        });
        buttonCLBrac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Current = textField.getText();
                textField.setText(Current +")");
            }
        });
        buttonOPBrac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Current = textField.getText();
                textField.setText(Current +"(");
            }
        });
        buttonModulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String Current = textField.getText();
                textField.setText(Current +"%");
            }
        });
        buttonSininverse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String Current = textField.getText();
                textField.setText(Current + "sin^-1(");
            }
        });
        buttonCosinverse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String Current = textField.getText();
                textField.setText(Current + "cos^-1(");
            }
        });
        buttonTaninverse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String Current = textField.getText();
                textField.setText(Current + "tan^-1(");
            }
        });
        buttonPower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String Current = textField.getText();
                textField.setText(Current + "^");
            }
        });
        buttonFactorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String Current = textField.getText();
                textField.setText(Current + "!");
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source =e.getSource();
    }
    void Calculator() {
       
        prepareGUI();
        addComponents();
        addActionEvent();
    }
}
