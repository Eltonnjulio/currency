package mz.co.currency.repository;


import mz.co.currency.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HistoryRepository extends JpaRepository<History, Long>, JpaSpecificationExecutor<History> {
}
