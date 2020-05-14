package service;

import dto.ReadingDto;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="readingService")
@SessionScoped
public class ReadingService implements Serializable {

    private List<ReadingDto> readingDtoList = new ArrayList<>();

    public List<ReadingDto> getReadingDtoList() {
        return readingDtoList;
    }

    public void setReadingDtoList(List<ReadingDto> readingDtoList) {
        this.readingDtoList = readingDtoList;
    }
}
