package com.lockitem.storeManagement.infrastructure.repository;

import com.lockitem.storeManagement.application.dto.StoreRequestDTO;
import com.lockitem.storeManagement.application.dto.StoreResponseDTO;
import com.lockitem.storeManagement.application.service.IStoreService;
import com.lockitem.storeManagement.domain.entity.Store;
import com.lockitem.storeManagement.domain.mapper.StoreMapper;
import com.lockitem.storeManagement.domain.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements IStoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    // Inyección por constructor
    public StoreServiceImpl(StoreRepository storeRepository, StoreMapper storeMapper) {
        this.storeRepository = storeRepository;
        this.storeMapper = storeMapper;
    }

    @Override
    public StoreResponseDTO create(StoreRequestDTO storeRequestDTO) {
        Store store = storeMapper.toEntity(storeRequestDTO);
        Store savedStore = storeRepository.save(store);
        return storeMapper.toDTO(savedStore);
    }

    @Override
    public Optional<StoreResponseDTO> findById(Long id) {
        return storeRepository.findById(id)
                .map(storeMapper::toDTO);
    }

    @Override
    public List<StoreResponseDTO> findAll() {
        return storeRepository.findAll().stream()
                .map(storeMapper::toDTO)
                .collect(Collectors.toList());
    }
}
