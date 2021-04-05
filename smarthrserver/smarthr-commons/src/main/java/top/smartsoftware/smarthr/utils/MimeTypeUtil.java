package top.smartsoftware.smarthr.utils;

import ch.qos.logback.core.joran.conditional.ElseAction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Description
 * @Author xjx
 * @Date 2020-12-19
 */
public class MimeTypeUtil {
    public static Integer toIconCode(String mimeType) {

        Integer iconCode = 0;
        if (mimeType==null || "".equals(mimeType)){
            return 0;
        }
        else if (mimeType.equals("text/plain")) {
            iconCode = 1;
        } else if (mimeType.equals("text/xml")) {
            iconCode = 2;
        } else if (mimeType.contains("javascript")) {
            iconCode = 3;
        } else if (mimeType.equals("text/html")) {
            iconCode = 4;
        } else if (mimeType.equals("text/css")) {
            iconCode = 5;
        } else if (mimeType.contains("text/")) {
            iconCode = 6;
        } else if (mimeType.contains("image/")) {
            iconCode = 21;
        } else if (mimeType.contains("video/")) {
            iconCode = 31;
        } else if (mimeType.contains("audio/")) {
            iconCode = 41;
        } else if (mimeType.equals("application/x-shockwave-flash")) {
            iconCode = 51;
        } else if (mimeType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                || mimeType.equals("application/vnd.ms-excel")) {
            iconCode = 61;
        } else if (mimeType.contains("word")) {
            iconCode = 62;
        } else if (mimeType.equals("application/vnd.ms-powerpoint")
                || mimeType.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation")) {
            iconCode = 63;
        } else if (mimeType.equals("application/pdf")) {
            iconCode = 64;
        } else if (mimeType.contains("zip")
                || mimeType.contains("rar")) {
            iconCode = 65;
        } else if (mimeType.equals("application/octet-stream")
                || mimeType.equals("application/x-msdownload")) {
            iconCode = 66;
        } else {
            iconCode = 0;
        }
        return iconCode;
    }

    public static String getContentTypeBySuffix(String fileName) throws IOException {
        if (fileName.endsWith(".rar")){
            return "rar";
        } else if (fileName.endsWith(".js")) {
            return "javascript";
        } else if(fileName.endsWith(".swf")){
            return "application/x-shockwave-flash";
        }
        File file = new File(fileName);
        String result = Files.probeContentType(Paths.get(file.toURI()));
        return result;
    }


