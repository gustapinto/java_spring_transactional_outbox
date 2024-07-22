package github.gustapinto.sender.organization;

import org.springframework.stereotype.Service;

import github.gustapinto.sender.organization.dto.CreateOrganizationDto;
import github.gustapinto.sender.organization.dto.UpdateOrganizationDto;
import github.gustapinto.sender.organization.exception.OrganizationNotFoundException;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organization create(CreateOrganizationDto createOrganizationDto) throws IllegalArgumentException {
        createOrganizationDto.validate();

        var organization = new Organization();
        organization.setName(createOrganizationDto.getName());
        organization.setEmail(createOrganizationDto.getEmail());

        this.organizationRepository.save(organization);

        return organization;
    }

    public Organization update(UpdateOrganizationDto updateOrganizationDto)
            throws OrganizationNotFoundException, IllegalArgumentException {
        updateOrganizationDto.validate();

        Organization organization = this.findById(updateOrganizationDto.getId());

        organization.setName(updateOrganizationDto.getName());
        organization.setUpdatedAt(Instant.now());

        this.organizationRepository.save(organization);

        return organization;
    }

    public List<Organization> findAll() {
        return this.organizationRepository.findAll();
    }

    public Organization findById(Integer id) throws OrganizationNotFoundException {
        Optional<Organization> maybeOrganization = this.organizationRepository.findById(id);
        Organization organization = maybeOrganization.orElseThrow(OrganizationNotFoundException::make);

        return organization;
    }

    public void deleteById(Integer id) {
        this.organizationRepository.deleteById(id);
    }
}
