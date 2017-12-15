import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame implements ActionListener{
    private Container pane;
    private JButton CtoF;
    private JButton FtoC;
    private JTextField text;

    public void actionPerformed(ActionEvent e){
	String event=e.getActionCommand();
        if (event.equals("Celsius to Farenheit")){
	    double temperature = Double.parseDouble(text.getText());
	    text.setText(""+ CtoF(temperature));
	}
	if (event.equals("Farenheit to Celsius")){
	    double temperature = Double.parseDouble(text.getText());
	    text.setText(""+ FtoC(temperature));
	}   
    }
    public TemperatureWindow(){
	this.setTitle("Temperature Window");
        this.setSize(400,100);
        this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane=this.getContentPane();
	pane.setLayout(new FlowLayout());
	CtoF=new JButton("Celsius to Farenheit");
	FtoC=new JButton("Farenheit to Celsius");
	text=new JTextField(12);
       	CtoF.addActionListener(this);
	FtoC.addActionListener(this);
	text.addActionListener(this);
	pane.add(CtoF);
	pane.add(FtoC);
	pane.add(text);
    }
    public static double CtoF(double celsius){
	return celsius*1.8+32;
    }
    public static double FtoC(double farenheit){
	return (farenheit-32)*(5.0/9);
    }
    public static void main(String[] args){
	TemperatureWindow temp=new TemperatureWindow();
	temp.setVisible(true);
    }
}
