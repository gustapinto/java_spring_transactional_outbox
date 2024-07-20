package github.gustapinto.sender.service;

import github.gustapinto.sender.model.Organization;
import github.gustapinto.sender.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organization create(String name, String email) {
        var organization = new Organization();
        organization.setName(name);
        organization.setEmail(email);

        this.organizationRepository.save(organization);

        return organization;
    }

    public List<Organization> getAll() {
        return this.organizationRepository.findAll();
    }
}
