package com.example.md4casestudynhom2.service.serviceDetailService;

import com.example.md4casestudynhom2.model.AppService;
import com.example.md4casestudynhom2.model.ServiceDetail;
import com.example.md4casestudynhom2.model.serviceDetail.AppServiceDetail;
import com.example.md4casestudynhom2.repo.serviceDetailRepo.IAppServiceDetailRepo;
import com.example.md4casestudynhom2.service.IGeneralService;

import java.util.Optional;

public interface IServiceDetailService extends IGeneralService<ServiceDetail> {
    Optional<AppServiceDetail> findPriceByServiceIdAndSupplierId(Long idSupplier, Long idService);
}