    /**
     * 扩展名：abs
     * MIME类型：audio/x-mpeg
     *
     * 扩展名：ai
     * MIME类型：application/postscript
     *
     * 扩展名：aif
     * MIME类型：audio/x-aiff
     *
     * 扩展名：aifc
     * MIME类型：audio/x-aiff
     *
     * 扩展名：aiff
     * MIME类型：audio/x-aiff
     *
     * 扩展名：aim
     * MIME类型：application/x-aim
     *
     * 扩展名：art
     * MIME类型：image/x-jg
     *
     * 扩展名：asf
     * MIME类型：video/x-ms-asf
     *
     * 扩展名：asx
     * MIME类型：video/x-ms-asf
     *
     * 扩展名：au
     * MIME类型：audio/basic
     *
     * 扩展名：avi
     * MIME类型：video/x-msvideo
     *
     * 扩展名：avx
     * MIME类型：video/x-rad-screenplay
     *
     * 扩展名：bcpio
     * MIME类型：application/x-bcpio
     *
     * 扩展名：bin
     * MIME类型：application/octet-stream
     *
     * 扩展名：bmp
     * MIME类型：image/bmp
     *
     * 扩展名：body
     * MIME类型：text/html
     *
     * 扩展名：cdf
     * MIME类型：application/x-cdf
     *
     * 扩展名：cer
     * MIME类型：application/x-x509-ca-cert
     *
     * 扩展名：class
     * MIME类型：application/java
     *
     * 扩展名：cpio
     * MIME类型：application/x-cpio
     *
     * 扩展名：csh
     * MIME类型：application/x-csh
     *
     * 扩展名：css
     * MIME类型：text/css
     *
     * 扩展名：dib
     * MIME类型：image/bmp
     *
     * 扩展名：doc
     * MIME类型：application/msword
     *
     * 扩展名：dtd
     * MIME类型：text/plain
     *
     * 扩展名：dv
     * MIME类型：video/x-dv
     *
     * 扩展名：dvi
     * MIME类型：application/x-dvi
     *
     * 扩展名：eps
     * MIME类型：application/postscript
     *
     * 扩展名：etx
     * MIME类型：text/x-setext
     *
     * 扩展名：exe
     * MIME类型：application/octet-stream
     *
     * 扩展名：gif
     * MIME类型：image/gif
     *
     * 扩展名：gtar
     * MIME类型：application/x-gtar
     *
     * 扩展名：gz
     * MIME类型：application/x-gzip
     *
     * 扩展名：hdf
     * MIME类型：application/x-hdf
     *
     * 扩展名：hqx
     * MIME类型：application/mac-binhex40
     *
     * 扩展名：htc
     * MIME类型：text/x-component
     *
     * 扩展名：htm
     * MIME类型：text/html
     *
     * 扩展名：html
     * MIME类型：text/html
     *
     * 扩展名：hqx
     * MIME类型：application/mac-binhex40
     *
     * 扩展名：ief
     * MIME类型：image/ief
     *
     * 扩展名：jad
     * MIME类型：text/vnd.sun.j2me.app-descriptor
     *
     * 扩展名：jar
     * MIME类型：application/java-archive
     *
     * 扩展名：java
     * MIME类型：text/plain
     *
     * 扩展名：jnlp
     * MIME类型：application/x-java-jnlp-file
     *
     * 扩展名：jpe
     * MIME类型：image/jpeg
     *
     * 扩展名：jpeg
     * MIME类型：image/jpeg
     *
     * 扩展名：jpg
     * MIME类型：image/jpeg
     *
     * 扩展名：js
     * MIME类型：text/javascript
     *
     * 扩展名：jsf
     * MIME类型：text/plain
     *
     * 扩展名：jspf
     * MIME类型：text/plain
     *
     * 扩展名：kar
     * MIME类型：audio/x-midi
     *
     * 扩展名：latex
     * MIME类型：application/x-latex
     *
     * 扩展名：m3u
     * MIME类型：audio/x-mpegurl
     *
     * 扩展名：mac
     * MIME类型：image/x-macpaint
     *
     * 扩展名：man
     * MIME类型：application/x-troff-man
     *
     * 扩展名：me
     * MIME类型：application/x-troff-me
     *
     * 扩展名：mid
     * MIME类型：audio/x-midi
     *
     * 扩展名：midi
     * MIME类型：audio/x-midi
     *
     * 扩展名：mif
     * MIME类型：application/x-mif
     *
     * 扩展名：mov
     * MIME类型：video/quicktime
     *
     * 扩展名：movie
     * MIME类型：video/x-sgi-movie
     *
     * 扩展名：mp1
     * MIME类型：audio/x-mpeg
     *
     * 扩展名：mp2
     * MIME类型：audio/x-mpeg
     *
     * 扩展名：mp3
     * MIME类型：audio/x-mpeg
     *
     * 扩展名：mpa
     * MIME类型：audio/x-mpeg
     *
     * 扩展名：mpe
     * MIME类型：video/mpeg
     *
     * 扩展名：mpeg
     * MIME类型：video/mpeg
     *
     * 扩展名：mpega
     * MIME类型：audio/x-mpeg
     *
     * 扩展名：mpg
     * MIME类型：video/mpeg
     *
     * 扩展名：mpv2
     * MIME类型：video/mpeg2
     *
     * 扩展名：ms
     * MIME类型：application/x-wais-source
     *
     * 扩展名：nc
     * MIME类型：application/x-netcdf
     *
     * 扩展名：oda
     * MIME类型：application/oda
     *
     * 扩展名：pbm
     * MIME类型：image/x-portable-bitmap
     *
     * 扩展名：pct
     * MIME类型：image/pict
     *
     * 扩展名：pdf
     * MIME类型：application/pdf
     *
     * 扩展名：pgm
     * MIME类型：image/x-portable-graymap
     *
     * 扩展名：pic
     * MIME类型：image/pict
     *
     * 扩展名：pict
     * MIME类型：image/pict
     *
     * 扩展名：pls
     * MIME类型：audio/x-scpls
     *
     * 扩展名：png
     * MIME类型：image/png
     *
     * 扩展名：pnm
     * MIME类型：image/x-portable-anymap
     *
     * 扩展名：pnt
     * MIME类型：image/x-macpaint
     *
     * 扩展名：ppm
     * MIME类型：image/x-portable-pixmap
     *
     * 扩展名：ps
     * MIME类型：application/postscript
     *
     * 扩展名：psd
     * MIME类型：image/x-photoshop
     *
     * 扩展名：qt
     * MIME类型：video/quicktime
     *
     * 扩展名：qti
     * MIME类型：image/x-quicktime
     *
     * 扩展名：qtif
     * MIME类型：image/x-quicktime
     *
     * 扩展名：ras
     * MIME类型：image/x-cmu-raster
     *
     * 扩展名：rgb
     * MIME类型：image/x-rgb
     *
     * 扩展名：rm
     * MIME类型：application/vnd.rn-realmedia
     *
     * 扩展名：roff
     * MIME类型：application/x-troff
     *
     * 扩展名：rtf
     * MIME类型：application/rtf
     *
     * 扩展名：rtx
     * MIME类型：text/richtext
     *
     * 扩展名：sh
     * MIME类型：application/x-sh
     *
     * 扩展名：shar
     * MIME类型：application/x-shar
     *
     * 扩展名：sit
     * MIME类型：application/x-stuffit
     *
     * 扩展名：smf
     * MIME类型：audio/x-midi
     *
     * 扩展名：snd
     * MIME类型：audio/basic
     *
     * 扩展名：src
     * MIME类型：application/x-wais-source
     *
     * 扩展名：sv4cpio
     * MIME类型：application/x-sv4cpio
     *
     * 扩展名：sv4crc
     * MIME类型：application/x-sv4crc
     *
     * 扩展名：swf
     * MIME类型：application/x-shockwave-flash
     *
     * 扩展名：t
     * MIME类型：application/x-troff
     *
     * 扩展名：tar
     * MIME类型：application/x-tar
     *
     * 扩展名：tcl
     * MIME类型：application/x-tcl
     *
     * 扩展名：tex
     * MIME类型：application/x-tex
     *
     * 扩展名：texi
     * MIME类型：application/x-texinfo
     *
     * 扩展名：texinfo
     * MIME类型：application/x-texinfo
     *
     * 扩展名：tif
     * MIME类型：image/tiff
     *
     * 扩展名：tiff
     * MIME类型：image/tiff
     *
     * 扩展名：tr
     * MIME类型：application/x-troff
     *
     * 扩展名：tsv
     * MIME类型：text/tab-separated-values
     *
     * 扩展名：txt
     * MIME类型：text/plain
     *
     * 扩展名：ulw
     * MIME类型：audio/basic
     *
     * 扩展名：ustar
     * MIME类型：application/x-ustar
     *
     * 扩展名：xbm
     * MIME类型：image/x-xbitmap
     *
     * 扩展名：xml
     * MIME类型：text/xml
     *
     * 扩展名：xpm
     * MIME类型：image/x-xpixmap
     *
     * 扩展名：xsl
     * MIME类型：text/xml
     *
     * 扩展名：xwd
     * MIME类型：image/x-xwindowdump
     *
     * 扩展名：wav
     * MIME类型：audio/x-wav
     *
     * 扩展名：svg
     * MIME类型：image/svg+xml
     *
     * 扩展名：svgz
     * MIME类型：image/svg+xml
     *
     * 扩展名：wbmp
     * MIME类型：image/vnd.wap.wbmp
     *
     * 扩展名：wml
     * MIME类型：text/vnd.wap.wml
     *
     * 扩展名：wmlc
     * MIME类型：application/vnd.wap.wmlc
     *
     * 扩展名：wmls
     * MIME类型：text/vnd.wap.wmlscript
     *
     * 扩展名：wmlscriptc
     * MIME类型：application/vnd.wap.wmlscriptc
     *
     * 扩展名：wrl
     * MIME类型：x-world/x-vrml
     *
     * 扩展名：Z
     * MIME类型：application/x-compress
     *
     * 扩展名：z
     * MIME类型：application/x-compress
     *
     * 扩展名：zip
     * MIME类型：application/zip
     *
     *
     * gif : image/gif
     * bmp : image/bmp
     * ico : image/x-ico
     * jpeg : image/jpeg
     * jpg : image/jpeg
     * png : image/png
     * zip : application/zip
     * rar : application/x-rar
     * jsp : text/html
     * pdf : application/pdf
     * png : image/png
     * jpg : image/jpeg
     * mp4 : video/mp4
     * flv : video/x-flv
     * ppt : application/vnd.ms-powerpoint
     * pptx : application/vnd.openxmlformats-officedocument.presentationml.presentation
     * xlsx : application/vnd.openxmlformats-officedocument.spreadsheetml.sheet
     * xls : application/vnd.ms-excel
     * doc : application/msword
     * docx : application/vnd.openxmlformats-officedocument.wordprocessingml.document
     * txt : text/plain
     *
     *
     *
     * java获取mimeType的方法：注意必须jdk7 (通过后缀名判断的)
     * public static void process(File f) throws IOException{
     *         System.out.println(f.getName()+":"+Files.probeContentType(Paths.get(f.toURI())));
     * }
     */

}

