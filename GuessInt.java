import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


//class for Window creation(layout)
class Frame implements ActionListener
{
    JFrame f,m;
    Random rand=new Random();
    JButton button,button2,button3;
    JTextField tf,tf1,ans;
    JTextArea area;
    JLabel lhead,lhead1,ltotal,lcount,ldes1,ldes2,ldes3,output;
    int num,count=0;
    
    Frame()
    {
        num=rand.nextInt(100);
        f = new JFrame("Guess me!!");
	    m=new JFrame("How to Play");
	    area=new JTextArea("\t         Hello player!! Happy to see you!\n\n"+
        "Here are the steps to play this game\n\n"+
        "->Enter a number between 0-100\n\n"+
        "->Press Guess.You will get a clue\n\n"+
        "->With help of the clue guess the number\n\n"+
        "->You will be given 7 chances to guess the number\n\n"+
        "->Try Guessing upto your chance\n\n\n"+
        "\t\tEnjoy Playing it !!");
        tf=new JTextField();
        tf1=new JTextField();
        ans=new JTextField();
        button=new JButton("Guess");
        button2=new JButton("How to Play");
        button3=new JButton("Back to Game");
        lhead=new JLabel("Guess me!!");
        ltotal= new JLabel("Total Guess: ");
        lcount=new JLabel("Attempted Guess: ");
        ldes1=new JLabel("I am a number.");
        ldes2=new JLabel("I am between 1-100!!");
        ldes3=new JLabel("Who am I ?");
        lhead1=new JLabel("How To Play?");
        output=new JLabel("");

        button.addActionListener(this);
	    button2.addActionListener(this);
        button3.addActionListener(this);
        
        button2.setBounds(40,370,100,30);
        button3.setBounds(20,370,150,30);
        button.setBounds(270,290,110,30);
	    area.setBounds(20,70,440,270);
        area.setEditable(false);
        lhead.setBounds(180,10,200,40);
        lhead.setForeground(Color.blue);
        lhead.setFont(new Font("Verdana", Font.PLAIN, 18));
        lhead1.setBounds(180,10,200,40);
        lhead1.setForeground(Color.blue);
        lhead1.setFont(new Font("Verdana", Font.PLAIN, 18));
        ltotal.setBounds(60,50,90,40);
        tf.setBounds(140,60,20,20);
        tf.setText("7");
        tf.setEditable(false);
        lcount.setBounds(260,50,110,40);
        tf1.setBounds(370,60,20,20);
        tf1.setEditable(false);
        tf1.setText("0");
        ldes1.setBounds(280,130,100,40);
        ldes2.setBounds(270,150,150,40);
        ldes3.setBounds(280,180,100,40);
        ldes3.setForeground(Color.red);
        ldes3.setFont(new Font("Verdana", Font.PLAIN, 15));
        ans.setBounds(270,230,110,20);
        output.setBounds(270,260,200,20);


        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GuessInt it = new GuessInt();

        f.add(output);
        f.add(lcount);
        f.add(tf1);
        f.add(tf);
        f.add(ans);
        f.add(ltotal);
        f.add(lhead);
        f.add(ldes1);
        f.add(ldes2);
        f.add(ldes3);
        f.add(button);
	    f.add(button2);
        f.add(it);
        f.pack();
        f.setSize(500,450);
        f.setVisible(true);

        m.setVisible(false);
        m.setLayout(null);
        m.setSize(500,450);
        m.add(lhead1);
        m.add(area);
        m.add(button3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="How to Play")
	{
		f.setVisible(false);
		m.setVisible(true);
	}
	if(e.getActionCommand()=="Back to Game")
    {
        m.setVisible(false);
        f.setVisible(true);
    }
	
        if(e.getActionCommand()=="Guess")
        {
	    int ch=Integer.parseInt(ans.getText());
            if(ch==num)
            {
                output.setText("Great Job!!");
                output.setForeground(Color.green);
                button.setText("Play Again");
            }
            else if(ch>100)
            {
                output.setText("Enter a valid number!!");
                output.setForeground(Color.red);
            }
            else if(count==6&&ch!=num)
            {
                output.setText("Sorry your are wrong!! I am"+num);
                output.setForeground(Color.red);
                button.setText("Play Again");
            }
            else if(ch>num)
            {
                output.setText("I am less than what you expect!!");
                output.setForeground(Color.blue);
            }
            else if(ch<num)
            {
                output.setText("I am greater than what you expect!!");
                output.setForeground(Color.blue);
            }
            count++;
            String s=String.valueOf(count);
            tf1.setText(s);
        }
        if(e.getActionCommand()=="Play Again")
        {
            count=0;
            num=rand.nextInt(100);
            ans.setText("");
            tf1.setText("0");
            button.setText("Guess");
            output.setText("");
        }
        
    }


}

//class which calls the Frame construtor
public class GuessInt extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        Image image = new ImageIcon("q2.png").getImage();
        g.drawImage(image, -50, 150,300,200,null);
    }
 
    public static void main(String[] args) {
        new Frame();   
    }
}