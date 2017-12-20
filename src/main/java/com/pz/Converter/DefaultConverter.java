package com.pz.Converter;


public interface DefaultConverter<Entity, Dto> {

    Entity convertToEntity(Dto dto);

    Dto convertToDto(Entity entity);
}
