import java.awt.*;
import java.awt.event.*;
class FDemo extends Frame implements ActionListener
{
Button b1[]=new Button[9];
FDemo()
{
setTitle("TIC TAC TOE");
Font f=new Font("Brush Script MT",Font.BOLD,25);
setFont(f);
setLayout(null);
int i,j,k=0;
int x=100;
int y=100;
for(i=1;i<=3;i++)
{
for(j=1;j<=3;j++)
{
b1[k]=new Button();
b1[k].setSize(100,100);
b1[k].setLocation(x,y);
add(b1[k]);
b1[k].addActionListener(this);
x+=100;k++;
}
y+=100;x=100;
}
}
int c=1;
public void actionPerformed(ActionEvent e)
{
Button b=(Button)e.getSource();
if(c%2==1)
{
b.setLabel("0");
c=0;
}
else
{
b.setLabel("X");
c=1;
}
b.removeActionListener(this);
}
}
class Demo203
{
public static void main(String ar[])
{
FDemo f=new FDemo();
f.setVisible(true);
f.setSize(500,300);
f.setLocation(200,100);
f.setBackground(Color.yellow);
}
}