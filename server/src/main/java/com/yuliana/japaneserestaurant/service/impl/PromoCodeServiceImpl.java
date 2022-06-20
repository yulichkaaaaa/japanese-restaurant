package com.yuliana.japaneserestaurant.service.impl;

import com.yuliana.japaneserestaurant.persistence.entity.PromoCode;
import com.yuliana.japaneserestaurant.persistence.repository.PromoCodeRepository;
import com.yuliana.japaneserestaurant.service.PromoCodeService;
import com.yuliana.japaneserestaurant.service.dto.PromoCodeDto;
import com.yuliana.japaneserestaurant.service.dto.converter.PromoCodeDtoConverter;
import com.yuliana.japaneserestaurant.service.exception.NoSuchResourceException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PromoCodeServiceImpl implements PromoCodeService {

    private final PromoCodeRepository promoCodeRepository;
    private final PromoCodeDtoConverter promoCodeConverter;

    public PromoCodeServiceImpl(PromoCodeRepository promoCodeRepository, PromoCodeDtoConverter promoCodeConverter) {
        this.promoCodeRepository = promoCodeRepository;
        this.promoCodeConverter = promoCodeConverter;
    }

    @Override
    public PromoCodeDto findPromoCodeByName(String name) {
        Optional<PromoCode> promoCode = promoCodeRepository.findByName(name);
        return promoCode.map(promoCodeConverter::convertToDto).orElseThrow();
    }

    @Override
    public void deletePromoCode(int promoCodeId) {
        if (promoCodeRepository.findById(promoCodeId).isEmpty()) {
            throw new NoSuchResourceException();
        }

        promoCodeRepository.deleteById(promoCodeId);
    }

    @Override
    public List<PromoCodeDto> findPromoCodesByNamePart(String namePart) {
        return promoCodeRepository
                .findByNameLike(namePart)
                .stream()
                .map(promoCodeConverter::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PromoCodeDto findPromoCodeById(int promoCodeId) {
        Optional<PromoCode> promoCode = promoCodeRepository.findById(promoCodeId);

        return promoCode.map(promoCodeConverter::convertToDto).orElseThrow();
    }

    @Override
    public int addPromoCode(PromoCodeDto promoCodeDto) {
        if (promoCodeRepository.findById(promoCodeDto.getId()).isPresent()) {
            throw new ResolutionException();
        }

        return promoCodeRepository
                .save(promoCodeConverter.convertToEntity(promoCodeDto))
                .getPromoCodeId();
    }

    @Override
    public List<PromoCodeDto> findAllPromoCodes(String sortType, String sortDirection) {
        List<PromoCode> promoCodes;
        if(sortType != null && !sortType.isBlank()) {
            Sort sort = Sort.by(sortDirection.equals("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sortType);
            promoCodes = (List<PromoCode>) promoCodeRepository.findAll(sort);
        } else {
            promoCodes = (List<PromoCode>) promoCodeRepository.findAll();
        }

        return promoCodes.stream().map(promoCodeConverter::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void editPromoCode(PromoCodeDto promoCodeDto) {
        if (promoCodeRepository.findById(promoCodeDto.getId()).isEmpty()) {
            throw new ResolutionException();
        }

        promoCodeRepository.save(promoCodeConverter.convertToEntity(promoCodeDto));
    }
}
