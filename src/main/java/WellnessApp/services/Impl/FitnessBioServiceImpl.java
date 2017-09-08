package WellnessApp.services.Impl;

import WellnessApp.domain.FitnessBio;
import WellnessApp.repositories.FitnessBioRepository;
import WellnessApp.repositories.Impl.FitnessBioRepositoryImpl;
import WellnessApp.services.FitnessBioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Hasan on 8/13/2017.
 */
@Component
public class FitnessBioServiceImpl implements FitnessBioService {

    @Autowired
    private static FitnessBioServiceImpl service = null;

    @Autowired
    FitnessBioRepository repository = FitnessBioRepositoryImpl.getInstance();

    public static FitnessBioServiceImpl getInstance(){
        if(service == null)
            service = new FitnessBioServiceImpl();
        return service;
    }

    public FitnessBio create(FitnessBio fitnessBio) {
        return repository.create(fitnessBio);
    }

    public FitnessBio read(String id) {
        return repository.read(id);
    }

    public FitnessBio update(FitnessBio fitnessBio) {
        return repository.update(fitnessBio);
    }

    public void delete(String id) {
        repository.delete(id);

    }
    @Override
    public FitnessBio findById(String s) {
        return repository.findOne(s);
    }
}