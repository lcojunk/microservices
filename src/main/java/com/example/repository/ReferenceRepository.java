package com.example.repository;

import com.example.dummydatabases.ReferenceDatabase;
import com.example.model.Reference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by odzhara-ongom on 01.02.2016.
 */
public class ReferenceRepository {


    private List<Reference> references= ReferenceDatabase.getAllReference();

    public boolean exists(Reference reference){
        if (reference.getId()==null) return false;
        for(Reference r:references){
            if(r.getId()!=null&&reference.getId().matches(r.getId())) return true;
        }
        return false;
    }

    public Reference read(String id){
        if(id==null) return null;
        for (Reference r:references){
            if(r.getId()!=null&&r.getId().matches(id)) return r;
        }
        return null;
    }

    public Reference create(Reference reference){
        if (reference==null) return null;
        if (reference.getId()==null){
            reference.setId(ReferenceDatabase.randomNumericString(15));
            references.add(reference);
            return reference;
        }
        Reference result=read(reference.getId());
        if(result==null) {
            references.add(reference);
            return reference;
        }
        return null;
    }

    public Reference update(Reference reference){
        if (reference==null||reference.getId()==null) return null;
        Reference result=read(reference.getId());
        if(result==null) return null;
        result.setName(reference.getName());
        result.setDescription(reference.getDescription());
        return result;
    }

    public boolean delete(Reference reference){
        if(reference==null||reference.getId()==null) return false;
        Reference r=null;
        for(int i=0; i<references.size(); i++){
            r=references.get(i);
            if(r!=null&&r.getId().matches(reference.getId())) {
                references.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Reference> getAll(){
        return references;
    }


}
