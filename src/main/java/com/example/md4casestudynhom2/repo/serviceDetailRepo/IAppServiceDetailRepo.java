package com.example.md4casestudynhom2.repo.serviceDetailRepo;

import com.example.md4casestudynhom2.model.AppService;
import com.example.md4casestudynhom2.model.ServiceDetail;

import com.example.md4casestudynhom2.model.serviceDetail.AppServiceDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAppServiceDetailRepo extends CrudRepository<ServiceDetail, Long> {
    @Query(nativeQuery = true,value = "   select s.name as name, p.price as price from suppliers join supplier_service ss on suppliers.id = ss.supplier_id\n" +
            "           join price p on ss.service_id = p.service_id and ss.supplier_id = p.supplier_id\n" +
            "           join services s  on ss.service_id = s.id where suppliers.id=? and p.service_id =?;")
    Optional<AppServiceDetail> findPriceByServiceIdAndSupplierId(Long idSupplier, Long idService);
}
