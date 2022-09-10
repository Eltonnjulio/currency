package mz.co.currency.service;


import mz.co.currency.DTO.query.HistoryQuery;
import mz.co.currency.DTO.response.HistoryJson;
import mz.co.currency.model.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HistoryService {
    boolean addHistory(History history);
    Page<HistoryJson> getRateHistory(Pageable pageable, HistoryQuery historyQuery, Long rateId);
}
