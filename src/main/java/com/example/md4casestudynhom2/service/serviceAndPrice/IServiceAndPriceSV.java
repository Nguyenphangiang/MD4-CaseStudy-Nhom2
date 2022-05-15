package com.example.md4casestudynhom2.service.serviceAndPrice;

import com.example.md4casestudynhom2.model.svAndP.ServiceAndPrice;
import com.example.md4casestudynhom2.service.IGeneralService;

public interface IServiceAndPriceSV extends IGeneralService<ServiceAndPrice> {
    Iterable<ServiceAndPrice> getNameAndPrice(Long idSp);
}
