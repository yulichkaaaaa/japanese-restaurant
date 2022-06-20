package com.yuliana.japaneserestaurant.web.controller;

import com.yuliana.japaneserestaurant.service.PromoCodeService;
import com.yuliana.japaneserestaurant.service.dto.PromoCodeDto;
import com.yuliana.japaneserestaurant.service.exception.NotValidFieldsException;
import com.yuliana.japaneserestaurant.service.validator.PromoCodeValidator;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/promo_codes")
public class PromoCodeController {
    private final PromoCodeService promoCodeService;
    private final PromoCodeValidator promoCodeValidator;

    public PromoCodeController(PromoCodeService promoCodeService, PromoCodeValidator promoCodeValidator) {
        this.promoCodeService = promoCodeService;
        this.promoCodeValidator = promoCodeValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(promoCodeValidator);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
       promoCodeService.deletePromoCode(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid PromoCodeDto promoCodeDto,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new NotValidFieldsException(bindingResult);
        }

        promoCodeService.addPromoCode(promoCodeDto);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id,
                       @RequestBody @Valid PromoCodeDto promoCodeDto,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new NotValidFieldsException(bindingResult);
        }

        promoCodeDto.setId(id);
        promoCodeService.editPromoCode(promoCodeDto);

    }

    @GetMapping
    public List<PromoCodeDto> findAll(@RequestParam(defaultValue = "") String sortCriteria,
                                      @RequestParam(defaultValue = "asc") String sortDirection) {
        return promoCodeService.findAllPromoCodes(sortCriteria, sortDirection);
    }

    @GetMapping("/{id}")
    public PromoCodeDto findAllById(@PathVariable int id) {
        return promoCodeService.findPromoCodeById(id);
    }
}
