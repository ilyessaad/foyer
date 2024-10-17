package tn.esprit.tpfoyer.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BlocServiceImplMockTest {
    @Mock
    BlocRepository blocRepository ;
    @InjectMocks
    BlocServiceImpl blocService ;
    Bloc bloc =new Bloc();
    List<Bloc> listBloc =new ArrayList<Bloc>(){
        {
            add(new Bloc());
            add(new Bloc());

        }

    };

    @Test
     void testRetreiveBloc(){
        Mockito.when(blocRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(bloc));
        Bloc bloc1 = blocService.retrieveBloc(1L);
        Assertions.assertNotNull(bloc1);
    }

    @Test
     void testAddBloc() {
        Mockito.when(blocRepository.save(Mockito.any(Bloc.class))).thenReturn(bloc);
        Bloc savedBloc = blocService.addBloc(bloc);
        Assertions.assertNotNull(savedBloc);
    }

    @Test
     void testModifyBloc() {
        Mockito.when(blocRepository.save(Mockito.any(Bloc.class))).thenReturn(bloc);
        Bloc updatedBloc = blocService.modifyBloc(bloc);
        Assertions.assertNotNull(updatedBloc);
    }
    @Test
     void testRemoveBloc() {
        blocService.removeBloc(1L);
        Mockito.verify(blocRepository, Mockito.times(1)).deleteById(1L);
    }
}
