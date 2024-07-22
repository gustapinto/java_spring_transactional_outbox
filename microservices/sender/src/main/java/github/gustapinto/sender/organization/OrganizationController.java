package github.gustapinto.sender.organization;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import github.gustapinto.sender.organization.dto.CreateOrganizationDto;
import github.gustapinto.sender.organization.dto.UpdateOrganizationDto;

@Controller(value = "/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping
    public Organization create(@RequestBody CreateOrganizationDto createOrganizationDto) {
        return this.organizationService.create(createOrganizationDto);
    }

    @PatchMapping("/{id}")
    public Organization update(
            @PathVariable(required = true) Integer id,
            @RequestBody UpdateOrganizationDto updateOrganizationDto) {
        updateOrganizationDto.setId(id);

        return this.organizationService.update(updateOrganizationDto);
    }

    @GetMapping
    public List<Organization> findAll() {
        return this.organizationService.findAll();
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable(required = true) Integer id) {
        return this.organizationService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(required = true) Integer id) {
        this.organizationService.deleteById(id);
    }
}
