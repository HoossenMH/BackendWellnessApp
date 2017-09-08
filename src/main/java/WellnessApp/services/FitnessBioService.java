package WellnessApp.services;

import WellnessApp.domain.FitnessBio;

/**
 * Created by Hasan on 8/13/2017.
 */
public interface FitnessBioService {
    FitnessBio create(FitnessBio fitnessBio);

    FitnessBio read(String id);

    FitnessBio update(FitnessBio fitnessBio);

    void delete(String id);

    FitnessBio readById(String id);
}
