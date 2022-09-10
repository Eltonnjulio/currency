package mz.co.currency.repository;


import mz.co.currency.model.Rate;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RateRepository extends JpaRepository<Rate, Long>, JpaSpecificationExecutor<Rate> {
    Rate findByBaseCurrencyIdAndTargetCurrencyId(Long baseCurrencyId,Long targetCurrencyId);
    List<Rate> findByBaseCurrencyId(Long baseCurrencyId);

}
