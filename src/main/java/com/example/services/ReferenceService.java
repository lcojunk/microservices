package com.example.services;

import com.example.dto.CreateReferenceRequest;
import com.example.dto.RestResponse;
import com.example.model.Reference;
import com.example.repository.ReferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by odzhara-ongom on 01.02.2016.
 */
@Service
public class ReferenceService {
    private ReferenceRepository referenceRepository=new ReferenceRepository();


    public RestResponse<List<Reference>,CreateReferenceRequest> create(CreateReferenceRequest request) {
        RestResponse<List<Reference>, CreateReferenceRequest> response = new RestResponse<>(request);
        try {
            Reference reference = new Reference();
            if (request != null) {
                reference.setName(request.getName());
                reference.setDescription(request.getDescription());
                response.setSuccess(referenceRepository.create(reference) != null);
            }
            response.setResult(referenceRepository.getAll());
            response.setError("no Error");
            return response;
        } catch (Exception e){
            response.setError(e.toString());
            return response;
        }
    }
    public RestResponse<List<Reference>,CreateReferenceRequest> update(CreateReferenceRequest request) {
        RestResponse<List<Reference>, CreateReferenceRequest> response = new RestResponse<>(request);
        try {
            Reference reference = new Reference();
            if (request != null) {
                reference.setId(request.getId());
                reference.setName(request.getName());
                reference.setDescription(request.getDescription());
                response.setSuccess(referenceRepository.update(reference) != null);
            }
            response.setResult(referenceRepository.getAll());
            return response;
        } catch (Exception e){
            response.setError(e.toString());
            return response;
        }
    }
    public RestResponse<Reference,String> read(String id){
        RestResponse<Reference, String> response = new RestResponse<>(id);
        try {
            response.setResult(referenceRepository.read(id));
            response.setSuccess(response.getResult()!=null);
            return response;
        } catch (Exception e){
            response.setError(e.toString());
            return response;
        }
    }
    public RestResponse<List<Reference>,CreateReferenceRequest> readAll() {
        RestResponse<List<Reference>, CreateReferenceRequest> response = new RestResponse<>();
        try {

            response.setResult(referenceRepository.getAll());
            response.setSuccess(response.getResult()!=null);
            return response;
        } catch (Exception e){
            response.setError(e.toString());
            return response;
        }
    }

    public RestResponse<List<Reference>,CreateReferenceRequest> delete(CreateReferenceRequest request) {
        RestResponse<List<Reference>, CreateReferenceRequest> response = new RestResponse<>(request);
        try {
            Reference reference = new Reference();
            if (request != null) {
                reference.setId(request.getId());
                reference.setName(request.getName());
                reference.setDescription(request.getDescription());
                response.setSuccess(referenceRepository.delete(reference));
            }
            response.setResult(referenceRepository.getAll());
            return response;
        } catch (Exception e){
            response.setError(e.toString());
            return response;
        }
    }



}
