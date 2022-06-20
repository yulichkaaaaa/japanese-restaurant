package com.yuliana.japaneserestaurant.service.dto.converter;

import com.yuliana.japaneserestaurant.persistence.entity.PromoCode;
import com.yuliana.japaneserestaurant.service.dto.PromoCodeDto;
import org.springframework.stereotype.Component;

@Component
public class PromoCodeDtoConverter implements DtoConverter<PromoCodeDto, PromoCode> {
    @Override
    public PromoCodeDto convertToDto(PromoCode promoCode) {
        return new PromoCodeDto(
                promoCode.getPromoCodeId(),
                promoCode.getName(),
                promoCode.getDiscountPercents());
    }

    @Override
    public PromoCode convertToEntity(PromoCodeDto promoCodeDto) {
        return new PromoCode(
                promoCodeDto.getId(),
                promoCodeDto.getName(),
                promoCodeDto.getDiscountPercents());
    }
}
