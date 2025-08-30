package com.pragma.traceability.unit;


import com.pragma.traceability.domain.model.StatusOrder;
import com.pragma.traceability.domain.model.Traceability;
import com.pragma.traceability.domain.spi.ITraceabilityPersistencePort;
import com.pragma.traceability.domain.usecase.UseCaseTraceability;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class TraceabilityTest {
    @Mock
    private ITraceabilityPersistencePort iTraceabilityPersistencePort;

    @InjectMocks
    private UseCaseTraceability useCaseTraceability;

    private Traceability traceabilityOne, traceabilityTwo, traceabilitynew;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        traceabilityOne = new Traceability("32132112", 1L, 1L, "felipe@gmail.com",
                LocalDateTime.now(), null, StatusOrder.PENDING, 1L, "felipe2@gmail.com");
        traceabilityTwo = new Traceability("2312321", 2L, 2L, "sdfs@gmail.com", LocalDateTime.now(),
                StatusOrder.PENDING, StatusOrder.DISPATCHED, 2L, "sfsf2@gmail.com");
        traceabilitynew = new Traceability("32132112", 1L, 1L, "felipe@gmail.com",
                LocalDateTime.now(), null, StatusOrder.IN_PROGRESS, 1L, "felipe2@gmail.com");
    }

    @Test
    void saveTraceability() {
        when(iTraceabilityPersistencePort.findLastTraceabilityByIdOrder(1L)).thenReturn(Optional.empty());
        when(iTraceabilityPersistencePort.save(traceabilityOne)).thenReturn(traceabilityOne);
        Traceability traceabilitySaved = useCaseTraceability.saveTraceability(traceabilityOne);
        assertNotNull(traceabilitySaved);
        assertEquals(StatusOrder.PENDING, traceabilitySaved.getNewStatus());
        verify(iTraceabilityPersistencePort, times(1)).save(traceabilityOne);
    }

    @Test
    void saveTraceability_previousStatusIsPending_newStatusIsInProgress() {
        when(iTraceabilityPersistencePort.findLastTraceabilityByIdOrder(1L)).thenReturn(Optional.ofNullable(traceabilityOne));
        when(iTraceabilityPersistencePort.save(traceabilitynew)).thenReturn(traceabilitynew);
        Traceability traceabilitySaved = useCaseTraceability.saveTraceability(traceabilitynew);
        assertNotNull(traceabilitySaved);
        assertEquals(StatusOrder.IN_PROGRESS, traceabilitySaved.getNewStatus());
        verify(iTraceabilityPersistencePort, times(1)).save(traceabilitynew);
    }

    @Test
    void saveTraceability_previousStatusIsInProgress_newStatusIsReady() {
        traceabilitynew.setNewStatus(StatusOrder.DISH_READY);
        when(iTraceabilityPersistencePort.findLastTraceabilityByIdOrder(2L)).thenReturn(Optional.ofNullable(traceabilitynew));
        when(iTraceabilityPersistencePort.save(traceabilityTwo)).thenReturn(traceabilityTwo);
        Traceability traceabilitySaved = useCaseTraceability.saveTraceability(traceabilityTwo);
        assertNotNull(traceabilitySaved);
        assertEquals(StatusOrder.DISPATCHED, traceabilitySaved.getNewStatus());
        verify(iTraceabilityPersistencePort, times(1)).save(traceabilityTwo);
    }
}