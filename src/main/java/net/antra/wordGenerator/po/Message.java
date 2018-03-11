package net.antra.wordGenerator.po;

import net.antra.wordGenerator.controller.MustBeDigits;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Message {
    @NotBlank(message = "fill in the blank!")
    @MustBeDigits(message = "digits only!!")
    private String text;
    private List<String> list;
    private int page;
    private int totalPage;
    private String error="";

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }



    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getText() {
        return text;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setText(String text) {
        this.text = text;
    }
}
