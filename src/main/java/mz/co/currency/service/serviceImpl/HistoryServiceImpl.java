package mz.co.currency.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import mz.co.currency.DTO.query.HistoryQuery;
import mz.co.currency.DTO.query.gateway.HistoryQueryGateway;
import mz.co.currency.DTO.response.HistoryJson;
import mz.co.currency.model.History;
import mz.co.currency.repository.HistoryRepository;
import mz.co.currency.service.HistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final HistoryQueryGateway queryGateway;
    private final HistoryRepository repository;
    @Override
    public boolean addHistory(History history) {
        return repository.save(history).getId() != null;
    }

    @Override
    public Page<HistoryJson> getRateHistory(Pageable pageable, HistoryQuery historyQuery, Long rateId) {
        return queryGateway.executeQuery(pageable,historyQuery,rateId);
    }
}
