package Main;

import java.awt.Container;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame{
	
	//窗口大小
	public static final int WIDTH=800;
	public static final int HEIGHT=480;
	
	//帧率
	public static final int FPS=16;

	//主线程
	public Thread MainThread;
	
	@SuppressWarnings("unused")
	public GameFrame(){
		//初始化
		Container c=getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(WIDTH,HEIGHT);
	    setTitle("仙件奇侠传");
	    setResizable(false);
	    setLocationRelativeTo(null);	
	    setVisible(true);
	  
	    //初始面板
	    GamePanel gp=new GamePanel();
	    add(gp);
	    gp.revalidate();
        gp.requestFocus();
        
        //启动线程
        MainThread=new Thread(gp);
        MainThread.start();
	}


	//主方法
	public static void main(String[] args) {
		new GameFrame();	
	}

}
