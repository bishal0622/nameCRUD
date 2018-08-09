package com.example.biddemo.demobid;

import java.util.List;

public interface NameService {
    public void save(NameDTO nameDTO);
    public void update(NameDTO nameDTO,Long id);
    public void delete(Long id);
    public Name getOne(Long id);
    public List<Name> getAll();
}
