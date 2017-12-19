package com.pz.Converter;

/**
 * Created by Marcin on 19.12.2017.
 */
public interface DefaultConverter<Entity, Dto> {

    Entity convertToEntity(Dto dto);

    Dto convertToDto(Entity entity);
}
