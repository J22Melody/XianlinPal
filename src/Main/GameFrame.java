package Main;

import java.awt.Container;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame{
	
	//���ڴ�С
	public static final int WIDTH=800;
	public static final int HEIGHT=480;
	
	//֡��
	public static final int FPS=16;

	//���߳�
	public Thread MainThread;
	
	@SuppressWarnings("unused")
	public GameFrame(){
		//��ʼ��
		Container c=getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(WIDTH,HEIGHT);
	    setTitle("�ɼ�������");
	    setResizable(false);
	    setLocationRelativeTo(null);	
	    setVisible(true);
	  
	    //��ʼ���
	    GamePanel gp=new GamePanel();
	    add(gp);
	    gp.revalidate();
        gp.requestFocus();
        
        //�����߳�
        MainThread=new Thread(gp);
        MainThread.start();
	}


	//������
	public static void main(String[] args) {
		new GameFrame();	
	}

}
