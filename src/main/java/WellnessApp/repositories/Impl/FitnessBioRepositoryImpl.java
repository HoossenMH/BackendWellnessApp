package WellnessApp.repositories.Impl;

import WellnessApp.domain.FitnessBio;
import WellnessApp.repositories.FitnessBioRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hasan on 8/13/2017.
 */
public class FitnessBioRepositoryImpl //implements FitnessBioRepository
{

    private static FitnessBioRepositoryImpl respository = null;

    private Map<String,FitnessBio> fitnessBioTable;

    private FitnessBioRepositoryImpl() {
        fitnessBioTable = new HashMap<String, FitnessBio>();
    }

    public static FitnessBioRepositoryImpl getInstance(){
        if(respository==null)
            respository = new FitnessBioRepositoryImpl();
        return respository;
    }

    public FitnessBio create(FitnessBio fitnessBio) {
        fitnessBioTable.put(fitnessBio.getId(),fitnessBio);
        FitnessBio savedFitnessBio = fitnessBioTable.get(fitnessBio.getId());
        return savedFitnessBio;
    }

    public FitnessBio read(String id) {
        FitnessBio fitnessBio = fitnessBioTable.get(id);
        return fitnessBio;
    }

    public FitnessBio update(FitnessBio fitnessBio) {
        fitnessBioTable.put(fitnessBio.getId(),fitnessBio);
        FitnessBio savedFitnessBio = fitnessBioTable.get(fitnessBio.getId());
        return savedFitnessBio;
    }

    public void delete(String id) {
        fitnessBioTable.remove(id);

    }
}
