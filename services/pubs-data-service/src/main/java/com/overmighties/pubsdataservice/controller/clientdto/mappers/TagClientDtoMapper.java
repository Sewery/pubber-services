package com.overmighties.pubsdataservice.controller.clientdto.mappers;



import com.overmighties.pubsdataservice.controller.clientdto.TagClientDto;
import com.overmighties.pubsdataservice.model.Tag;

import java.util.List;

public class TagClientDtoMapper {
    private TagClientDtoMapper() {
        throw new IllegalStateException("Utility class, calling constructor forbidden");
    }
    public static List<TagClientDto> mapToDtoList(List<Tag> tags)
    {
        return null==tags?null:tags.stream()
                .map(TagClientDtoMapper::mapToDto)
                .toList();
    }
    public static TagClientDto mapToDto(Tag tag)
    {
        return TagClientDto.builder()
                .name(tag.getName())
                .build();
    }
}
