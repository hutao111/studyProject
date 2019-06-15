package org.hutao.projectservice.application.util;

import org.hutao.projectapi.enums.DocumentType;
import org.springframework.stereotype.Component;

@Component
public class WorkUtil {


    public Integer documentType(String suffixName) {

        if (suffixName.equals("pdf") || suffixName.equals("doc") || suffixName.equals("xlsx") || suffixName.equals("xls") || suffixName.equals("ppt")) {

            return DocumentType.DOCUMENT.getType();
        }

        if (suffixName.equals("bmp") || suffixName.equals("jpg") || suffixName.equals("png") || suffixName.equals("tif") || suffixName.equals("gif")
                || suffixName.equals("pcx") || suffixName.equals("tga") || suffixName.equals("exif") || suffixName.equals("fpx") || suffixName.equals("svg")
                || suffixName.equals("psd") || suffixName.equals("cdr") || suffixName.equals("pcd") || suffixName.equals("dxf") || suffixName.equals("ufo")
                || suffixName.equals("eps") || suffixName.equals("ai") || suffixName.equals("raw") || suffixName.equals("WMF") || suffixName.equals("webp")) {

            return DocumentType.PICTURE.getType();
        }

        if (suffixName.equals("mp3") || suffixName.equals("wma") || suffixName.equals("wav") || suffixName.equals("mp3pro") || suffixName.equals("cd")
                || suffixName.equals("wave") || suffixName.equals("aiff") || suffixName.equals("mpeg") || suffixName.equals("mpeg-4") || suffixName.equals("midi")
                || suffixName.equals("RealAudio") || suffixName.equals("VQF") || suffixName.equals("OggVorbis") || suffixName.equals("AMR") || suffixName.equals("APE")
                || suffixName.equals("FLAC") || suffixName.equals("AAC")) {
            return DocumentType.AUDIO.getType();
        }

        if (suffixName.equals("mp4") || suffixName.equals("avi") || suffixName.equals("mov") || suffixName.equals("flv") || suffixName.equals("mvb")
                || suffixName.equals("MPEG") || suffixName.equals("ASF") || suffixName.equals("3GP") || suffixName.equals("MKV")
                || suffixName.equals("F4V") || suffixName.equals("RMVB") || suffixName.equals("RM") || suffixName.equals("MOV")
                || suffixName.equals("QT") || suffixName.equals("NAVI") || suffixName.equals("DivX") || suffixName.equals("MPG")
                || suffixName.equals("DAT")) {
            return DocumentType.VIDEO.getType();
        }

        return DocumentType.OTHER.getType();


    }
}
