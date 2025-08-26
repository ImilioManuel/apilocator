package ao.co.amc.APILocator.repository;

import ao.co.amc.APILocator.model.Church;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChurchRepository extends JpaRepository<Church, UUID> {
}
