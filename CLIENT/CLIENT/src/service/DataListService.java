package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.DataListDto;
import dto.ReadingDetailsDto;
import util.Utilities;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="dataListService")
@ApplicationScoped
public class DataListService implements Serializable {

    public List<ReadingDetailsDto> getWeekReadings(){

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/readings/weekreadings")
                .queryParam("userId", Utilities.getUserId());
        Invocation.Builder invocationBuilder = target.request();
        Response response = invocationBuilder.get();
        List<ReadingDetailsDto> readingDetailsDtos = response.readEntity(new GenericType<List<ReadingDetailsDto>>() {});
        return  readingDetailsDtos;
    }

}
