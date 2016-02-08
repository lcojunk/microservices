package com.example.rest;

import com.example.dto.CreateReferenceRequest;
import com.example.dto.RestResponse;
import com.example.model.Reference;
import com.example.services.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by odzhara-ongom on 01.02.2016.
 */
@RestController
@RequestMapping(value = "/api/references")
public class resCrudController {

    @Autowired
    private ReferenceService referenceService;

    @RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
    public String test(@PathVariable String name) {
        return "path=/test/" + name;
    }

    @RequestMapping(method = RequestMethod.POST)
    public RestResponse<List<Reference>, CreateReferenceRequest> create(@RequestBody CreateReferenceRequest request) {
        return referenceService.create(request);
    }

    @RequestMapping(method = RequestMethod.GET)
    public RestResponse<List<Reference>, CreateReferenceRequest> readAll() {
        return referenceService.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RestResponse<Reference, String> read(@PathVariable String id) {
        return referenceService.read(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public RestResponse<List<Reference>, CreateReferenceRequest> update(@PathVariable String id, @RequestBody CreateReferenceRequest request) {
        if (request != null && id != null) {
            request.setId(id);
        }
        return referenceService.update(request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RestResponse<List<Reference>, CreateReferenceRequest> delete(@PathVariable String id) {
        CreateReferenceRequest request = new CreateReferenceRequest();
        request.setId(id);
        return referenceService.delete(request);
    }

}
