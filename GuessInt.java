import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class Frame implements ActionListener
{
    JFrame f;
    Random rand=new Random();
    JButton button,button2;
    JTextField tf,tf1,ans;
    JLabel lhead,ltotal,lcount,ldes1,ldes2,ldes3,output;
    int num,count=0;
    
    Frame()
    {
        num=rand.nextInt(100);
        f = new JFrame("Guess me!!");
        tf=new JTextField();
        tf1=new JTextField();
        ans=new JTextField();
        button=new JButton("Guess");
        lhead=new JLabel("Guess me!!");
        ltotal= new JLabel("Total Guess: ");
        lcount=new JLabel("Attempted Guess: ");
        ldes1=new JLabel("I am a number.");
        ldes2=new JLabel("I am between 1-100!!");
        ldes3=new JLabel("Who am I ?");
        output=new JLabel("");

        button.addActionListener(this);
        
        button.setBounds(270,290,110,30);
        lhead.setBounds(180,10,200,40);
        lhead.setForeground(Color.blue);
        lhead.setFont(new Font("Verdana", Font.PLAIN, 18));
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
        f.add(it);
        f.pack();
        f.setSize(500,450);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int ch=Integer.parseInt(ans.getText());
        if(e.getActionCommand()=="Guess")
        {
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
