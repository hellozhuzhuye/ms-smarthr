import org.junit.jupiter.api.Test;
import top.smartsoftware.smarthr.utils.MimeTypeUtil;

import java.io.IOException;

/**
 * @Description
 * @Author xjx
 * @Date 2020-12-22
 */
public class MimeTest {

    @Test
    public void getMime() throws IOException {
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.exe")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.swf")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.css")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.js")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.html")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.xml")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.xlsx")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.xls")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.doc")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.docx")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.ppt")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.pptx")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.zip")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.rar")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.mp4")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.txt")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.mp3")));
        System.out.println("txt:"+MimeTypeUtil.toIconCode(MimeTypeUtil.getContentTypeBySuffix("a.pdf")));

    }

}
