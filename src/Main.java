import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {

    public static void main(String[] args){

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 2, 10, 10));

        JTextArea textAreaNum1 = new JTextArea(1, 5);
        JTextArea textAreaNum2 = new JTextArea(1 , 5);
        JTextArea textAreaResult = new JTextArea(1, 5);
        textAreaNum1.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
        textAreaNum2.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
        textAreaResult.setEditable(false);

        Border border = BorderFactory.createLineBorder(Color .BLUE);
        textAreaNum1.setBorder(border);
        textAreaNum2.setBorder(border);
        textAreaResult.setBorder(border);

        JButton buttonSum = new JButton("+");
        JButton buttonMin = new JButton("-");
        JButton buttonMul = new JButton("*");
        JButton buttonDiv = new JButton("/");



        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(buttonSum);
        buttonPanel.add(buttonMin);
        buttonPanel.add(buttonMul);
        buttonPanel.add(buttonDiv);

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Number 1:"));
        inputPanel.add(textAreaNum1);
        inputPanel.add(new JLabel("Number 2:"));
        inputPanel.add(textAreaNum2);


        JPanel resultPanel = new JPanel(new FlowLayout());
        resultPanel.add(new JLabel("Result:"));
        resultPanel.add(textAreaResult);

        frame.getContentPane().add(inputPanel);
        frame.getContentPane().add(buttonPanel);
        frame.getContentPane().add(resultPanel);


        buttonSum.addActionListener(e -> {
            double[] nums = readInputs(textAreaNum1, textAreaNum2);
            textAreaResult.setText(String.valueOf(sum(nums[0], nums[1])));
        });

        buttonMin.addActionListener(e -> {
            double[] nums = readInputs(textAreaNum1, textAreaNum2);
            textAreaResult.setText(String.valueOf(min(nums[0], nums[1])));
        });

        buttonMul.addActionListener(e -> {
            double[] nums = readInputs(textAreaNum1, textAreaNum2);
            textAreaResult.setText(String.valueOf(mul(nums[0], nums[1])));
        });

        buttonDiv.addActionListener(e -> {
            double[] nums = readInputs(textAreaNum1, textAreaNum2);
            if (nums[1] == 0){
                textAreaResult.setText("Cannot divide by ZERO!");
            }
            else {
                textAreaResult.setText(String.valueOf(div(nums[0], nums[1])));
            }


        });


        frame.setVisible(true);


    }




    public static double[] readInputs(JTextArea t1, JTextArea t2){
        double num1 = 0, num2 = 0;

        try {
            num1 = Double.parseDouble(t1.getText());
            num2 = Double.parseDouble(t2.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers");
        }
        return new double[]{num1, num2};

    }


    public static double sum(double x, double y){
        return x + y;
    }
    public static double min(double x, double y){
        return x - y;
    }
    public static double mul(double x, double y){
        return x * y;
    }
    public static double div(double x, double y){
        return x / y;
    }


}
