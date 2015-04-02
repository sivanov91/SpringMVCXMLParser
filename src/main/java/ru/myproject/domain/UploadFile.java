package ru.myproject.domain;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by dellix on 30.03.15.
 */
public class UploadFile {

    String name = "";
    MultipartFile file = null;
    String sumOrderPriceN = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getSumOrderPriceN() {
        return sumOrderPriceN;
    }

    public void setSumOrderPriceN(String sumOrderPriceN) {
        this.sumOrderPriceN = sumOrderPriceN;
    }
}
