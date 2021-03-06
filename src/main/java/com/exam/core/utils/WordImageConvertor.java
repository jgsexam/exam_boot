package com.exam.core.utils;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * 文档图片转换器
 *
 * @Author: 杨德石
 * @Date: 2019/5/17 0017 下午 3:17
 * @Version 1.0
 */
public class WordImageConvertor {

    /**
     * @param @param imageSrc 文件路径
     * @return String
     * @throws IOException
     * @throws
     * @Description: 将图片转换成base64编码的字符串
     */
    public static String imageToBase64(String imageSrc) throws IOException {
        //判断文件是否存在
        File file = new File(imageSrc);
        if (!file.exists()) {
            throw new FileNotFoundException("文件不存在！");
        }
        StringBuilder pictureBuffer = new StringBuilder();
        FileInputStream input = new FileInputStream(file);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //读取文件
        BASE64Encoder encoder = new BASE64Encoder();
        byte[] temp = new byte[1024];
        for (int len = input.read(temp); len != -1; len = input.read(temp)) {
            out.write(temp, 0, len);
        }
        pictureBuffer.append(new String(Base64.encodeBase64Chunked(out.toByteArray())));
        input.close();
        return pictureBuffer.toString();
    }

    public static String toDocBodyBlock(
            String imageFilePath,
            String imageFielShortName,
            int imageHeight,
            int imageWidth,
            String imageStyle,
            String srcLocationShortName,
            String shapeidPrex, String spidPrex, String typeid) {
        //shapeid
        //mht文件中针对shapeid的生成好像规律，其内置的生成函数没法得知，但是只要保证其唯一就行
        //这里用前置加32位的uuid来保证其唯一性。
        String shapeid = shapeidPrex;
        shapeid += UUID.randomUUID().toString();

        //spid ,同shapeid处理
        String spid = spidPrex;
        spid += UUID.randomUUID().toString();


	/*	<!--[if gte vml 1]><v:shape id=3D"_x56fe__x7247__x0020_0" o:spid=3D"_x0000_i10=
				26"
				   type=3D"#_x0000_t75" alt=3D"725017921264249223.jpg" style=3D'width:456.7=
				5pt;
				   height:340.5pt;visibility:visible;mso-wrap-style:square'>
				   <v:imagedata src=3D"file9462.files/image001.jpg" o:title=3D"725017921264=
				249223"/>
				  </v:shape><![endif]--><![if !vml]><img width=3D609 height=3D454
				  src=3D"file9462.files/image002.jpg" alt=3D725017921264249223.jpg v:shapes=
				=3D"_x56fe__x7247__x0020_0"><![endif]>*/
        StringBuilder sb1 = new StringBuilder();

        sb1.append(" <!--[if gte vml 1]>");
        sb1.append("<v:shape id=3D\"" + shapeid + "\"");
        sb1.append("\n");
        sb1.append(" o:spid=3D\"" + spid + "\"");
        sb1.append(" type=3D\"" + typeid + "\" alt=3D\"" + imageFielShortName + "\"");
        sb1.append("\n");
        sb1.append(" style=3D' " + generateImageBodyBlockStyleAttr(imageFilePath, imageHeight, imageWidth) + imageStyle + "'");
        sb1.append(">");
        sb1.append("\n");
        sb1.append(" <v:imagedata src=3D\"" + srcLocationShortName + "\"");
        sb1.append("\n");
        sb1.append(" o:title=3D\"" + imageFielShortName.split("\\.")[0] + "\"");
        sb1.append("/>");
        sb1.append("</v:shape>");
        sb1.append("<![endif]-->");

        //以下是为了兼容游览器显示时的效果，但是如果是纯word阅读的话没必要这么做。
	/*	StringBuilder sb2=new StringBuilder();
		sb2.append(" <![if !vml]>");

		sb2.append("<img width=3D"+imageWidth +" height=3D" +imageHeight +
				  " src=3D\"" + srcLocationShortName +"\" alt=" +imageFielShortName+
				  " v:shapes=3D\"" + shapeid +"\">");

		sb2.append("<![endif]>");*/

        //return sb1.toString()+sb2.toString();
        return sb1.toString();
    }

    /**
     * 生成图片的base4块
     *
     * @param nextPartId
     * @param contextLoacation
     * @param fileTypeName
     * @param base64Content
     * @return
     * @createUser shandianlala程细望
     * @createDate 2017年10月25日
     */
    public static String generateImageBase64Block(String nextPartId, String contextLoacation,
                                                  String fileTypeName, String base64Content) {
		/*--=_NextPart_01D188DB.E436D870
				Content-Location: file:///C:/70ED9946/file9462.files/image001.jpg
				Content-Transfer-Encoding: base64
				Content-Type: image/jpeg

				base64Content
		*/

        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("\n");
        sb.append("------=_NextPart_" + nextPartId);
        sb.append("\n");
        sb.append("Content-Location: " + contextLoacation);
        sb.append("\n");
        sb.append("Content-Transfer-Encoding: base64");
        sb.append("\n");
        sb.append("Content-Type: " + getImageContentType(fileTypeName));
        sb.append("\n");
        sb.append("\n");
        sb.append(base64Content);

        return sb.toString();
    }

    private static String generateImageBodyBlockStyleAttr(String imageFilePath, int height, int width) {
        StringBuilder sb = new StringBuilder();

        BufferedImage sourceImg;
        try {
            sourceImg = ImageIO.read(new FileInputStream(imageFilePath));
            if (height == 0) {
                height = sourceImg.getHeight();
            }
            if (width == 0) {
                width = sourceImg.getWidth();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //将像素转化成pt
        BigDecimal heightValue = new BigDecimal(height * 12 / 16);
        heightValue = heightValue.setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal widthValue = new BigDecimal(width * 12 / 16);
        widthValue = widthValue.setScale(2, BigDecimal.ROUND_HALF_UP);

        sb.append("height:" + heightValue + "pt;");
        sb.append("width:" + widthValue + "pt;");
        sb.append("visibility:visible;");
        sb.append("mso-wrap-style:square; ");

        return sb.toString();
    }

    private static String getImageContentType(String fileTypeName) {
        String result = "image/jpeg";
        //http://tools.jb51.net/table/http_content_type
        if (fileTypeName.equals("tif") || fileTypeName.equals("tiff")) {
            result = "image/tiff";
        } else if (fileTypeName.equals("fax")) {
            result = "image/fax";
        } else if (fileTypeName.equals("gif")) {
            result = "image/gif";
        } else if (fileTypeName.equals("ico")) {
            result = "image/x-icon";
        } else if (fileTypeName.equals("jfif") || fileTypeName.equals("jpe")
                || fileTypeName.equals("jpeg") || fileTypeName.equals("jpg")) {
            result = "image/jpeg";
        } else if (fileTypeName.equals("net")) {
            result = "image/pnetvue";
        } else if (fileTypeName.equals("png") || fileTypeName.equals("bmp")) {
            result = "image/png";
        } else if (fileTypeName.equals("rp")) {
            result = "image/vnd.rn-realpix";
        } else if (fileTypeName.equals("rp")) {
            result = "image/vnd.rn-realpix";
        }

        return result;
    }

    /**
     * 获取图片后缀名，如jpg,png等
     *
     * @param srcRealPath 图片绝对路径
     * @return
     * @createUser shandianlala
     * @createDate 2017年10月25日
     */
    public static String getFileSuffix(String srcRealPath) {
        int lastIndex = srcRealPath.lastIndexOf(".");
        String suffix = srcRealPath.substring(lastIndex + 1);
        return suffix;
    }

}