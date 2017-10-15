package WellnessApp.services.Impl;

import WellnessApp.domain.FitnessBio;
import WellnessApp.repositories.FitnessBioRepository;
import WellnessApp.repositories.Impl.FitnessBioRepositoryImpl;
import WellnessApp.services.FitnessBioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hasan on 8/13/2017.
 */
@Component
public class FitnessBioServiceImpl implements FitnessBioService {

    @Autowired
    private FitnessBioRepository fitnessBioRepository;
    @Override
    public FitnessBio create(FitnessBio fitnessBio) {
        return fitnessBioRepository.save(fitnessBio);
    }
    @Override
    public FitnessBio readById(String id) {
        return fitnessBioRepository.findOne(id);
    }
    @Override
    public Set<FitnessBio> readAll() {
        Set<FitnessBio> result = new HashSet<FitnessBio>();
        while (fitnessBioRepository.findAll().iterator().hasNext()) {
            result.add(fitnessBioRepository.findAll().iterator().next());
        }
        return result;
    }
    @Override
    public FitnessBio update(FitnessBio fitnessBio) {
        return fitnessBioRepository.save(fitnessBio);
    }
    @Override
    public void delete(FitnessBio id) { fitnessBioRepository.delete(id); }
}