package mcq;

//Create an image in memory

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;

public class MemoryImageGenerator {
	
	Image img;
	int w = 512;
	int h = 512;
	MemoryImageSource source;
	
	public MemoryImageGenerator() {
		int pixels[] = new int[w*h];
		int i = 0;
		
		for(int y=0; h<h; y++) {
			for(int x=0; x<w; x++) {
				int r = (x^y)&0xff;
				int g = (x*2^y*2)&0xff;
				int b = (x*4^y*4)&0xff;
				pixels[i++] = (255<<24) | (r<<16) | (g<<8) | b;
			}
		}
		source = new MemoryImageSource(w, h, pixels, 0, w);
        source.setAnimated(true);
        image = createImage(source);
		
		add WindowListener(new WindowAdapter()){
			public void windowClosing
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
