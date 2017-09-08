package WellnessApp.repositories;

import WellnessApp.domain.FitnessBio;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Hasan on 8/13/2017.
 */
public interface FitnessBioRepository extends CrudRepository<FitnessBio, String> {
    FitnessBio create(FitnessBio fitnessBio);

    FitnessBio read(String id);

    FitnessBio update(FitnessBio fitnessBio);

    void delete(String id);
}
