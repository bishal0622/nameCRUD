package com.example.biddemo.demobid;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NameServiceImpl implements NameService {
    private NameRepository nameRepository;

    public NameServiceImpl(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    @Override
    public void save(NameDTO nameDTO) {
        Name name = new Name();
        name.setName(nameDTO.getName());
        nameRepository.save(name);
    }

    @Override
    public void update(NameDTO nameDTO, Long id) {
        Name name = nameRepository.findById(id).get();
        name.setName(nameDTO.getName());
        nameRepository.save(name);
    }

    @Override
    public void delete(Long id) {
        nameRepository.deleteById(id);
    }

    @Override
    public Name getOne(Long id) {
        return nameRepository.findById(id).get();
    }

    @Override
    public List<Name> getAll() {
        return nameRepository.findAll();
    }
}
