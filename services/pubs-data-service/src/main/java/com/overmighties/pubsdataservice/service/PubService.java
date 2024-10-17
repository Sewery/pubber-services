package com.overmighties.pubsdataservice.service;

import com.overmighties.pubsdataservice.controller.clientdto.PubClientDto;
import com.overmighties.pubsdataservice.controller.clientdto.mappers.PubClientDtoMapper;
import com.overmighties.pubsdataservice.exception.EntityIdNotFoundException;
import com.overmighties.pubsdataservice.model.Pub;
import com.overmighties.pubsdataservice.repository.PubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PubService {
    private final PubRepository pubRepository;
    @Cacheable(value = "PubsCache")
    public List<PubClientDto> getPubDtoListOptimized()
    {
        List<Pub> pubs =pubRepository.findAllPubsFetchOpeningHours();
        //pubRepository.findAllPubsFetchPhotos();
        //pubRepository.findAllPubsFetchRating();
        pubRepository.findAllPubsFetchDrinks();
        return PubClientDtoMapper.mapToDtoList(pubs);
    }
    public List<PubClientDto> getPubDtoListOptimized(String city)
    {
        List<Pub> pubs = pubRepository.findAllPubsFetchOpeningHours(city);
        pubRepository.findAllPubsFetchDrinks(city);
        return PubClientDtoMapper.mapToDtoList(pubs);
    }
    public List<PubClientDto> getPubDtoList()
    {
        return PubClientDtoMapper.mapToDtoList(pubRepository.findAll());
    }
    public PubClientDto getPubById(Long id)
    {
        return PubClientDtoMapper.mapToDto( pubRepository.findById(id).orElseThrow(()->new EntityIdNotFoundException(Pub.class,id)));
    }

}
