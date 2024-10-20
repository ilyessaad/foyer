package tn.esprit.tpfoyer.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;
import tn.esprit.tpfoyer.service.FoyerServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class FoyerServiceImplMock {
    @Mock
    FoyerRepository foyerRepository;
    @InjectMocks
    FoyerServiceImpl foyerService;

    Foyer foyer = new Foyer("F1", 20L);
    List<Foyer> listUsers = new ArrayList<Foyer>() {
        {
            add(new Foyer("f2",25L ));
            add(new Foyer("f3",30L ));
        }
    };
    @Test
    public void testRetrieveFoyer() {
        Mockito.when(foyerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(foyer))
        ;
        Foyer foyer1 = foyerService.retrieveFoyer(2L);
        Assertions.assertNotNull(foyer1);
    }
}
