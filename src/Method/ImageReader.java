package Method;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class ImageReader {
	//��ȡͼ��
	public static Image work(String filename){
		ImageIcon icon = new ImageIcon("image/"+filename+".png");
        Image im = icon.getImage();
        icon=null;
        return im;
	}
	
}
