package com.yuliana.japaneserestaurant.service;

import com.yuliana.japaneserestaurant.service.dto.PromoCodeDto;

import java.util.List;

public interface PromoCodeService {
    /**
     * Find promo code by its name. Validate promo code name.
     *
     * @param name name of the promo code
     * @return the {@code PromoCode} object
     */
    PromoCodeDto findPromoCodeByName(String name);

    /**
     * Delete the promo code by its id.
     *
     * @param promoCodeId id of the promo code
     */
    void deletePromoCode(int promoCodeId);

    /**
     * Find promo code by its name part. Validate user's input.
     *
     * @param namePart part of the promo code's name
     * @return list of the promo codes
     */
    List<PromoCodeDto> findPromoCodesByNamePart(String namePart);

    /**
     * Find promo code by its id
     *
     * @param promoCodeId id of the promo code
     * @return the {@code PromoCodeDto} object
     */
    PromoCodeDto findPromoCodeById(int promoCodeId);

    /**
     * Add new promo code. Validate the fields.
     *
     * @param promoCodeDto the {@code PromoCodeDto} object
     * @return id of the added promo code
     */
    int addPromoCode(PromoCodeDto promoCodeDto);

    /**
     * Find all the promo codes.
     *
     * @return list of the promo codes
     */
    List<PromoCodeDto> findAllPromoCodes(String sortType, String sortDirection);

    /**
     * Edit promo code. Validate the fields.
     *
     * @param promoCodeDto the {@code PromoCodeDto} object
     */
    void editPromoCode(PromoCodeDto promoCodeDto);
}
