package com.overmighties.pubsdataservice.controller.clientdto.mappers;

import com.overmighties.pubsdataservice.controller.clientdto.PhotoClientDto;
import com.overmighties.pubsdataservice.model.Photo;

import java.util.List;

public class PhotoClientDtoMapper {
    private PhotoClientDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    public static List<PhotoClientDto> mapToDtoList(List<Photo> photos)
    {
        return null==photos?null:photos.stream()
                .map(PhotoClientDtoMapper::mapToDto)
                .toList();
    }
    public static PhotoClientDto mapToDto(Photo photo)
    {
        return PhotoClientDto.builder()
                .photoUrl(photo.getPhotoUrl())
                .title(photo.getTitle())
                .build();
    }
}
