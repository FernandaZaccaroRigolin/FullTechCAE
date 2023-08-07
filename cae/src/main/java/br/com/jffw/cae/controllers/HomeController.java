package br.com.jffw.cae.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String iniciar() {
		return "home";
	}


public static String convertPngToByteString(String path) {
    String img = "";
    try{
        File imagem = new File(path);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        BufferedImage bi = ImageIO.read(imagem);
        ImageIO.write(bi, "png", bos);
        bi.flush();
        byte[] imageInByte = bos.toByteArray();
        bos.close();
        img = DatatypeConverter.printBase64Binary(imageInByte);
    } catch(Exception e) {
        e.printStackTrace();
    }
    return img;
}

}